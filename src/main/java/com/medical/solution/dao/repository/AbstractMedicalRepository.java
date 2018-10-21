package com.medical.solution.dao.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

import org.apache.log4j.Logger;

import com.medical.solution.dao.MySQLTemplate;
import com.medical.solution.model.common.Persistable;

public abstract class AbstractMedicalRepository {

	public static final TimeUnit READ_LOCK_ACQUIRE_WAIT_TIME_UNIT = TimeUnit.SECONDS;
	public static final int READ_LOCK_ACQUIRE_WAIT_TIME = 10;
	private Logger LOG = Logger.getLogger(AbstractMedicalRepository.class);
	private MySQLTemplate mySQLTemplate;

	public AbstractMedicalRepository(MySQLTemplate mySQLTemplate) {
		this.mySQLTemplate = mySQLTemplate;
	}

	protected <T extends Persistable> List<T> getEntities(String tableName, Lock readLock, boolean isExpirableEntity,
			Class<T> classOfT) {

		if (isExpirableEntity) {
			return null;
		}
		List<T> entities = null;
		boolean isAcquired = false;

		try {
			isAcquired = readLock.tryLock(READ_LOCK_ACQUIRE_WAIT_TIME, READ_LOCK_ACQUIRE_WAIT_TIME_UNIT);
			if (isAcquired) {
				entities = mySQLTemplate.getAllRecords(tableName, classOfT);
			}
		} catch (Throwable e) {
			LOG.error("Exception " + classOfT.toString() + " " + e.getMessage());
		} finally {
			if (isAcquired) {
				try {
					readLock.unlock();
				} catch (Throwable e) {
					LOG.error("::::Unable to release lock:::: " + e.getMessage());
				}
			}
		}
		return entities;
	}
}

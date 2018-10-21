package com.medical.solution.dao.repository;

import static com.medical.solution.constant.Constants.GET_MEDICAL_OBJECT;
import static com.medical.solution.constant.Constants.MEDICAL_SOLUTION_TABLES;

import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.medical.solution.dao.MySQLTemplate;
import com.medical.solution.model.Appointment;
import com.medical.solution.model.Calendar;
import com.medical.solution.model.Cases;
import com.medical.solution.model.Contact;
import com.medical.solution.model.Doctor;
import com.medical.solution.model.Expertise;
import com.medical.solution.model.Login;
import com.medical.solution.model.Message;
import com.medical.solution.model.Notification;
import com.medical.solution.model.Patient;
import com.medical.solution.model.TodoList;
import com.medical.solution.model.common.Persistable;;

@Repository
public class MedicalRepository extends AbstractMedicalRepository {

	@Autowired
	public MedicalRepository(MySQLTemplate mySQLTemplate) {
		super(mySQLTemplate);
	}

	private static final Logger LOG = Logger.getLogger(MedicalRepository.class);

	private ReadWriteLock doctorReadWriteLock = new ReentrantReadWriteLock(true);
	private ReadWriteLock patientReadWriteLock = new ReentrantReadWriteLock(true);
	private ReadWriteLock appointmentReadWriteLock = new ReentrantReadWriteLock(true);
	private ReadWriteLock casesReadWriteLock = new ReentrantReadWriteLock(true);
	private ReadWriteLock loginReadWriteLock = new ReentrantReadWriteLock(true);
	private ReadWriteLock contactReadWriteLock = new ReentrantReadWriteLock(true);
	private ReadWriteLock messageReadWriteLock = new ReentrantReadWriteLock(true);
	private ReadWriteLock notificationReadWriteLock = new ReentrantReadWriteLock(true);
	private ReadWriteLock expertiseReadWriteLock = new ReentrantReadWriteLock(true);
	private ReadWriteLock calendarReadWriteLock = new ReentrantReadWriteLock(true);
	private ReadWriteLock todoListReadWriteLock = new ReentrantReadWriteLock(true);

	@Autowired
	private MySQLTemplate MySQLTemplate;

	public <T extends Persistable> boolean getAllTables(T t, Class<T> clazz) {
		String tableName = MEDICAL_SOLUTION_TABLES.get(clazz);
		return MySQLTemplate.createTableIfNotExist(t, tableName, clazz);

	}

	@SuppressWarnings("unchecked")
	public <T extends Persistable> boolean createMedical(Class<T> clazz) {

		LOG.info("createMedical method called");
		String tableName = MEDICAL_SOLUTION_TABLES.get(clazz);
		T t = (T) GET_MEDICAL_OBJECT.get(clazz);
		return MySQLTemplate.createTableIfNotExist(t, tableName, clazz);
	}

	public <T extends Persistable> boolean addMedical(T t, Class<T> clazz) {

		LOG.info("addMedical method called");
		String tableName = MEDICAL_SOLUTION_TABLES.get(clazz);
		return MySQLTemplate.insert(t, tableName, clazz);

	}

	public <T extends Persistable> boolean addAllMedical(List<T> t, Class<T> clazz) {

		LOG.info("addMedical method called");
		String tableName = MEDICAL_SOLUTION_TABLES.get(clazz);
		return MySQLTemplate.insertAll(t, tableName, clazz);

	}

	/*public <T extends Persistable> List<T> getAllMedicals(Class<T> clazz) {

		LOG.info("getAllMedicals method called");
		String tableName = MEDICAL_SOLUTION_TABLES.get(clazz);
		return MySQLTemplate.getAllRecords(tableName, clazz);
	}*/

	public <T extends Persistable> T getMedical(String primaryKeyValue, Class<T> clazz) {

		LOG.info("getMedical method called");
		String tableName = MEDICAL_SOLUTION_TABLES.get(clazz);
		return MySQLTemplate.getRecordOnBasisOfId(primaryKeyValue, tableName, clazz);
	}

	public <T extends Persistable> List<T> getAllMedicals(Class<T> clazz) {

		String tableName = MEDICAL_SOLUTION_TABLES.get(clazz);
		return getEntities(tableName, getReadWriteLock(clazz).readLock(), false, clazz);
	}

	public <T extends Persistable> ReadWriteLock getReadWriteLock(Class<T> clazz) {

		if (clazz.equals(Doctor.class)) {
			return this.doctorReadWriteLock;
		} else if (clazz.equals(Patient.class)) {
			return this.patientReadWriteLock;
		} else if (clazz.equals(Appointment.class)) {
			return this.appointmentReadWriteLock;
		} else if (clazz.equals(Calendar.class)) {
			return this.calendarReadWriteLock;
		} else if (clazz.equals(Cases.class)) {
			return this.casesReadWriteLock;
		} else if (clazz.equals(Notification.class)) {
			return this.notificationReadWriteLock;
		} else if (clazz.equals(Message.class)) {
			return this.messageReadWriteLock;
		} else if (clazz.equals(Login.class)) {
			return this.loginReadWriteLock;
		} else if (clazz.equals(Expertise.class)) {
			return this.expertiseReadWriteLock;
		} else if (clazz.equals(TodoList.class)) {
			return this.todoListReadWriteLock;
		} else if (clazz.equals(Contact.class)) {
			return this.contactReadWriteLock;
		} else {
			LOG.info(":::::::No lock found:::::::");
			return null;
		}
	}
}

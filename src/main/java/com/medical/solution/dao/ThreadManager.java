package com.medical.solution.dao;

import static com.medical.solution.dao.TablesCreatedTask.CREATE_DOCTOR;
import static com.medical.solution.dao.TablesCreatedTask.CREATE_PATIENT;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ThreadManager {

	private static final Logger LOG = Logger.getLogger(ThreadManager.class);

	private ExecutorService executorService;
	private MedicalSolutionManager medicalSolutionManager;

	@Autowired
	public ThreadManager(ExecutorService executorService, MedicalSolutionManager medicalSolutionManager) {

		this.executorService = executorService;
		this.medicalSolutionManager = medicalSolutionManager;
		createTables();
	}

	public void createTables() {

		LOG.info("Started creating tables: createTables()");
		Future<Boolean> isDoctorCreated = executorService.submit(getTablesCreatedTask(CREATE_DOCTOR));
		Future<Boolean> isPatientCreated = executorService.submit(getTablesCreatedTask(CREATE_PATIENT));
		try {
			if (isDoctorCreated.get() && isPatientCreated.get()) {
				LOG.info(":::::::::Ending tables creation:::::::::::::");
			} else {
				LOG.info("::::::::::Unable to create tables:::::::::::");
			}
		} catch (InterruptedException | ExecutionException e) {
			LOG.info("Error creating table: " + e.getMessage());
		}
	}

	private CreateMedicalTables getTablesCreatedTask(TablesCreatedTask tablesCreatedTask) {
		return new CreateMedicalTables(medicalSolutionManager, tablesCreatedTask);
	}

	private class CreateMedicalTables implements Callable<Boolean> {

		private static final String TABLE_CREATED_NAME_STR = "Tables creation started: [%s]";
		private MedicalSolutionManager medicalSolutionManager;
		private TablesCreatedTask tablesCreatedTask;

		public CreateMedicalTables(MedicalSolutionManager medicalSolutionManager, TablesCreatedTask tablesCreatedTask) {

			this.medicalSolutionManager = medicalSolutionManager;
			this.tablesCreatedTask = tablesCreatedTask;
		}

		@Override
		public Boolean call() throws Exception {

			Thread.currentThread().setName(String.format(TABLE_CREATED_NAME_STR, tablesCreatedTask));

			switch (tablesCreatedTask) {

			case CREATE_DOCTOR:
				medicalSolutionManager.createDoctorTable();
				return true;

			case CREATE_PATIENT:
				medicalSolutionManager.createPatientTable();
				return true;
			}
			return false;
		}

	}
}

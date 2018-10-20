package com.medical.solution.dao;

import static com.medical.solution.dao.TablesCreatedTask.CREATE_APPOINTMENT;
import static com.medical.solution.dao.TablesCreatedTask.CREATE_CALENDAR;
import static com.medical.solution.dao.TablesCreatedTask.CREATE_CASES;
import static com.medical.solution.dao.TablesCreatedTask.CREATE_CONTACT;
import static com.medical.solution.dao.TablesCreatedTask.CREATE_DOCTOR;
import static com.medical.solution.dao.TablesCreatedTask.CREATE_EXPERTISE;
import static com.medical.solution.dao.TablesCreatedTask.CREATE_LOGIN;
import static com.medical.solution.dao.TablesCreatedTask.CREATE_MESSAGE;
import static com.medical.solution.dao.TablesCreatedTask.CREATE_NOTIFICATION;
import static com.medical.solution.dao.TablesCreatedTask.CREATE_PATIENT;
import static com.medical.solution.dao.TablesCreatedTask.CREATE_TODO_LIST;

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
		LOG.info(":::::::::Started tables creation:::::::::::::");
		Future<Boolean> isDoctorCreated = executorService.submit(getTablesCreatedTask(CREATE_DOCTOR));
		Future<Boolean> isPatientCreated = executorService.submit(getTablesCreatedTask(CREATE_PATIENT));
		Future<Boolean> isAppointmentCreated = executorService.submit(getTablesCreatedTask(CREATE_APPOINTMENT));
		Future<Boolean> isCasesCreated = executorService.submit(getTablesCreatedTask(CREATE_CASES));
		Future<Boolean> isCalendarCreated = executorService.submit(getTablesCreatedTask(CREATE_CALENDAR));
		Future<Boolean> isContactCreated = executorService.submit(getTablesCreatedTask(CREATE_CONTACT));
		Future<Boolean> isMessageCreated = executorService.submit(getTablesCreatedTask(CREATE_MESSAGE));
		Future<Boolean> isNotificationCreated = executorService.submit(getTablesCreatedTask(CREATE_NOTIFICATION));
		Future<Boolean> isTodoListCreated = executorService.submit(getTablesCreatedTask(CREATE_TODO_LIST));
		Future<Boolean> isLoginCreated = executorService.submit(getTablesCreatedTask(CREATE_LOGIN));
		Future<Boolean> isExpertiseCreated = executorService.submit(getTablesCreatedTask(CREATE_EXPERTISE));
		try {
			if (isDoctorCreated.get() && isPatientCreated.get() && isAppointmentCreated.get() && isCasesCreated.get()
					&& isCalendarCreated.get() && isContactCreated.get() && isMessageCreated.get()
					&& isNotificationCreated.get() && isTodoListCreated.get() && isLoginCreated.get()
					&& isExpertiseCreated.get()) {
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
			LOG.info(":::::::::: " + Thread.currentThread().getName() + " :::::::::::");
			switch (tablesCreatedTask) {

			case CREATE_DOCTOR:
				medicalSolutionManager.createDoctorTable();
				return true;

			case CREATE_PATIENT:
				medicalSolutionManager.createPatientTable();
				return true;

			case CREATE_APPOINTMENT:
				medicalSolutionManager.createAppointmentTable();
				return true;

			case CREATE_CALENDAR:
				medicalSolutionManager.createCalendarTable();
				return true;

			case CREATE_CASES:
				medicalSolutionManager.createCasesTable();
				return true;

			case CREATE_CONTACT:
				medicalSolutionManager.createContactTable();
				return true;

			case CREATE_EXPERTISE:
				medicalSolutionManager.createExpertiseTable();
				return true;

			case CREATE_LOGIN:
				medicalSolutionManager.createLoginTable();
				return true;

			case CREATE_MESSAGE:
				medicalSolutionManager.createMessageTable();
				return true;

			case CREATE_NOTIFICATION:
				medicalSolutionManager.createNotificationTable();
				return true;

			case CREATE_TODO_LIST:
				medicalSolutionManager.createTodoListTable();
				return true;

			default:
				return false;
			}
		}
		// 52510727332 SCBL0036027
	}
}

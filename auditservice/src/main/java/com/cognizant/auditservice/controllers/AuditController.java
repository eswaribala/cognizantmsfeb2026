package com.cognizant.auditservice.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.auditservice.dtos.AuditMessage;

@RestController
@RequestMapping("/audits")
public class AuditController {

	 private static final Logger logger = LoggerFactory.getLogger(AuditController.class);
     @PostMapping("/v1.0")
     public void logAudit(@RequestBody AuditMessage auditMessage) {
		String userName = auditMessage.getUserName();
		String role = auditMessage.getRole();
		String action = auditMessage.getAction();
		logger.info("Audit Log - User: {}, Role: {}, Action: {}", userName, role, action);
     }
}

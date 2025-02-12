package com.etrade.usermanagement.model.shared;

public enum Permission {
    // User management
    USER_CREATE,
    USER_READ,
    USER_UPDATE,
    USER_DELETE,

    // Role management
    ROLE_MANAGE,

    // Admin permissions
    ADMIN_DASHBOARD,
    SYSTEM_MANAGE,

    // Agent permissions
    AGENT_DASHBOARD,
    COMMISSION_MANAGE,

    // Client permissions
    CLIENT_DASHBOARD,
    PROFILE_MANAGE
}
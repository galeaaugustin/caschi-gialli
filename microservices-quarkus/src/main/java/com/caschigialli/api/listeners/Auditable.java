package com.caschigialli.api.listeners;

import com.caschigialli.api.models.Audit;

public interface Auditable {

    Audit getAudit();

    void setAudit(Audit audit);
}

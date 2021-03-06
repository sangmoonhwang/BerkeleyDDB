package org.mcgill.ecse420.f2016.Result;

import org.mcgill.ecse420.f2016.WorkerLookupComputation;

import java.io.Serializable;

/**
 * Used in communication between Master and Client.
 * Serializable because it has to be sent over the network.
 * Holds a tuple of statuses and the initialized lookup computation that the client will then use
 * to figure out which Worker to talk to
 */
public class MasterResult extends Result implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean masterStatus = true;
    private final WorkerLookupComputation computation;

    public MasterResult(boolean opStatus, boolean masterStatus, WorkerLookupComputation computation) {
        super(opStatus);
        this.masterStatus = masterStatus;
        this.computation = computation;
    }

    public WorkerLookupComputation getComputation() {
        return this.computation;
    }

    public boolean masterStatus() {
        return this.masterStatus;
    }

    public boolean noErrors() {
        return this.dbStatus && this.masterStatus;
    }
}
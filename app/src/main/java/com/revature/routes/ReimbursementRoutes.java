package com.revature.routes;

import com.revature.controllers.ReimbursementController;
import com.revature.controllers.UserController;
import io.javalin.Javalin;

public class ReimbursementRoutes extends Route{

    private ReimbursementController reimbursementController;

    public ReimbursementRoutes(ReimbursementController reimbursementController){
        this.reimbursementController = reimbursementController;
    }

    @Override
    public void registerLocalRoutes(Javalin app) {
        app.post("/reimbursement", reimbursementController.handleCreateReimbursementRecord);
        app.get("/reimbursement/pending",reimbursementController.handlerGetPendingReimbursement);
        app.get("/reimbursement/resolved",reimbursementController.handlerGetResolvedReimbursement);
    }
}

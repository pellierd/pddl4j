; IPC5 Domain: Pathways Propositional
; Authors: Yannis Dimopoulos, Alfonso Gerevini and Alessandro Saetti

(define (domain GROUNDED-PATHWAYS-PROPOSITIONAL)
(:requirements
:strips
)
(:predicates
(FOO)
(chosen_wee1)
(num-subs_l1)
(chosen_sp1)
(chosen_rpa)
(chosen_prbp2)
(chosen_prbp1-e2f4p1-dp12)
(chosen_prb-e2f4p1-dp12)
(chosen_pcna)
(chosen_m1433)
(chosen_hdac1-p130-e2f4p1-dp12)
(chosen_hdac1)
(chosen_gp)
(chosen_ge2)
(chosen_e2f6-dp12p1)
(chosen_e2f4-dp12p1)
(chosen_e2f13)
(chosen_dmp1)
(chosen_c-tak1)
(chosen_cebp)
(chosen_cdk2p1)
(chosen_cdk2)
(chosen_cdc25c)
(chosen_c-abl)
(available_wee1)
(available_sp1)
(available_rpa)
(available_prbp2)
(available_prbp1-e2f4p1-dp12)
(available_prb-e2f4p1-dp12)
(available_pcna)
(available_m1433)
(available_hdac1-p130-e2f4p1-dp12)
(available_hdac1)
(available_gp)
(available_ge2)
(available_e2f6-dp12p1)
(available_e2f4-dp12p1)
(available_e2f13)
(available_dmp1)
(available_c-tak1)
(available_cebp)
(available_cdk2p1)
(available_cdk2)
(available_cdc25c)
(available_c-abl)
(available_sp1-gp)
(available_sp1-e2f13)
(available_sp1-e2f13-gp)
(available_prbp1-e2f4p1-dp12-ge2)
(available_prb-e2f4p1-dp12-ge2)
(available_hdac1-prb-e2f4p1-dp12)
(available_hdac1-p130-e2f4p1-dp12-ge2)
(available_e2f6-dp12p1-ge2)
(available_cebp-prbp2)
(available_cebp-gp)
(available_c-abl-prbp2)
(available_cdc25cp2)
(available_pol)
(available_p19arf)
(available_p107p1)
(available_p107)
(available_cycep1)
(available_cyce)
(available_cycdp1)
(available_cycd)
(available_cyca)
(available_c-myc)
(available_p)
(goal1_)
(goal2_)
(goal4_)
(num-subs_l2)
(available_sp1-p107)
(available_sp1-p107p1)
(available_sp1-p107p1-gp)
(available_sp1-p107-gp)
(available_rpa-cyca)
(available_pcna-cycd)
(available_pcna-cycdp1)
(available_p107-e2f4-dp12p1)
(available_p107-e2f4-dp12p1-ge2)
(available_m1433-cdc25cp2)
(available_hdac1-p107-e2f4-dp12p1)
(available_dmp1-cycdp1)
(available_dmp1-cycd)
(available_cebp-prbp2-gp)
(available_cdk2p1-cycep1)
(available_cdk2p1-cyce)
(available_cdk2p1-cyca)
(available_cdk2-cycep1)
(available_cdk2-cyce)
(available_cdk2-cyca)
(goal3_)
(num-subs_l3)
(available_cdk2p1-cyca-e2f13)
(available_cdk2-cyca-e2f13)
(not-chosen_c-abl)
(not-chosen_cdc25c)
(not-chosen_cdk2)
(not-chosen_cdk2p1)
(not-chosen_cebp)
(not-chosen_c-tak1)
(not-chosen_dmp1)
(not-chosen_e2f13)
(not-chosen_e2f4-dp12p1)
(not-chosen_e2f6-dp12p1)
(not-chosen_ge2)
(not-chosen_gp)
(not-chosen_hdac1)
(not-chosen_hdac1-p130-e2f4p1-dp12)
(not-chosen_m1433)
(not-chosen_pcna)
(not-chosen_prb-e2f4p1-dp12)
(not-chosen_prbp1-e2f4p1-dp12)
(not-chosen_prbp2)
(not-chosen_rpa)
(not-chosen_sp1)
(not-chosen_wee1)
(num-subs_l0)
)
(:action dummy-action-3-1
:parameters ()
:precondition
(and
(available_cdk2-cyca-e2f13)
)
:effect
(and
(goal3_)
)
)
(:action ASSOCIATE_CDK2-CYCA_E2F13_CDK2-CYCA-E2F13
:parameters ()
:precondition
(and
(available_e2f13)
(available_cdk2-cyca)
)
:effect
(and
(available_cdk2-cyca-e2f13)
(not (available_cdk2-cyca))
(not (available_e2f13))
)
)
(:action ASSOCIATE_CDK2P1-CYCA_E2F13_CDK2P1-CYCA-E2F13
:parameters ()
:precondition
(and
(available_e2f13)
(available_cdk2p1-cyca)
)
:effect
(and
(available_cdk2p1-cyca-e2f13)
(not (available_cdk2p1-cyca))
(not (available_e2f13))
)
)
(:action CHOOSE_C-ABL_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_c-abl)
)
:effect
(and
(chosen_c-abl)
(num-subs_l3)
(not (not-chosen_c-abl))
(not (num-subs_l2))
)
)
(:action CHOOSE_CDC25C_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_cdc25c)
)
:effect
(and
(chosen_cdc25c)
(num-subs_l3)
(not (not-chosen_cdc25c))
(not (num-subs_l2))
)
)
(:action CHOOSE_CDK2_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_cdk2)
)
:effect
(and
(chosen_cdk2)
(num-subs_l3)
(not (not-chosen_cdk2))
(not (num-subs_l2))
)
)
(:action CHOOSE_CDK2P1_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_cdk2p1)
)
:effect
(and
(chosen_cdk2p1)
(num-subs_l3)
(not (not-chosen_cdk2p1))
(not (num-subs_l2))
)
)
(:action CHOOSE_CEBP_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_cebp)
)
:effect
(and
(chosen_cebp)
(num-subs_l3)
(not (not-chosen_cebp))
(not (num-subs_l2))
)
)
(:action CHOOSE_C-TAK1_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_c-tak1)
)
:effect
(and
(chosen_c-tak1)
(num-subs_l3)
(not (not-chosen_c-tak1))
(not (num-subs_l2))
)
)
(:action CHOOSE_DMP1_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_dmp1)
)
:effect
(and
(chosen_dmp1)
(num-subs_l3)
(not (not-chosen_dmp1))
(not (num-subs_l2))
)
)
(:action CHOOSE_E2F13_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_e2f13)
)
:effect
(and
(chosen_e2f13)
(num-subs_l3)
(not (not-chosen_e2f13))
(not (num-subs_l2))
)
)
(:action CHOOSE_E2F4-DP12P1_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_e2f4-dp12p1)
)
:effect
(and
(chosen_e2f4-dp12p1)
(num-subs_l3)
(not (not-chosen_e2f4-dp12p1))
(not (num-subs_l2))
)
)
(:action CHOOSE_E2F6-DP12P1_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_e2f6-dp12p1)
)
:effect
(and
(chosen_e2f6-dp12p1)
(num-subs_l3)
(not (not-chosen_e2f6-dp12p1))
(not (num-subs_l2))
)
)
(:action CHOOSE_GE2_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_ge2)
)
:effect
(and
(chosen_ge2)
(num-subs_l3)
(not (not-chosen_ge2))
(not (num-subs_l2))
)
)
(:action CHOOSE_GP_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_gp)
)
:effect
(and
(chosen_gp)
(num-subs_l3)
(not (not-chosen_gp))
(not (num-subs_l2))
)
)
(:action CHOOSE_HDAC1_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_hdac1)
)
:effect
(and
(chosen_hdac1)
(num-subs_l3)
(not (not-chosen_hdac1))
(not (num-subs_l2))
)
)
(:action CHOOSE_HDAC1-P130-E2F4P1-DP12_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_hdac1-p130-e2f4p1-dp12)
)
:effect
(and
(chosen_hdac1-p130-e2f4p1-dp12)
(num-subs_l3)
(not (not-chosen_hdac1-p130-e2f4p1-dp12))
(not (num-subs_l2))
)
)
(:action CHOOSE_M1433_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_m1433)
)
:effect
(and
(chosen_m1433)
(num-subs_l3)
(not (not-chosen_m1433))
(not (num-subs_l2))
)
)
(:action CHOOSE_PCNA_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_pcna)
)
:effect
(and
(chosen_pcna)
(num-subs_l3)
(not (not-chosen_pcna))
(not (num-subs_l2))
)
)
(:action CHOOSE_PRB-E2F4P1-DP12_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_prb-e2f4p1-dp12)
)
:effect
(and
(chosen_prb-e2f4p1-dp12)
(num-subs_l3)
(not (not-chosen_prb-e2f4p1-dp12))
(not (num-subs_l2))
)
)
(:action CHOOSE_PRBP1-E2F4P1-DP12_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_prbp1-e2f4p1-dp12)
)
:effect
(and
(chosen_prbp1-e2f4p1-dp12)
(num-subs_l3)
(not (not-chosen_prbp1-e2f4p1-dp12))
(not (num-subs_l2))
)
)
(:action CHOOSE_PRBP2_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_prbp2)
)
:effect
(and
(chosen_prbp2)
(num-subs_l3)
(not (not-chosen_prbp2))
(not (num-subs_l2))
)
)
(:action CHOOSE_RPA_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_rpa)
)
:effect
(and
(chosen_rpa)
(num-subs_l3)
(not (not-chosen_rpa))
(not (num-subs_l2))
)
)
(:action CHOOSE_SP1_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_sp1)
)
:effect
(and
(chosen_sp1)
(num-subs_l3)
(not (not-chosen_sp1))
(not (num-subs_l2))
)
)
(:action CHOOSE_WEE1_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_wee1)
)
:effect
(and
(chosen_wee1)
(num-subs_l3)
(not (not-chosen_wee1))
(not (num-subs_l2))
)
)
(:action dummy-action-4-1
:parameters ()
:precondition
(and
(available_p107-e2f4-dp12p1-ge2)
)
:effect
(and
(goal4_)
)
)
(:action dummy-action-3-2
:parameters ()
:precondition
(and
(available_sp1-p107p1-gp)
)
:effect
(and
(goal3_)
)
)
(:action dummy-action-2-1
:parameters ()
:precondition
(and
(available_dmp1-cycdp1)
)
:effect
(and
(goal2_)
)
)
(:action dummy-action-1-1
:parameters ()
:precondition
(and
(available_cdk2p1-cyca)
)
:effect
(and
(goal1_)
)
)
(:action SYNTHESIZE_CEBP-PRBP2-GP_P
:parameters ()
:precondition
(and
(available_cebp-prbp2-gp)
)
:effect
(and
(available_p)
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDK2-CYCA_WEE1_CDK2P1-CYCA
:parameters ()
:precondition
(and
(available_wee1)
(available_cdk2-cyca)
)
:effect
(and
(available_cdk2p1-cyca)
(not (available_cdk2-cyca))
)
)
(:action ASSOCIATE_CDK2_CYCA_CDK2-CYCA
:parameters ()
:precondition
(and
(available_cyca)
(available_cdk2)
)
:effect
(and
(available_cdk2-cyca)
(not (available_cdk2))
(not (available_cyca))
)
)
(:action ASSOCIATE_CDK2_CYCE_CDK2-CYCE
:parameters ()
:precondition
(and
(available_cyce)
(available_cdk2)
)
:effect
(and
(available_cdk2-cyce)
(not (available_cdk2))
(not (available_cyce))
)
)
(:action ASSOCIATE_CDK2_CYCEP1_CDK2-CYCEP1
:parameters ()
:precondition
(and
(available_cycep1)
(available_cdk2)
)
:effect
(and
(available_cdk2-cycep1)
(not (available_cdk2))
(not (available_cycep1))
)
)
(:action ASSOCIATE_CDK2P1_CYCA_CDK2P1-CYCA
:parameters ()
:precondition
(and
(available_cyca)
(available_cdk2p1)
)
:effect
(and
(available_cdk2p1-cyca)
(not (available_cdk2p1))
(not (available_cyca))
)
)
(:action ASSOCIATE_CDK2P1_CYCE_CDK2P1-CYCE
:parameters ()
:precondition
(and
(available_cyce)
(available_cdk2p1)
)
:effect
(and
(available_cdk2p1-cyce)
(not (available_cdk2p1))
(not (available_cyce))
)
)
(:action ASSOCIATE_CDK2P1_CYCEP1_CDK2P1-CYCEP1
:parameters ()
:precondition
(and
(available_cycep1)
(available_cdk2p1)
)
:effect
(and
(available_cdk2p1-cycep1)
(not (available_cdk2p1))
(not (available_cycep1))
)
)
(:action ASSOCIATE_CEBP-PRBP2_GP_CEBP-PRBP2-GP
:parameters ()
:precondition
(and
(available_gp)
(available_cebp-prbp2)
)
:effect
(and
(available_cebp-prbp2-gp)
(not (available_cebp-prbp2))
(not (available_gp))
)
)
(:action ASSOCIATE_DMP1_CYCD_DMP1-CYCD
:parameters ()
:precondition
(and
(available_cycd)
(available_dmp1)
)
:effect
(and
(available_dmp1-cycd)
(not (available_dmp1))
(not (available_cycd))
)
)
(:action ASSOCIATE_DMP1_CYCDP1_DMP1-CYCDP1
:parameters ()
:precondition
(and
(available_cycdp1)
(available_dmp1)
)
:effect
(and
(available_dmp1-cycdp1)
(not (available_dmp1))
(not (available_cycdp1))
)
)
(:action ASSOCIATE_HDAC1_P107-E2F4-DP12P1_HDAC1-P107-E2F4-DP12P1
:parameters ()
:precondition
(and
(available_p107-e2f4-dp12p1)
(available_hdac1)
)
:effect
(and
(available_hdac1-p107-e2f4-dp12p1)
(not (available_hdac1))
(not (available_p107-e2f4-dp12p1))
)
)
(:action ASSOCIATE_M1433_CDC25CP2_M1433-CDC25CP2
:parameters ()
:precondition
(and
(available_cdc25cp2)
(available_m1433)
)
:effect
(and
(available_m1433-cdc25cp2)
(not (available_m1433))
(not (available_cdc25cp2))
)
)
(:action ASSOCIATE_P107-E2F4-DP12P1_GE2_P107-E2F4-DP12P1-GE2
:parameters ()
:precondition
(and
(available_ge2)
(available_p107-e2f4-dp12p1)
)
:effect
(and
(available_p107-e2f4-dp12p1-ge2)
(not (available_p107-e2f4-dp12p1))
(not (available_ge2))
)
)
(:action ASSOCIATE_P107_E2F4-DP12P1_P107-E2F4-DP12P1
:parameters ()
:precondition
(and
(available_e2f4-dp12p1)
(available_p107)
)
:effect
(and
(available_p107-e2f4-dp12p1)
(not (available_p107))
(not (available_e2f4-dp12p1))
)
)
(:action ASSOCIATE_PCNA_CYCDP1_PCNA-CYCDP1
:parameters ()
:precondition
(and
(available_cycdp1)
(available_pcna)
)
:effect
(and
(available_pcna-cycdp1)
(not (available_pcna))
(not (available_cycdp1))
)
)
(:action ASSOCIATE_PCNA_CYCD_PCNA-CYCD
:parameters ()
:precondition
(and
(available_cycd)
(available_pcna)
)
:effect
(and
(available_pcna-cycd)
(not (available_pcna))
(not (available_cycd))
)
)
(:action ASSOCIATE_RPA_CYCA_RPA-CYCA
:parameters ()
:precondition
(and
(available_cyca)
(available_rpa)
)
:effect
(and
(available_rpa-cyca)
(not (available_rpa))
(not (available_cyca))
)
)
(:action ASSOCIATE_SP1-P107_GP_SP1-P107-GP
:parameters ()
:precondition
(and
(available_gp)
(available_sp1-p107)
)
:effect
(and
(available_sp1-p107-gp)
(not (available_sp1-p107))
(not (available_gp))
)
)
(:action ASSOCIATE_SP1-P107P1_GP_SP1-P107P1-GP
:parameters ()
:precondition
(and
(available_gp)
(available_sp1-p107p1)
)
:effect
(and
(available_sp1-p107p1-gp)
(not (available_sp1-p107p1))
(not (available_gp))
)
)
(:action ASSOCIATE_SP1_P107P1_SP1-P107P1
:parameters ()
:precondition
(and
(available_p107p1)
(available_sp1)
)
:effect
(and
(available_sp1-p107p1)
(not (available_sp1))
(not (available_p107p1))
)
)
(:action ASSOCIATE_SP1_P107_SP1-P107
:parameters ()
:precondition
(and
(available_p107)
(available_sp1)
)
:effect
(and
(available_sp1-p107)
(not (available_sp1))
(not (available_p107))
)
)
(:action CHOOSE_C-ABL_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_c-abl)
)
:effect
(and
(chosen_c-abl)
(num-subs_l2)
(not (not-chosen_c-abl))
(not (num-subs_l1))
)
)
(:action CHOOSE_CDC25C_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_cdc25c)
)
:effect
(and
(chosen_cdc25c)
(num-subs_l2)
(not (not-chosen_cdc25c))
(not (num-subs_l1))
)
)
(:action CHOOSE_CDK2_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_cdk2)
)
:effect
(and
(chosen_cdk2)
(num-subs_l2)
(not (not-chosen_cdk2))
(not (num-subs_l1))
)
)
(:action CHOOSE_CDK2P1_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_cdk2p1)
)
:effect
(and
(chosen_cdk2p1)
(num-subs_l2)
(not (not-chosen_cdk2p1))
(not (num-subs_l1))
)
)
(:action CHOOSE_CEBP_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_cebp)
)
:effect
(and
(chosen_cebp)
(num-subs_l2)
(not (not-chosen_cebp))
(not (num-subs_l1))
)
)
(:action CHOOSE_C-TAK1_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_c-tak1)
)
:effect
(and
(chosen_c-tak1)
(num-subs_l2)
(not (not-chosen_c-tak1))
(not (num-subs_l1))
)
)
(:action CHOOSE_DMP1_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_dmp1)
)
:effect
(and
(chosen_dmp1)
(num-subs_l2)
(not (not-chosen_dmp1))
(not (num-subs_l1))
)
)
(:action CHOOSE_E2F13_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_e2f13)
)
:effect
(and
(chosen_e2f13)
(num-subs_l2)
(not (not-chosen_e2f13))
(not (num-subs_l1))
)
)
(:action CHOOSE_E2F4-DP12P1_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_e2f4-dp12p1)
)
:effect
(and
(chosen_e2f4-dp12p1)
(num-subs_l2)
(not (not-chosen_e2f4-dp12p1))
(not (num-subs_l1))
)
)
(:action CHOOSE_E2F6-DP12P1_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_e2f6-dp12p1)
)
:effect
(and
(chosen_e2f6-dp12p1)
(num-subs_l2)
(not (not-chosen_e2f6-dp12p1))
(not (num-subs_l1))
)
)
(:action CHOOSE_GE2_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_ge2)
)
:effect
(and
(chosen_ge2)
(num-subs_l2)
(not (not-chosen_ge2))
(not (num-subs_l1))
)
)
(:action CHOOSE_GP_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_gp)
)
:effect
(and
(chosen_gp)
(num-subs_l2)
(not (not-chosen_gp))
(not (num-subs_l1))
)
)
(:action CHOOSE_HDAC1_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_hdac1)
)
:effect
(and
(chosen_hdac1)
(num-subs_l2)
(not (not-chosen_hdac1))
(not (num-subs_l1))
)
)
(:action CHOOSE_HDAC1-P130-E2F4P1-DP12_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_hdac1-p130-e2f4p1-dp12)
)
:effect
(and
(chosen_hdac1-p130-e2f4p1-dp12)
(num-subs_l2)
(not (not-chosen_hdac1-p130-e2f4p1-dp12))
(not (num-subs_l1))
)
)
(:action CHOOSE_M1433_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_m1433)
)
:effect
(and
(chosen_m1433)
(num-subs_l2)
(not (not-chosen_m1433))
(not (num-subs_l1))
)
)
(:action CHOOSE_PCNA_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_pcna)
)
:effect
(and
(chosen_pcna)
(num-subs_l2)
(not (not-chosen_pcna))
(not (num-subs_l1))
)
)
(:action CHOOSE_PRB-E2F4P1-DP12_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_prb-e2f4p1-dp12)
)
:effect
(and
(chosen_prb-e2f4p1-dp12)
(num-subs_l2)
(not (not-chosen_prb-e2f4p1-dp12))
(not (num-subs_l1))
)
)
(:action CHOOSE_PRBP1-E2F4P1-DP12_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_prbp1-e2f4p1-dp12)
)
:effect
(and
(chosen_prbp1-e2f4p1-dp12)
(num-subs_l2)
(not (not-chosen_prbp1-e2f4p1-dp12))
(not (num-subs_l1))
)
)
(:action CHOOSE_PRBP2_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_prbp2)
)
:effect
(and
(chosen_prbp2)
(num-subs_l2)
(not (not-chosen_prbp2))
(not (num-subs_l1))
)
)
(:action CHOOSE_RPA_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_rpa)
)
:effect
(and
(chosen_rpa)
(num-subs_l2)
(not (not-chosen_rpa))
(not (num-subs_l1))
)
)
(:action CHOOSE_SP1_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_sp1)
)
:effect
(and
(chosen_sp1)
(num-subs_l2)
(not (not-chosen_sp1))
(not (num-subs_l1))
)
)
(:action CHOOSE_WEE1_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_wee1)
)
:effect
(and
(chosen_wee1)
(num-subs_l2)
(not (not-chosen_wee1))
(not (num-subs_l1))
)
)
(:action dummy-action-4-2
:parameters ()
:precondition
(and
(available_cycep1)
)
:effect
(and
(goal4_)
)
)
(:action dummy-action-2-2
:parameters ()
:precondition
(and
(available_p107)
)
:effect
(and
(goal2_)
)
)
(:action dummy-action-1-2
:parameters ()
:precondition
(and
(available_pol)
)
:effect
(and
(goal1_)
)
)
(:action SYNTHESIZE_CEBP-GP_P
:parameters ()
:precondition
(and
(available_cebp-gp)
)
:effect
(and
(available_p)
)
)
(:action SYNTHESIZE_SP1-E2F13-GP_C-MYC
:parameters ()
:precondition
(and
(available_sp1-e2f13-gp)
)
:effect
(and
(available_c-myc)
)
)
(:action SYNTHESIZE_SP1-E2F13-GP_CYCA
:parameters ()
:precondition
(and
(available_sp1-e2f13-gp)
)
:effect
(and
(available_cyca)
)
)
(:action SYNTHESIZE_SP1-E2F13-GP_CYCD
:parameters ()
:precondition
(and
(available_sp1-e2f13-gp)
)
:effect
(and
(available_cycd)
)
)
(:action SYNTHESIZE_SP1-E2F13-GP_CYCDP1
:parameters ()
:precondition
(and
(available_sp1-e2f13-gp)
)
:effect
(and
(available_cycdp1)
)
)
(:action SYNTHESIZE_SP1-E2F13-GP_CYCE
:parameters ()
:precondition
(and
(available_sp1-e2f13-gp)
)
:effect
(and
(available_cyce)
)
)
(:action SYNTHESIZE_SP1-E2F13-GP_CYCEP1
:parameters ()
:precondition
(and
(available_sp1-e2f13-gp)
)
:effect
(and
(available_cycep1)
)
)
(:action SYNTHESIZE_SP1-E2F13-GP_P107
:parameters ()
:precondition
(and
(available_sp1-e2f13-gp)
)
:effect
(and
(available_p107)
)
)
(:action SYNTHESIZE_SP1-E2F13-GP_P107P1
:parameters ()
:precondition
(and
(available_sp1-e2f13-gp)
)
:effect
(and
(available_p107p1)
)
)
(:action SYNTHESIZE_SP1-E2F13-GP_P19ARF
:parameters ()
:precondition
(and
(available_sp1-e2f13-gp)
)
:effect
(and
(available_p19arf)
)
)
(:action SYNTHESIZE_SP1-E2F13-GP_POL
:parameters ()
:precondition
(and
(available_sp1-e2f13-gp)
)
:effect
(and
(available_pol)
)
)
(:action SYNTHESIZE_SP1-GP_C-MYC
:parameters ()
:precondition
(and
(available_sp1-gp)
)
:effect
(and
(available_c-myc)
)
)
(:action SYNTHESIZE_SP1-GP_CYCA
:parameters ()
:precondition
(and
(available_sp1-gp)
)
:effect
(and
(available_cyca)
)
)
(:action SYNTHESIZE_SP1-GP_CYCD
:parameters ()
:precondition
(and
(available_sp1-gp)
)
:effect
(and
(available_cycd)
)
)
(:action SYNTHESIZE_SP1-GP_CYCDP1
:parameters ()
:precondition
(and
(available_sp1-gp)
)
:effect
(and
(available_cycdp1)
)
)
(:action SYNTHESIZE_SP1-GP_CYCE
:parameters ()
:precondition
(and
(available_sp1-gp)
)
:effect
(and
(available_cyce)
)
)
(:action SYNTHESIZE_SP1-GP_CYCEP1
:parameters ()
:precondition
(and
(available_sp1-gp)
)
:effect
(and
(available_cycep1)
)
)
(:action SYNTHESIZE_SP1-GP_P107
:parameters ()
:precondition
(and
(available_sp1-gp)
)
:effect
(and
(available_p107)
)
)
(:action SYNTHESIZE_SP1-GP_P107P1
:parameters ()
:precondition
(and
(available_sp1-gp)
)
:effect
(and
(available_p107p1)
)
)
(:action SYNTHESIZE_SP1-GP_P19ARF
:parameters ()
:precondition
(and
(available_sp1-gp)
)
:effect
(and
(available_p19arf)
)
)
(:action SYNTHESIZE_SP1-GP_POL
:parameters ()
:precondition
(and
(available_sp1-gp)
)
:effect
(and
(available_pol)
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDC25C_C-TAK1_CDC25CP2
:parameters ()
:precondition
(and
(available_c-tak1)
(available_cdc25c)
)
:effect
(and
(available_cdc25cp2)
(not (available_cdc25c))
)
)
(:action ASSOCIATE_C-ABL_PRBP2_C-ABL-PRBP2
:parameters ()
:precondition
(and
(available_prbp2)
(available_c-abl)
)
:effect
(and
(available_c-abl-prbp2)
(not (available_c-abl))
(not (available_prbp2))
)
)
(:action ASSOCIATE_CEBP_GP_CEBP-GP
:parameters ()
:precondition
(and
(available_gp)
(available_cebp)
)
:effect
(and
(available_cebp-gp)
(not (available_cebp))
(not (available_gp))
)
)
(:action ASSOCIATE_CEBP_PRBP2_CEBP-PRBP2
:parameters ()
:precondition
(and
(available_prbp2)
(available_cebp)
)
:effect
(and
(available_cebp-prbp2)
(not (available_cebp))
(not (available_prbp2))
)
)
(:action ASSOCIATE_E2F6-DP12P1_GE2_E2F6-DP12P1-GE2
:parameters ()
:precondition
(and
(available_ge2)
(available_e2f6-dp12p1)
)
:effect
(and
(available_e2f6-dp12p1-ge2)
(not (available_e2f6-dp12p1))
(not (available_ge2))
)
)
(:action ASSOCIATE_HDAC1-P130-E2F4P1-DP12_GE2_HDAC1-P130-E2F4P1-DP12-GE2
:parameters ()
:precondition
(and
(available_ge2)
(available_hdac1-p130-e2f4p1-dp12)
)
:effect
(and
(available_hdac1-p130-e2f4p1-dp12-ge2)
(not (available_hdac1-p130-e2f4p1-dp12))
(not (available_ge2))
)
)
(:action ASSOCIATE_HDAC1_PRB-E2F4P1-DP12_HDAC1-PRB-E2F4P1-DP12
:parameters ()
:precondition
(and
(available_prb-e2f4p1-dp12)
(available_hdac1)
)
:effect
(and
(available_hdac1-prb-e2f4p1-dp12)
(not (available_hdac1))
(not (available_prb-e2f4p1-dp12))
)
)
(:action ASSOCIATE_PRB-E2F4P1-DP12_GE2_PRB-E2F4P1-DP12-GE2
:parameters ()
:precondition
(and
(available_ge2)
(available_prb-e2f4p1-dp12)
)
:effect
(and
(available_prb-e2f4p1-dp12-ge2)
(not (available_prb-e2f4p1-dp12))
(not (available_ge2))
)
)
(:action ASSOCIATE_PRBP1-E2F4P1-DP12_GE2_PRBP1-E2F4P1-DP12-GE2
:parameters ()
:precondition
(and
(available_ge2)
(available_prbp1-e2f4p1-dp12)
)
:effect
(and
(available_prbp1-e2f4p1-dp12-ge2)
(not (available_prbp1-e2f4p1-dp12))
(not (available_ge2))
)
)
(:action ASSOCIATE_SP1-E2F13_GP_SP1-E2F13-GP
:parameters ()
:precondition
(and
(available_gp)
(available_sp1-e2f13)
)
:effect
(and
(available_sp1-e2f13-gp)
(not (available_sp1-e2f13))
(not (available_gp))
)
)
(:action ASSOCIATE_SP1_E2F13_SP1-E2F13
:parameters ()
:precondition
(and
(available_e2f13)
(available_sp1)
)
:effect
(and
(available_sp1-e2f13)
(not (available_sp1))
(not (available_e2f13))
)
)
(:action ASSOCIATE_SP1_GP_SP1-GP
:parameters ()
:precondition
(and
(available_gp)
(available_sp1)
)
:effect
(and
(available_sp1-gp)
(not (available_sp1))
(not (available_gp))
)
)
(:action INITIALIZE_C-ABL
:parameters ()
:precondition
(and
(chosen_c-abl)
)
:effect
(and
(available_c-abl)
)
)
(:action INITIALIZE_CDC25C
:parameters ()
:precondition
(and
(chosen_cdc25c)
)
:effect
(and
(available_cdc25c)
)
)
(:action INITIALIZE_CDK2
:parameters ()
:precondition
(and
(chosen_cdk2)
)
:effect
(and
(available_cdk2)
)
)
(:action INITIALIZE_CDK2P1
:parameters ()
:precondition
(and
(chosen_cdk2p1)
)
:effect
(and
(available_cdk2p1)
)
)
(:action INITIALIZE_CEBP
:parameters ()
:precondition
(and
(chosen_cebp)
)
:effect
(and
(available_cebp)
)
)
(:action INITIALIZE_C-TAK1
:parameters ()
:precondition
(and
(chosen_c-tak1)
)
:effect
(and
(available_c-tak1)
)
)
(:action INITIALIZE_DMP1
:parameters ()
:precondition
(and
(chosen_dmp1)
)
:effect
(and
(available_dmp1)
)
)
(:action INITIALIZE_E2F13
:parameters ()
:precondition
(and
(chosen_e2f13)
)
:effect
(and
(available_e2f13)
)
)
(:action INITIALIZE_E2F4-DP12P1
:parameters ()
:precondition
(and
(chosen_e2f4-dp12p1)
)
:effect
(and
(available_e2f4-dp12p1)
)
)
(:action INITIALIZE_E2F6-DP12P1
:parameters ()
:precondition
(and
(chosen_e2f6-dp12p1)
)
:effect
(and
(available_e2f6-dp12p1)
)
)
(:action INITIALIZE_GE2
:parameters ()
:precondition
(and
(chosen_ge2)
)
:effect
(and
(available_ge2)
)
)
(:action INITIALIZE_GP
:parameters ()
:precondition
(and
(chosen_gp)
)
:effect
(and
(available_gp)
)
)
(:action INITIALIZE_HDAC1
:parameters ()
:precondition
(and
(chosen_hdac1)
)
:effect
(and
(available_hdac1)
)
)
(:action INITIALIZE_HDAC1-P130-E2F4P1-DP12
:parameters ()
:precondition
(and
(chosen_hdac1-p130-e2f4p1-dp12)
)
:effect
(and
(available_hdac1-p130-e2f4p1-dp12)
)
)
(:action INITIALIZE_M1433
:parameters ()
:precondition
(and
(chosen_m1433)
)
:effect
(and
(available_m1433)
)
)
(:action INITIALIZE_PCNA
:parameters ()
:precondition
(and
(chosen_pcna)
)
:effect
(and
(available_pcna)
)
)
(:action INITIALIZE_PRB-E2F4P1-DP12
:parameters ()
:precondition
(and
(chosen_prb-e2f4p1-dp12)
)
:effect
(and
(available_prb-e2f4p1-dp12)
)
)
(:action INITIALIZE_PRBP1-E2F4P1-DP12
:parameters ()
:precondition
(and
(chosen_prbp1-e2f4p1-dp12)
)
:effect
(and
(available_prbp1-e2f4p1-dp12)
)
)
(:action INITIALIZE_PRBP2
:parameters ()
:precondition
(and
(chosen_prbp2)
)
:effect
(and
(available_prbp2)
)
)
(:action INITIALIZE_RPA
:parameters ()
:precondition
(and
(chosen_rpa)
)
:effect
(and
(available_rpa)
)
)
(:action INITIALIZE_SP1
:parameters ()
:precondition
(and
(chosen_sp1)
)
:effect
(and
(available_sp1)
)
)
(:action INITIALIZE_WEE1
:parameters ()
:precondition
(and
(chosen_wee1)
)
:effect
(and
(available_wee1)
)
)
(:action CHOOSE_C-ABL_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_c-abl)
)
:effect
(and
(chosen_c-abl)
(num-subs_l1)
(not (not-chosen_c-abl))
(not (num-subs_l0))
)
)
(:action CHOOSE_CDC25C_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_cdc25c)
)
:effect
(and
(chosen_cdc25c)
(num-subs_l1)
(not (not-chosen_cdc25c))
(not (num-subs_l0))
)
)
(:action CHOOSE_CDK2_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_cdk2)
)
:effect
(and
(chosen_cdk2)
(num-subs_l1)
(not (not-chosen_cdk2))
(not (num-subs_l0))
)
)
(:action CHOOSE_CDK2P1_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_cdk2p1)
)
:effect
(and
(chosen_cdk2p1)
(num-subs_l1)
(not (not-chosen_cdk2p1))
(not (num-subs_l0))
)
)
(:action CHOOSE_CEBP_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_cebp)
)
:effect
(and
(chosen_cebp)
(num-subs_l1)
(not (not-chosen_cebp))
(not (num-subs_l0))
)
)
(:action CHOOSE_C-TAK1_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_c-tak1)
)
:effect
(and
(chosen_c-tak1)
(num-subs_l1)
(not (not-chosen_c-tak1))
(not (num-subs_l0))
)
)
(:action CHOOSE_DMP1_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_dmp1)
)
:effect
(and
(chosen_dmp1)
(num-subs_l1)
(not (not-chosen_dmp1))
(not (num-subs_l0))
)
)
(:action CHOOSE_E2F13_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_e2f13)
)
:effect
(and
(chosen_e2f13)
(num-subs_l1)
(not (not-chosen_e2f13))
(not (num-subs_l0))
)
)
(:action CHOOSE_E2F4-DP12P1_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_e2f4-dp12p1)
)
:effect
(and
(chosen_e2f4-dp12p1)
(num-subs_l1)
(not (not-chosen_e2f4-dp12p1))
(not (num-subs_l0))
)
)
(:action CHOOSE_E2F6-DP12P1_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_e2f6-dp12p1)
)
:effect
(and
(chosen_e2f6-dp12p1)
(num-subs_l1)
(not (not-chosen_e2f6-dp12p1))
(not (num-subs_l0))
)
)
(:action CHOOSE_GE2_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_ge2)
)
:effect
(and
(chosen_ge2)
(num-subs_l1)
(not (not-chosen_ge2))
(not (num-subs_l0))
)
)
(:action CHOOSE_GP_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_gp)
)
:effect
(and
(chosen_gp)
(num-subs_l1)
(not (not-chosen_gp))
(not (num-subs_l0))
)
)
(:action CHOOSE_HDAC1_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_hdac1)
)
:effect
(and
(chosen_hdac1)
(num-subs_l1)
(not (not-chosen_hdac1))
(not (num-subs_l0))
)
)
(:action CHOOSE_HDAC1-P130-E2F4P1-DP12_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_hdac1-p130-e2f4p1-dp12)
)
:effect
(and
(chosen_hdac1-p130-e2f4p1-dp12)
(num-subs_l1)
(not (not-chosen_hdac1-p130-e2f4p1-dp12))
(not (num-subs_l0))
)
)
(:action CHOOSE_M1433_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_m1433)
)
:effect
(and
(chosen_m1433)
(num-subs_l1)
(not (not-chosen_m1433))
(not (num-subs_l0))
)
)
(:action CHOOSE_PCNA_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_pcna)
)
:effect
(and
(chosen_pcna)
(num-subs_l1)
(not (not-chosen_pcna))
(not (num-subs_l0))
)
)
(:action CHOOSE_PRB-E2F4P1-DP12_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_prb-e2f4p1-dp12)
)
:effect
(and
(chosen_prb-e2f4p1-dp12)
(num-subs_l1)
(not (not-chosen_prb-e2f4p1-dp12))
(not (num-subs_l0))
)
)
(:action CHOOSE_PRBP1-E2F4P1-DP12_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_prbp1-e2f4p1-dp12)
)
:effect
(and
(chosen_prbp1-e2f4p1-dp12)
(num-subs_l1)
(not (not-chosen_prbp1-e2f4p1-dp12))
(not (num-subs_l0))
)
)
(:action CHOOSE_PRBP2_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_prbp2)
)
:effect
(and
(chosen_prbp2)
(num-subs_l1)
(not (not-chosen_prbp2))
(not (num-subs_l0))
)
)
(:action CHOOSE_RPA_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_rpa)
)
:effect
(and
(chosen_rpa)
(num-subs_l1)
(not (not-chosen_rpa))
(not (num-subs_l0))
)
)
(:action CHOOSE_SP1_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_sp1)
)
:effect
(and
(chosen_sp1)
(num-subs_l1)
(not (not-chosen_sp1))
(not (num-subs_l0))
)
)
(:action CHOOSE_WEE1_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_wee1)
)
:effect
(and
(chosen_wee1)
(num-subs_l1)
(not (not-chosen_wee1))
(not (num-subs_l0))
)
)
)
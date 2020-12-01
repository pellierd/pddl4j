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
(chosen_prb)
(chosen_p16)
(chosen_p130)
(chosen_hdac1)
(chosen_gp)
(chosen_e2f4-dp12p1)
(chosen_c-tak1)
(chosen_cks1)
(chosen_chk1)
(chosen_cdk46p3-cycd)
(chosen_cdk46p1)
(chosen_cdk2p2-cycb)
(chosen_cdk1p1p2)
(chosen_cdc25c)
(chosen_ap2)
(available_wee1)
(available_sp1)
(available_rpa)
(available_prbp2)
(available_prb)
(available_p16)
(available_p130)
(available_hdac1)
(available_gp)
(available_e2f4-dp12p1)
(available_c-tak1)
(available_cks1)
(available_chk1)
(available_cdk46p3-cycd)
(available_cdk46p1)
(available_cdk2p2-cycb)
(available_cdk1p1p2)
(available_cdc25c)
(available_ap2)
(available_sp1-gp)
(available_prbp2-ap2)
(available_prb-e2f4-dp12p1)
(available_prb-ap2)
(available_p16-cdk46p1)
(available_p130-e2f4-dp12p1)
(available_hdac1-p130-e2f4-dp12p1)
(available_cdk1p1p2-cks1)
(available_prbp1p2)
(available_prbp1)
(available_cdk2p1p2-cycb)
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
(goal2_)
(num-subs_l2)
(available_sp1-p107)
(available_sp1-p107p1)
(available_sp1-p107p1-gp)
(available_sp1-p107-gp)
(available_rpa-cyca)
(available_prbp1p2-ap2)
(available_prbp1-e2f4-dp12p1)
(available_prbp1-ap2)
(available_p107-e2f4-dp12p1)
(available_hdac1-p107-e2f4-dp12p1)
(available_c-myc-ap2)
(available_cdk46p1-cycdp1)
(available_cdk46p1-cycd)
(goal1_)
(goal3_)
(num-subs_l3)
(not-chosen_ap2)
(not-chosen_cdc25c)
(not-chosen_cdk1p1p2)
(not-chosen_cdk2p2-cycb)
(not-chosen_cdk46p1)
(not-chosen_cdk46p3-cycd)
(not-chosen_chk1)
(not-chosen_cks1)
(not-chosen_c-tak1)
(not-chosen_e2f4-dp12p1)
(not-chosen_gp)
(not-chosen_hdac1)
(not-chosen_p130)
(not-chosen_p16)
(not-chosen_prb)
(not-chosen_prbp2)
(not-chosen_rpa)
(not-chosen_sp1)
(not-chosen_wee1)
(num-subs_l0)
)
(:action CHOOSE_AP2_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_ap2)
)
:effect
(and
(chosen_ap2)
(num-subs_l3)
(not (not-chosen_ap2))
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
(:action CHOOSE_CDK1P1P2_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_cdk1p1p2)
)
:effect
(and
(chosen_cdk1p1p2)
(num-subs_l3)
(not (not-chosen_cdk1p1p2))
(not (num-subs_l2))
)
)
(:action CHOOSE_CDK2P2-CYCB_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_cdk2p2-cycb)
)
:effect
(and
(chosen_cdk2p2-cycb)
(num-subs_l3)
(not (not-chosen_cdk2p2-cycb))
(not (num-subs_l2))
)
)
(:action CHOOSE_CDK46P1_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_cdk46p1)
)
:effect
(and
(chosen_cdk46p1)
(num-subs_l3)
(not (not-chosen_cdk46p1))
(not (num-subs_l2))
)
)
(:action CHOOSE_CDK46P3-CYCD_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_cdk46p3-cycd)
)
:effect
(and
(chosen_cdk46p3-cycd)
(num-subs_l3)
(not (not-chosen_cdk46p3-cycd))
(not (num-subs_l2))
)
)
(:action CHOOSE_CHK1_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_chk1)
)
:effect
(and
(chosen_chk1)
(num-subs_l3)
(not (not-chosen_chk1))
(not (num-subs_l2))
)
)
(:action CHOOSE_CKS1_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_cks1)
)
:effect
(and
(chosen_cks1)
(num-subs_l3)
(not (not-chosen_cks1))
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
(:action CHOOSE_P130_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_p130)
)
:effect
(and
(chosen_p130)
(num-subs_l3)
(not (not-chosen_p130))
(not (num-subs_l2))
)
)
(:action CHOOSE_P16_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_p16)
)
:effect
(and
(chosen_p16)
(num-subs_l3)
(not (not-chosen_p16))
(not (num-subs_l2))
)
)
(:action CHOOSE_PRB_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_prb)
)
:effect
(and
(chosen_prb)
(num-subs_l3)
(not (not-chosen_prb))
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
(:action dummy-action-3-1
:parameters ()
:precondition
(and
(available_hdac1-p107-e2f4-dp12p1)
)
:effect
(and
(goal3_)
)
)
(:action dummy-action-3-2
:parameters ()
:precondition
(and
(available_cdk46p1-cycd)
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
(available_sp1-p107p1-gp)
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
(available_sp1-p107-gp)
)
:effect
(and
(goal1_)
)
)
(:action dummy-action-1-2
:parameters ()
:precondition
(and
(available_prbp1-e2f4-dp12p1)
)
:effect
(and
(goal1_)
)
)
(:action ASSOCIATE_CDK46P1_CYCD_CDK46P1-CYCD
:parameters ()
:precondition
(and
(available_cycd)
(available_cdk46p1)
)
:effect
(and
(available_cdk46p1-cycd)
(not (available_cdk46p1))
(not (available_cycd))
)
)
(:action ASSOCIATE_CDK46P1_CYCDP1_CDK46P1-CYCDP1
:parameters ()
:precondition
(and
(available_cycdp1)
(available_cdk46p1)
)
:effect
(and
(available_cdk46p1-cycdp1)
(not (available_cdk46p1))
(not (available_cycdp1))
)
)
(:action ASSOCIATE_C-MYC_AP2_C-MYC-AP2
:parameters ()
:precondition
(and
(available_ap2)
(available_c-myc)
)
:effect
(and
(available_c-myc-ap2)
(not (available_c-myc))
(not (available_ap2))
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
(:action ASSOCIATE_PRBP1_AP2_PRBP1-AP2
:parameters ()
:precondition
(and
(available_ap2)
(available_prbp1)
)
:effect
(and
(available_prbp1-ap2)
(not (available_prbp1))
(not (available_ap2))
)
)
(:action ASSOCIATE_PRBP1_E2F4-DP12P1_PRBP1-E2F4-DP12P1
:parameters ()
:precondition
(and
(available_e2f4-dp12p1)
(available_prbp1)
)
:effect
(and
(available_prbp1-e2f4-dp12p1)
(not (available_prbp1))
(not (available_e2f4-dp12p1))
)
)
(:action ASSOCIATE_PRBP1P2_AP2_PRBP1P2-AP2
:parameters ()
:precondition
(and
(available_ap2)
(available_prbp1p2)
)
:effect
(and
(available_prbp1p2-ap2)
(not (available_prbp1p2))
(not (available_ap2))
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
(:action CHOOSE_AP2_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_ap2)
)
:effect
(and
(chosen_ap2)
(num-subs_l2)
(not (not-chosen_ap2))
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
(:action CHOOSE_CDK1P1P2_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_cdk1p1p2)
)
:effect
(and
(chosen_cdk1p1p2)
(num-subs_l2)
(not (not-chosen_cdk1p1p2))
(not (num-subs_l1))
)
)
(:action CHOOSE_CDK2P2-CYCB_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_cdk2p2-cycb)
)
:effect
(and
(chosen_cdk2p2-cycb)
(num-subs_l2)
(not (not-chosen_cdk2p2-cycb))
(not (num-subs_l1))
)
)
(:action CHOOSE_CDK46P1_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_cdk46p1)
)
:effect
(and
(chosen_cdk46p1)
(num-subs_l2)
(not (not-chosen_cdk46p1))
(not (num-subs_l1))
)
)
(:action CHOOSE_CDK46P3-CYCD_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_cdk46p3-cycd)
)
:effect
(and
(chosen_cdk46p3-cycd)
(num-subs_l2)
(not (not-chosen_cdk46p3-cycd))
(not (num-subs_l1))
)
)
(:action CHOOSE_CHK1_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_chk1)
)
:effect
(and
(chosen_chk1)
(num-subs_l2)
(not (not-chosen_chk1))
(not (num-subs_l1))
)
)
(:action CHOOSE_CKS1_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_cks1)
)
:effect
(and
(chosen_cks1)
(num-subs_l2)
(not (not-chosen_cks1))
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
(:action CHOOSE_P130_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_p130)
)
:effect
(and
(chosen_p130)
(num-subs_l2)
(not (not-chosen_p130))
(not (num-subs_l1))
)
)
(:action CHOOSE_P16_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_p16)
)
:effect
(and
(chosen_p16)
(num-subs_l2)
(not (not-chosen_p16))
(not (num-subs_l1))
)
)
(:action CHOOSE_PRB_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_prb)
)
:effect
(and
(chosen_prb)
(num-subs_l2)
(not (not-chosen_prb))
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
(:action dummy-action-2-2
:parameters ()
:precondition
(and
(available_cyca)
)
:effect
(and
(goal2_)
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
(:action ASSOCIATE-WITH-CATALYZE_CDC25C_CHK1_CDC25CP2
:parameters ()
:precondition
(and
(available_chk1)
(available_cdc25c)
)
:effect
(and
(available_cdc25cp2)
(not (available_cdc25c))
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
(:action ASSOCIATE-WITH-CATALYZE_CDK2P2-CYCB_WEE1_CDK2P1P2-CYCB
:parameters ()
:precondition
(and
(available_wee1)
(available_cdk2p2-cycb)
)
:effect
(and
(available_cdk2p1p2-cycb)
(not (available_cdk2p2-cycb))
)
)
(:action ASSOCIATE-WITH-CATALYZE_PRB_CDK46P3-CYCD_PRBP1
:parameters ()
:precondition
(and
(available_cdk46p3-cycd)
(available_prb)
)
:effect
(and
(available_prbp1)
(not (available_prb))
)
)
(:action ASSOCIATE-WITH-CATALYZE_PRBP2_CDK46P3-CYCD_PRBP1P2
:parameters ()
:precondition
(and
(available_cdk46p3-cycd)
(available_prbp2)
)
:effect
(and
(available_prbp1p2)
(not (available_prbp2))
)
)
(:action ASSOCIATE_CDK1P1P2_CKS1_CDK1P1P2-CKS1
:parameters ()
:precondition
(and
(available_cks1)
(available_cdk1p1p2)
)
:effect
(and
(available_cdk1p1p2-cks1)
(not (available_cdk1p1p2))
(not (available_cks1))
)
)
(:action ASSOCIATE_HDAC1_P130-E2F4-DP12P1_HDAC1-P130-E2F4-DP12P1
:parameters ()
:precondition
(and
(available_p130-e2f4-dp12p1)
(available_hdac1)
)
:effect
(and
(available_hdac1-p130-e2f4-dp12p1)
(not (available_hdac1))
(not (available_p130-e2f4-dp12p1))
)
)
(:action ASSOCIATE_P130_E2F4-DP12P1_P130-E2F4-DP12P1
:parameters ()
:precondition
(and
(available_e2f4-dp12p1)
(available_p130)
)
:effect
(and
(available_p130-e2f4-dp12p1)
(not (available_p130))
(not (available_e2f4-dp12p1))
)
)
(:action ASSOCIATE_P16_CDK46P1_P16-CDK46P1
:parameters ()
:precondition
(and
(available_cdk46p1)
(available_p16)
)
:effect
(and
(available_p16-cdk46p1)
(not (available_p16))
(not (available_cdk46p1))
)
)
(:action ASSOCIATE_PRB_AP2_PRB-AP2
:parameters ()
:precondition
(and
(available_ap2)
(available_prb)
)
:effect
(and
(available_prb-ap2)
(not (available_prb))
(not (available_ap2))
)
)
(:action ASSOCIATE_PRB_E2F4-DP12P1_PRB-E2F4-DP12P1
:parameters ()
:precondition
(and
(available_e2f4-dp12p1)
(available_prb)
)
:effect
(and
(available_prb-e2f4-dp12p1)
(not (available_prb))
(not (available_e2f4-dp12p1))
)
)
(:action ASSOCIATE_PRBP2_AP2_PRBP2-AP2
:parameters ()
:precondition
(and
(available_ap2)
(available_prbp2)
)
:effect
(and
(available_prbp2-ap2)
(not (available_prbp2))
(not (available_ap2))
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
(:action INITIALIZE_AP2
:parameters ()
:precondition
(and
(chosen_ap2)
)
:effect
(and
(available_ap2)
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
(:action INITIALIZE_CDK1P1P2
:parameters ()
:precondition
(and
(chosen_cdk1p1p2)
)
:effect
(and
(available_cdk1p1p2)
)
)
(:action INITIALIZE_CDK2P2-CYCB
:parameters ()
:precondition
(and
(chosen_cdk2p2-cycb)
)
:effect
(and
(available_cdk2p2-cycb)
)
)
(:action INITIALIZE_CDK46P1
:parameters ()
:precondition
(and
(chosen_cdk46p1)
)
:effect
(and
(available_cdk46p1)
)
)
(:action INITIALIZE_CDK46P3-CYCD
:parameters ()
:precondition
(and
(chosen_cdk46p3-cycd)
)
:effect
(and
(available_cdk46p3-cycd)
)
)
(:action INITIALIZE_CHK1
:parameters ()
:precondition
(and
(chosen_chk1)
)
:effect
(and
(available_chk1)
)
)
(:action INITIALIZE_CKS1
:parameters ()
:precondition
(and
(chosen_cks1)
)
:effect
(and
(available_cks1)
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
(:action INITIALIZE_P130
:parameters ()
:precondition
(and
(chosen_p130)
)
:effect
(and
(available_p130)
)
)
(:action INITIALIZE_P16
:parameters ()
:precondition
(and
(chosen_p16)
)
:effect
(and
(available_p16)
)
)
(:action INITIALIZE_PRB
:parameters ()
:precondition
(and
(chosen_prb)
)
:effect
(and
(available_prb)
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
(:action CHOOSE_AP2_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_ap2)
)
:effect
(and
(chosen_ap2)
(num-subs_l1)
(not (not-chosen_ap2))
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
(:action CHOOSE_CDK1P1P2_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_cdk1p1p2)
)
:effect
(and
(chosen_cdk1p1p2)
(num-subs_l1)
(not (not-chosen_cdk1p1p2))
(not (num-subs_l0))
)
)
(:action CHOOSE_CDK2P2-CYCB_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_cdk2p2-cycb)
)
:effect
(and
(chosen_cdk2p2-cycb)
(num-subs_l1)
(not (not-chosen_cdk2p2-cycb))
(not (num-subs_l0))
)
)
(:action CHOOSE_CDK46P1_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_cdk46p1)
)
:effect
(and
(chosen_cdk46p1)
(num-subs_l1)
(not (not-chosen_cdk46p1))
(not (num-subs_l0))
)
)
(:action CHOOSE_CDK46P3-CYCD_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_cdk46p3-cycd)
)
:effect
(and
(chosen_cdk46p3-cycd)
(num-subs_l1)
(not (not-chosen_cdk46p3-cycd))
(not (num-subs_l0))
)
)
(:action CHOOSE_CHK1_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_chk1)
)
:effect
(and
(chosen_chk1)
(num-subs_l1)
(not (not-chosen_chk1))
(not (num-subs_l0))
)
)
(:action CHOOSE_CKS1_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_cks1)
)
:effect
(and
(chosen_cks1)
(num-subs_l1)
(not (not-chosen_cks1))
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
(:action CHOOSE_P130_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_p130)
)
:effect
(and
(chosen_p130)
(num-subs_l1)
(not (not-chosen_p130))
(not (num-subs_l0))
)
)
(:action CHOOSE_P16_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_p16)
)
:effect
(and
(chosen_p16)
(num-subs_l1)
(not (not-chosen_p16))
(not (num-subs_l0))
)
)
(:action CHOOSE_PRB_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_prb)
)
:effect
(and
(chosen_prb)
(num-subs_l1)
(not (not-chosen_prb))
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
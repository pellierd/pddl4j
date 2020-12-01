; IPC5 Domain: Pathways Propositional
; Authors: Yannis Dimopoulos, Alfonso Gerevini and Alessandro Saetti

(define (domain GROUNDED-PATHWAYS-PROPOSITIONAL)
(:requirements
:strips
)
(:predicates
(FOO)
(chosen_sp1)
(num-subs_l1)
(chosen_skp2)
(chosen_skp1)
(chosen_rpa)
(chosen_raf1)
(chosen_prbp2)
(chosen_prbp1-e2f4p1-dp12)
(chosen_prb-e2f4p1-dp12)
(chosen_plk1)
(chosen_p57p1)
(chosen_p57)
(chosen_p27)
(chosen_p130-e2f5p1-dp12)
(chosen_p130-e2f4p1-dp12)
(chosen_p130)
(chosen_max)
(chosen_jun)
(chosen_hdac1-prbp1-e2f4-dp12)
(chosen_hdac1-prbp1-e2f13p1-dp12)
(chosen_hdac1-prbp1-e2f13-dp12)
(chosen_hdac1)
(chosen_gp19arf)
(chosen_ge2)
(chosen_gcdc25a)
(chosen_e2f6-dp12p1)
(chosen_e2f5)
(chosen_e2f4-dp12p1)
(chosen_e2f4)
(chosen_e2f3)
(chosen_e2f13p1-dp12)
(chosen_e2f13-dp12)
(chosen_e2f13)
(chosen_e2f1)
(chosen_dp12)
(chosen_dmp1)
(chosen_cdk46p3-cycd)
(chosen_cdk46p1)
(chosen_cdk2p1)
(chosen_apc)
(available_sp1)
(available_skp2)
(available_skp1)
(available_rpa)
(available_raf1)
(available_prbp2)
(available_prbp1-e2f4p1-dp12)
(available_prb-e2f4p1-dp12)
(available_plk1)
(available_p57p1)
(available_p57)
(available_p27)
(available_p130-e2f5p1-dp12)
(available_p130-e2f4p1-dp12)
(available_p130)
(available_max)
(available_jun)
(available_hdac1-prbp1-e2f4-dp12)
(available_hdac1-prbp1-e2f13p1-dp12)
(available_hdac1-prbp1-e2f13-dp12)
(available_hdac1)
(available_gp19arf)
(available_ge2)
(available_gcdc25a)
(available_e2f6-dp12p1)
(available_e2f5)
(available_e2f4-dp12p1)
(available_e2f4)
(available_e2f3)
(available_e2f13p1-dp12)
(available_e2f13-dp12)
(available_e2f13)
(available_e2f1)
(available_dp12)
(available_dmp1)
(available_cdk46p3-cycd)
(available_cdk46p1)
(available_cdk2p1)
(available_apc)
(available_sp1-e2f13)
(available_skp2-skp1)
(available_raf1-prbp1-e2f4p1-dp12)
(available_raf1-prbp1-e2f4p1-dp12-ge2)
(available_raf1-prb-e2f4p1-dp12)
(available_raf1-prb-e2f4p1-dp12-ge2)
(available_raf1-p130-e2f5p1-dp12)
(available_raf1-p130-e2f5p1-dp12-ge2)
(available_raf1-p130-e2f4p1-dp12)
(available_raf1-p130-e2f4p1-dp12-ge2)
(available_prbp2-jun)
(available_prbp1-e2f4p1-dp12-ge2)
(available_prb-e2f4p1-dp12-ge2)
(available_p130-e2f4-dp12p1)
(available_p130-e2f4-dp12p1-ge2)
(available_hdac1-prbp1-e2f4-dp12-ge2)
(available_hdac1-prbp1-e2f13p1-dp12-ge2)
(available_hdac1-prbp1-e2f13-dp12-ge2)
(available_hdac1-prb-e2f4p1-dp12)
(available_hdac1-p130-e2f4-dp12p1)
(available_e2f6-dp12p1-ge2)
(available_e2f5-dp12)
(available_e2f4-dp12)
(available_e2f3-dp12)
(available_e2f1-dp12)
(available_e2f13p1-dp12-ge2)
(available_e2f13-dp12-ge2)
(available_dmp1-gp19arf)
(available_prbp1p2)
(available_dmp1p1)
(available_apcp1)
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
(goal4_)
(goal11_)
(num-subs_l2)
(available_sp1-p107)
(available_sp1-p107p1)
(available_rpa-cyca)
(available_prbp1p2-jun)
(available_p130-e2f5-dp12)
(available_p130-e2f5-dp12-ge2)
(available_p130-e2f4-dp12)
(available_p130-e2f4-dp12-ge2)
(available_p107-e2f4-dp12p1)
(available_p107-e2f4-dp12p1-ge2)
(available_p107-e2f4-dp12)
(available_p107-e2f4-dp12-ge2)
(available_hdac1-p130-e2f5-dp12)
(available_hdac1-p130-e2f5-dp12-ge2)
(available_hdac1-p130-e2f4-dp12)
(available_hdac1-p130-e2f4-dp12-ge2)
(available_hdac1-p107-e2f4-dp12p1)
(available_hdac1-p107-e2f4-dp12)
(available_hdac1-p107-e2f4-dp12-ge2)
(available_e2f5-dp12-ge2)
(available_e2f4-dp12-ge2)
(available_dmp1p1-gp19arf)
(available_dmp1p1-cycdp1)
(available_dmp1p1-cycd)
(available_dmp1-cycdp1)
(available_dmp1-cycd)
(available_c-myc-max)
(available_cdk46p1-cycdp1)
(available_cdk46p1-cycd)
(available_cdk2p1-cycep1)
(available_cdk2p1-cyce)
(available_cdk2p1-cyca)
(goal8_)
(num-subs_l3)
(available_skp2-skp1-cdk2p1-cyca)
(available_skp2-cdk2p1-cyca)
(available_raf1-p130-e2f5-dp12)
(available_raf1-p130-e2f5-dp12-ge2)
(available_raf1-p130-e2f4-dp12)
(available_raf1-p130-e2f4-dp12-ge2)
(available_p57p1-cdk46p1-cycd)
(available_p57p1-cdk46p1-cycdp1)
(available_p57-cdk46p1-cycd)
(available_p57-cdk46p1-cycdp1)
(available_p57-cdk2p1-cyce)
(available_p57-cdk2p1-cycep1)
(available_p57-cdk2p1-cyca)
(available_p27-cdk46p1-cycd)
(available_p27-cdk46p1-cycdp1)
(available_p27-cdk2p1-cyce)
(available_p27-cdk2p1-cycep1)
(available_p27-cdk2p1-cyca)
(available_c-myc-max-gcdc25a)
(available_cdk2p1-cyca-e2f13)
(available_cdc25a)
(goal14_)
(num-subs_l4)
(available_raf1-cdc25a)
(available_cdc25ap1)
(goal12_)
(goal13_)
(num-subs_l5)
(available_raf1-cdc25ap1)
(available_cdk46)
(available_cdk2-cycep1)
(available_cdk2-cyce)
(available_cdk2-cyca)
(goal9_)
(goal10_)
(num-subs_l6)
(available_skp2-skp1-cdk2-cyca)
(available_skp2-cdk2-cyca)
(available_p57-cdk2-cyce)
(available_p57-cdk2-cycep1)
(available_p57-cdk2-cyca)
(available_p27-cdk2-cyce)
(available_p27-cdk2-cycep1)
(available_p27-cdk2-cyca)
(available_cdk46-cycdp1)
(available_cdk46-cycd)
(available_cdk2-cyca-e2f13)
(goal5_)
(goal6_)
(goal7_)
(num-subs_l7)
(available_p57p1-cdk46-cycd)
(available_p57p1-cdk46-cycdp1)
(available_p57-cdk46-cycd)
(available_p57-cdk46-cycdp1)
(available_p27-cdk46-cycd)
(available_p27-cdk46-cycdp1)
(goal1_)
(goal3_)
(num-subs_l8)
(num-subs_l9)
(num-subs_l10)
(num-subs_l11)
(num-subs_l12)
(num-subs_l13)
(num-subs_l14)
(not-chosen_apc)
(not-chosen_cdk2p1)
(not-chosen_cdk46p1)
(not-chosen_cdk46p3-cycd)
(not-chosen_dmp1)
(not-chosen_dp12)
(not-chosen_e2f1)
(not-chosen_e2f13)
(not-chosen_e2f13-dp12)
(not-chosen_e2f13p1-dp12)
(not-chosen_e2f3)
(not-chosen_e2f4)
(not-chosen_e2f4-dp12p1)
(not-chosen_e2f5)
(not-chosen_e2f6-dp12p1)
(not-chosen_gcdc25a)
(not-chosen_ge2)
(not-chosen_gp19arf)
(not-chosen_hdac1)
(not-chosen_hdac1-prbp1-e2f13-dp12)
(not-chosen_hdac1-prbp1-e2f13p1-dp12)
(not-chosen_hdac1-prbp1-e2f4-dp12)
(not-chosen_jun)
(not-chosen_max)
(not-chosen_p130)
(not-chosen_p130-e2f4p1-dp12)
(not-chosen_p130-e2f5p1-dp12)
(not-chosen_p27)
(not-chosen_p57)
(not-chosen_p57p1)
(not-chosen_plk1)
(not-chosen_prb-e2f4p1-dp12)
(not-chosen_prbp1-e2f4p1-dp12)
(not-chosen_prbp2)
(not-chosen_raf1)
(not-chosen_rpa)
(not-chosen_skp1)
(not-chosen_skp2)
(not-chosen_sp1)
(num-subs_l0)
)
(:action CHOOSE_APC_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_apc)
)
:effect
(and
(chosen_apc)
(num-subs_l14)
(not (not-chosen_apc))
(not (num-subs_l13))
)
)
(:action CHOOSE_CDK2P1_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_cdk2p1)
)
:effect
(and
(chosen_cdk2p1)
(num-subs_l14)
(not (not-chosen_cdk2p1))
(not (num-subs_l13))
)
)
(:action CHOOSE_CDK46P1_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_cdk46p1)
)
:effect
(and
(chosen_cdk46p1)
(num-subs_l14)
(not (not-chosen_cdk46p1))
(not (num-subs_l13))
)
)
(:action CHOOSE_CDK46P3-CYCD_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_cdk46p3-cycd)
)
:effect
(and
(chosen_cdk46p3-cycd)
(num-subs_l14)
(not (not-chosen_cdk46p3-cycd))
(not (num-subs_l13))
)
)
(:action CHOOSE_DMP1_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_dmp1)
)
:effect
(and
(chosen_dmp1)
(num-subs_l14)
(not (not-chosen_dmp1))
(not (num-subs_l13))
)
)
(:action CHOOSE_DP12_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_dp12)
)
:effect
(and
(chosen_dp12)
(num-subs_l14)
(not (not-chosen_dp12))
(not (num-subs_l13))
)
)
(:action CHOOSE_E2F1_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_e2f1)
)
:effect
(and
(chosen_e2f1)
(num-subs_l14)
(not (not-chosen_e2f1))
(not (num-subs_l13))
)
)
(:action CHOOSE_E2F13_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_e2f13)
)
:effect
(and
(chosen_e2f13)
(num-subs_l14)
(not (not-chosen_e2f13))
(not (num-subs_l13))
)
)
(:action CHOOSE_E2F13-DP12_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_e2f13-dp12)
)
:effect
(and
(chosen_e2f13-dp12)
(num-subs_l14)
(not (not-chosen_e2f13-dp12))
(not (num-subs_l13))
)
)
(:action CHOOSE_E2F13P1-DP12_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_e2f13p1-dp12)
)
:effect
(and
(chosen_e2f13p1-dp12)
(num-subs_l14)
(not (not-chosen_e2f13p1-dp12))
(not (num-subs_l13))
)
)
(:action CHOOSE_E2F3_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_e2f3)
)
:effect
(and
(chosen_e2f3)
(num-subs_l14)
(not (not-chosen_e2f3))
(not (num-subs_l13))
)
)
(:action CHOOSE_E2F4_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_e2f4)
)
:effect
(and
(chosen_e2f4)
(num-subs_l14)
(not (not-chosen_e2f4))
(not (num-subs_l13))
)
)
(:action CHOOSE_E2F4-DP12P1_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_e2f4-dp12p1)
)
:effect
(and
(chosen_e2f4-dp12p1)
(num-subs_l14)
(not (not-chosen_e2f4-dp12p1))
(not (num-subs_l13))
)
)
(:action CHOOSE_E2F5_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_e2f5)
)
:effect
(and
(chosen_e2f5)
(num-subs_l14)
(not (not-chosen_e2f5))
(not (num-subs_l13))
)
)
(:action CHOOSE_E2F6-DP12P1_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_e2f6-dp12p1)
)
:effect
(and
(chosen_e2f6-dp12p1)
(num-subs_l14)
(not (not-chosen_e2f6-dp12p1))
(not (num-subs_l13))
)
)
(:action CHOOSE_GCDC25A_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_gcdc25a)
)
:effect
(and
(chosen_gcdc25a)
(num-subs_l14)
(not (not-chosen_gcdc25a))
(not (num-subs_l13))
)
)
(:action CHOOSE_GE2_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_ge2)
)
:effect
(and
(chosen_ge2)
(num-subs_l14)
(not (not-chosen_ge2))
(not (num-subs_l13))
)
)
(:action CHOOSE_GP19ARF_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_gp19arf)
)
:effect
(and
(chosen_gp19arf)
(num-subs_l14)
(not (not-chosen_gp19arf))
(not (num-subs_l13))
)
)
(:action CHOOSE_HDAC1_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_hdac1)
)
:effect
(and
(chosen_hdac1)
(num-subs_l14)
(not (not-chosen_hdac1))
(not (num-subs_l13))
)
)
(:action CHOOSE_HDAC1-PRBP1-E2F13-DP12_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_hdac1-prbp1-e2f13-dp12)
)
:effect
(and
(chosen_hdac1-prbp1-e2f13-dp12)
(num-subs_l14)
(not (not-chosen_hdac1-prbp1-e2f13-dp12))
(not (num-subs_l13))
)
)
(:action CHOOSE_HDAC1-PRBP1-E2F13P1-DP12_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_hdac1-prbp1-e2f13p1-dp12)
)
:effect
(and
(chosen_hdac1-prbp1-e2f13p1-dp12)
(num-subs_l14)
(not (not-chosen_hdac1-prbp1-e2f13p1-dp12))
(not (num-subs_l13))
)
)
(:action CHOOSE_HDAC1-PRBP1-E2F4-DP12_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_hdac1-prbp1-e2f4-dp12)
)
:effect
(and
(chosen_hdac1-prbp1-e2f4-dp12)
(num-subs_l14)
(not (not-chosen_hdac1-prbp1-e2f4-dp12))
(not (num-subs_l13))
)
)
(:action CHOOSE_JUN_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_jun)
)
:effect
(and
(chosen_jun)
(num-subs_l14)
(not (not-chosen_jun))
(not (num-subs_l13))
)
)
(:action CHOOSE_MAX_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_max)
)
:effect
(and
(chosen_max)
(num-subs_l14)
(not (not-chosen_max))
(not (num-subs_l13))
)
)
(:action CHOOSE_P130_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_p130)
)
:effect
(and
(chosen_p130)
(num-subs_l14)
(not (not-chosen_p130))
(not (num-subs_l13))
)
)
(:action CHOOSE_P130-E2F4P1-DP12_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_p130-e2f4p1-dp12)
)
:effect
(and
(chosen_p130-e2f4p1-dp12)
(num-subs_l14)
(not (not-chosen_p130-e2f4p1-dp12))
(not (num-subs_l13))
)
)
(:action CHOOSE_P130-E2F5P1-DP12_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_p130-e2f5p1-dp12)
)
:effect
(and
(chosen_p130-e2f5p1-dp12)
(num-subs_l14)
(not (not-chosen_p130-e2f5p1-dp12))
(not (num-subs_l13))
)
)
(:action CHOOSE_P27_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_p27)
)
:effect
(and
(chosen_p27)
(num-subs_l14)
(not (not-chosen_p27))
(not (num-subs_l13))
)
)
(:action CHOOSE_P57_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_p57)
)
:effect
(and
(chosen_p57)
(num-subs_l14)
(not (not-chosen_p57))
(not (num-subs_l13))
)
)
(:action CHOOSE_P57P1_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_p57p1)
)
:effect
(and
(chosen_p57p1)
(num-subs_l14)
(not (not-chosen_p57p1))
(not (num-subs_l13))
)
)
(:action CHOOSE_PLK1_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_plk1)
)
:effect
(and
(chosen_plk1)
(num-subs_l14)
(not (not-chosen_plk1))
(not (num-subs_l13))
)
)
(:action CHOOSE_PRB-E2F4P1-DP12_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_prb-e2f4p1-dp12)
)
:effect
(and
(chosen_prb-e2f4p1-dp12)
(num-subs_l14)
(not (not-chosen_prb-e2f4p1-dp12))
(not (num-subs_l13))
)
)
(:action CHOOSE_PRBP1-E2F4P1-DP12_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_prbp1-e2f4p1-dp12)
)
:effect
(and
(chosen_prbp1-e2f4p1-dp12)
(num-subs_l14)
(not (not-chosen_prbp1-e2f4p1-dp12))
(not (num-subs_l13))
)
)
(:action CHOOSE_PRBP2_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_prbp2)
)
:effect
(and
(chosen_prbp2)
(num-subs_l14)
(not (not-chosen_prbp2))
(not (num-subs_l13))
)
)
(:action CHOOSE_RAF1_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_raf1)
)
:effect
(and
(chosen_raf1)
(num-subs_l14)
(not (not-chosen_raf1))
(not (num-subs_l13))
)
)
(:action CHOOSE_RPA_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_rpa)
)
:effect
(and
(chosen_rpa)
(num-subs_l14)
(not (not-chosen_rpa))
(not (num-subs_l13))
)
)
(:action CHOOSE_SKP1_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_skp1)
)
:effect
(and
(chosen_skp1)
(num-subs_l14)
(not (not-chosen_skp1))
(not (num-subs_l13))
)
)
(:action CHOOSE_SKP2_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_skp2)
)
:effect
(and
(chosen_skp2)
(num-subs_l14)
(not (not-chosen_skp2))
(not (num-subs_l13))
)
)
(:action CHOOSE_SP1_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_sp1)
)
:effect
(and
(chosen_sp1)
(num-subs_l14)
(not (not-chosen_sp1))
(not (num-subs_l13))
)
)
(:action CHOOSE_APC_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_apc)
)
:effect
(and
(chosen_apc)
(num-subs_l13)
(not (not-chosen_apc))
(not (num-subs_l12))
)
)
(:action CHOOSE_CDK2P1_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_cdk2p1)
)
:effect
(and
(chosen_cdk2p1)
(num-subs_l13)
(not (not-chosen_cdk2p1))
(not (num-subs_l12))
)
)
(:action CHOOSE_CDK46P1_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_cdk46p1)
)
:effect
(and
(chosen_cdk46p1)
(num-subs_l13)
(not (not-chosen_cdk46p1))
(not (num-subs_l12))
)
)
(:action CHOOSE_CDK46P3-CYCD_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_cdk46p3-cycd)
)
:effect
(and
(chosen_cdk46p3-cycd)
(num-subs_l13)
(not (not-chosen_cdk46p3-cycd))
(not (num-subs_l12))
)
)
(:action CHOOSE_DMP1_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_dmp1)
)
:effect
(and
(chosen_dmp1)
(num-subs_l13)
(not (not-chosen_dmp1))
(not (num-subs_l12))
)
)
(:action CHOOSE_DP12_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_dp12)
)
:effect
(and
(chosen_dp12)
(num-subs_l13)
(not (not-chosen_dp12))
(not (num-subs_l12))
)
)
(:action CHOOSE_E2F1_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_e2f1)
)
:effect
(and
(chosen_e2f1)
(num-subs_l13)
(not (not-chosen_e2f1))
(not (num-subs_l12))
)
)
(:action CHOOSE_E2F13_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_e2f13)
)
:effect
(and
(chosen_e2f13)
(num-subs_l13)
(not (not-chosen_e2f13))
(not (num-subs_l12))
)
)
(:action CHOOSE_E2F13-DP12_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_e2f13-dp12)
)
:effect
(and
(chosen_e2f13-dp12)
(num-subs_l13)
(not (not-chosen_e2f13-dp12))
(not (num-subs_l12))
)
)
(:action CHOOSE_E2F13P1-DP12_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_e2f13p1-dp12)
)
:effect
(and
(chosen_e2f13p1-dp12)
(num-subs_l13)
(not (not-chosen_e2f13p1-dp12))
(not (num-subs_l12))
)
)
(:action CHOOSE_E2F3_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_e2f3)
)
:effect
(and
(chosen_e2f3)
(num-subs_l13)
(not (not-chosen_e2f3))
(not (num-subs_l12))
)
)
(:action CHOOSE_E2F4_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_e2f4)
)
:effect
(and
(chosen_e2f4)
(num-subs_l13)
(not (not-chosen_e2f4))
(not (num-subs_l12))
)
)
(:action CHOOSE_E2F4-DP12P1_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_e2f4-dp12p1)
)
:effect
(and
(chosen_e2f4-dp12p1)
(num-subs_l13)
(not (not-chosen_e2f4-dp12p1))
(not (num-subs_l12))
)
)
(:action CHOOSE_E2F5_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_e2f5)
)
:effect
(and
(chosen_e2f5)
(num-subs_l13)
(not (not-chosen_e2f5))
(not (num-subs_l12))
)
)
(:action CHOOSE_E2F6-DP12P1_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_e2f6-dp12p1)
)
:effect
(and
(chosen_e2f6-dp12p1)
(num-subs_l13)
(not (not-chosen_e2f6-dp12p1))
(not (num-subs_l12))
)
)
(:action CHOOSE_GCDC25A_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_gcdc25a)
)
:effect
(and
(chosen_gcdc25a)
(num-subs_l13)
(not (not-chosen_gcdc25a))
(not (num-subs_l12))
)
)
(:action CHOOSE_GE2_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_ge2)
)
:effect
(and
(chosen_ge2)
(num-subs_l13)
(not (not-chosen_ge2))
(not (num-subs_l12))
)
)
(:action CHOOSE_GP19ARF_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_gp19arf)
)
:effect
(and
(chosen_gp19arf)
(num-subs_l13)
(not (not-chosen_gp19arf))
(not (num-subs_l12))
)
)
(:action CHOOSE_HDAC1_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_hdac1)
)
:effect
(and
(chosen_hdac1)
(num-subs_l13)
(not (not-chosen_hdac1))
(not (num-subs_l12))
)
)
(:action CHOOSE_HDAC1-PRBP1-E2F13-DP12_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_hdac1-prbp1-e2f13-dp12)
)
:effect
(and
(chosen_hdac1-prbp1-e2f13-dp12)
(num-subs_l13)
(not (not-chosen_hdac1-prbp1-e2f13-dp12))
(not (num-subs_l12))
)
)
(:action CHOOSE_HDAC1-PRBP1-E2F13P1-DP12_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_hdac1-prbp1-e2f13p1-dp12)
)
:effect
(and
(chosen_hdac1-prbp1-e2f13p1-dp12)
(num-subs_l13)
(not (not-chosen_hdac1-prbp1-e2f13p1-dp12))
(not (num-subs_l12))
)
)
(:action CHOOSE_HDAC1-PRBP1-E2F4-DP12_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_hdac1-prbp1-e2f4-dp12)
)
:effect
(and
(chosen_hdac1-prbp1-e2f4-dp12)
(num-subs_l13)
(not (not-chosen_hdac1-prbp1-e2f4-dp12))
(not (num-subs_l12))
)
)
(:action CHOOSE_JUN_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_jun)
)
:effect
(and
(chosen_jun)
(num-subs_l13)
(not (not-chosen_jun))
(not (num-subs_l12))
)
)
(:action CHOOSE_MAX_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_max)
)
:effect
(and
(chosen_max)
(num-subs_l13)
(not (not-chosen_max))
(not (num-subs_l12))
)
)
(:action CHOOSE_P130_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_p130)
)
:effect
(and
(chosen_p130)
(num-subs_l13)
(not (not-chosen_p130))
(not (num-subs_l12))
)
)
(:action CHOOSE_P130-E2F4P1-DP12_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_p130-e2f4p1-dp12)
)
:effect
(and
(chosen_p130-e2f4p1-dp12)
(num-subs_l13)
(not (not-chosen_p130-e2f4p1-dp12))
(not (num-subs_l12))
)
)
(:action CHOOSE_P130-E2F5P1-DP12_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_p130-e2f5p1-dp12)
)
:effect
(and
(chosen_p130-e2f5p1-dp12)
(num-subs_l13)
(not (not-chosen_p130-e2f5p1-dp12))
(not (num-subs_l12))
)
)
(:action CHOOSE_P27_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_p27)
)
:effect
(and
(chosen_p27)
(num-subs_l13)
(not (not-chosen_p27))
(not (num-subs_l12))
)
)
(:action CHOOSE_P57_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_p57)
)
:effect
(and
(chosen_p57)
(num-subs_l13)
(not (not-chosen_p57))
(not (num-subs_l12))
)
)
(:action CHOOSE_P57P1_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_p57p1)
)
:effect
(and
(chosen_p57p1)
(num-subs_l13)
(not (not-chosen_p57p1))
(not (num-subs_l12))
)
)
(:action CHOOSE_PLK1_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_plk1)
)
:effect
(and
(chosen_plk1)
(num-subs_l13)
(not (not-chosen_plk1))
(not (num-subs_l12))
)
)
(:action CHOOSE_PRB-E2F4P1-DP12_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_prb-e2f4p1-dp12)
)
:effect
(and
(chosen_prb-e2f4p1-dp12)
(num-subs_l13)
(not (not-chosen_prb-e2f4p1-dp12))
(not (num-subs_l12))
)
)
(:action CHOOSE_PRBP1-E2F4P1-DP12_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_prbp1-e2f4p1-dp12)
)
:effect
(and
(chosen_prbp1-e2f4p1-dp12)
(num-subs_l13)
(not (not-chosen_prbp1-e2f4p1-dp12))
(not (num-subs_l12))
)
)
(:action CHOOSE_PRBP2_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_prbp2)
)
:effect
(and
(chosen_prbp2)
(num-subs_l13)
(not (not-chosen_prbp2))
(not (num-subs_l12))
)
)
(:action CHOOSE_RAF1_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_raf1)
)
:effect
(and
(chosen_raf1)
(num-subs_l13)
(not (not-chosen_raf1))
(not (num-subs_l12))
)
)
(:action CHOOSE_RPA_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_rpa)
)
:effect
(and
(chosen_rpa)
(num-subs_l13)
(not (not-chosen_rpa))
(not (num-subs_l12))
)
)
(:action CHOOSE_SKP1_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_skp1)
)
:effect
(and
(chosen_skp1)
(num-subs_l13)
(not (not-chosen_skp1))
(not (num-subs_l12))
)
)
(:action CHOOSE_SKP2_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_skp2)
)
:effect
(and
(chosen_skp2)
(num-subs_l13)
(not (not-chosen_skp2))
(not (num-subs_l12))
)
)
(:action CHOOSE_SP1_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_sp1)
)
:effect
(and
(chosen_sp1)
(num-subs_l13)
(not (not-chosen_sp1))
(not (num-subs_l12))
)
)
(:action CHOOSE_APC_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_apc)
)
:effect
(and
(chosen_apc)
(num-subs_l12)
(not (not-chosen_apc))
(not (num-subs_l11))
)
)
(:action CHOOSE_CDK2P1_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_cdk2p1)
)
:effect
(and
(chosen_cdk2p1)
(num-subs_l12)
(not (not-chosen_cdk2p1))
(not (num-subs_l11))
)
)
(:action CHOOSE_CDK46P1_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_cdk46p1)
)
:effect
(and
(chosen_cdk46p1)
(num-subs_l12)
(not (not-chosen_cdk46p1))
(not (num-subs_l11))
)
)
(:action CHOOSE_CDK46P3-CYCD_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_cdk46p3-cycd)
)
:effect
(and
(chosen_cdk46p3-cycd)
(num-subs_l12)
(not (not-chosen_cdk46p3-cycd))
(not (num-subs_l11))
)
)
(:action CHOOSE_DMP1_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_dmp1)
)
:effect
(and
(chosen_dmp1)
(num-subs_l12)
(not (not-chosen_dmp1))
(not (num-subs_l11))
)
)
(:action CHOOSE_DP12_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_dp12)
)
:effect
(and
(chosen_dp12)
(num-subs_l12)
(not (not-chosen_dp12))
(not (num-subs_l11))
)
)
(:action CHOOSE_E2F1_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_e2f1)
)
:effect
(and
(chosen_e2f1)
(num-subs_l12)
(not (not-chosen_e2f1))
(not (num-subs_l11))
)
)
(:action CHOOSE_E2F13_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_e2f13)
)
:effect
(and
(chosen_e2f13)
(num-subs_l12)
(not (not-chosen_e2f13))
(not (num-subs_l11))
)
)
(:action CHOOSE_E2F13-DP12_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_e2f13-dp12)
)
:effect
(and
(chosen_e2f13-dp12)
(num-subs_l12)
(not (not-chosen_e2f13-dp12))
(not (num-subs_l11))
)
)
(:action CHOOSE_E2F13P1-DP12_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_e2f13p1-dp12)
)
:effect
(and
(chosen_e2f13p1-dp12)
(num-subs_l12)
(not (not-chosen_e2f13p1-dp12))
(not (num-subs_l11))
)
)
(:action CHOOSE_E2F3_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_e2f3)
)
:effect
(and
(chosen_e2f3)
(num-subs_l12)
(not (not-chosen_e2f3))
(not (num-subs_l11))
)
)
(:action CHOOSE_E2F4_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_e2f4)
)
:effect
(and
(chosen_e2f4)
(num-subs_l12)
(not (not-chosen_e2f4))
(not (num-subs_l11))
)
)
(:action CHOOSE_E2F4-DP12P1_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_e2f4-dp12p1)
)
:effect
(and
(chosen_e2f4-dp12p1)
(num-subs_l12)
(not (not-chosen_e2f4-dp12p1))
(not (num-subs_l11))
)
)
(:action CHOOSE_E2F5_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_e2f5)
)
:effect
(and
(chosen_e2f5)
(num-subs_l12)
(not (not-chosen_e2f5))
(not (num-subs_l11))
)
)
(:action CHOOSE_E2F6-DP12P1_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_e2f6-dp12p1)
)
:effect
(and
(chosen_e2f6-dp12p1)
(num-subs_l12)
(not (not-chosen_e2f6-dp12p1))
(not (num-subs_l11))
)
)
(:action CHOOSE_GCDC25A_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_gcdc25a)
)
:effect
(and
(chosen_gcdc25a)
(num-subs_l12)
(not (not-chosen_gcdc25a))
(not (num-subs_l11))
)
)
(:action CHOOSE_GE2_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_ge2)
)
:effect
(and
(chosen_ge2)
(num-subs_l12)
(not (not-chosen_ge2))
(not (num-subs_l11))
)
)
(:action CHOOSE_GP19ARF_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_gp19arf)
)
:effect
(and
(chosen_gp19arf)
(num-subs_l12)
(not (not-chosen_gp19arf))
(not (num-subs_l11))
)
)
(:action CHOOSE_HDAC1_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_hdac1)
)
:effect
(and
(chosen_hdac1)
(num-subs_l12)
(not (not-chosen_hdac1))
(not (num-subs_l11))
)
)
(:action CHOOSE_HDAC1-PRBP1-E2F13-DP12_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_hdac1-prbp1-e2f13-dp12)
)
:effect
(and
(chosen_hdac1-prbp1-e2f13-dp12)
(num-subs_l12)
(not (not-chosen_hdac1-prbp1-e2f13-dp12))
(not (num-subs_l11))
)
)
(:action CHOOSE_HDAC1-PRBP1-E2F13P1-DP12_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_hdac1-prbp1-e2f13p1-dp12)
)
:effect
(and
(chosen_hdac1-prbp1-e2f13p1-dp12)
(num-subs_l12)
(not (not-chosen_hdac1-prbp1-e2f13p1-dp12))
(not (num-subs_l11))
)
)
(:action CHOOSE_HDAC1-PRBP1-E2F4-DP12_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_hdac1-prbp1-e2f4-dp12)
)
:effect
(and
(chosen_hdac1-prbp1-e2f4-dp12)
(num-subs_l12)
(not (not-chosen_hdac1-prbp1-e2f4-dp12))
(not (num-subs_l11))
)
)
(:action CHOOSE_JUN_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_jun)
)
:effect
(and
(chosen_jun)
(num-subs_l12)
(not (not-chosen_jun))
(not (num-subs_l11))
)
)
(:action CHOOSE_MAX_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_max)
)
:effect
(and
(chosen_max)
(num-subs_l12)
(not (not-chosen_max))
(not (num-subs_l11))
)
)
(:action CHOOSE_P130_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_p130)
)
:effect
(and
(chosen_p130)
(num-subs_l12)
(not (not-chosen_p130))
(not (num-subs_l11))
)
)
(:action CHOOSE_P130-E2F4P1-DP12_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_p130-e2f4p1-dp12)
)
:effect
(and
(chosen_p130-e2f4p1-dp12)
(num-subs_l12)
(not (not-chosen_p130-e2f4p1-dp12))
(not (num-subs_l11))
)
)
(:action CHOOSE_P130-E2F5P1-DP12_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_p130-e2f5p1-dp12)
)
:effect
(and
(chosen_p130-e2f5p1-dp12)
(num-subs_l12)
(not (not-chosen_p130-e2f5p1-dp12))
(not (num-subs_l11))
)
)
(:action CHOOSE_P27_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_p27)
)
:effect
(and
(chosen_p27)
(num-subs_l12)
(not (not-chosen_p27))
(not (num-subs_l11))
)
)
(:action CHOOSE_P57_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_p57)
)
:effect
(and
(chosen_p57)
(num-subs_l12)
(not (not-chosen_p57))
(not (num-subs_l11))
)
)
(:action CHOOSE_P57P1_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_p57p1)
)
:effect
(and
(chosen_p57p1)
(num-subs_l12)
(not (not-chosen_p57p1))
(not (num-subs_l11))
)
)
(:action CHOOSE_PLK1_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_plk1)
)
:effect
(and
(chosen_plk1)
(num-subs_l12)
(not (not-chosen_plk1))
(not (num-subs_l11))
)
)
(:action CHOOSE_PRB-E2F4P1-DP12_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_prb-e2f4p1-dp12)
)
:effect
(and
(chosen_prb-e2f4p1-dp12)
(num-subs_l12)
(not (not-chosen_prb-e2f4p1-dp12))
(not (num-subs_l11))
)
)
(:action CHOOSE_PRBP1-E2F4P1-DP12_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_prbp1-e2f4p1-dp12)
)
:effect
(and
(chosen_prbp1-e2f4p1-dp12)
(num-subs_l12)
(not (not-chosen_prbp1-e2f4p1-dp12))
(not (num-subs_l11))
)
)
(:action CHOOSE_PRBP2_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_prbp2)
)
:effect
(and
(chosen_prbp2)
(num-subs_l12)
(not (not-chosen_prbp2))
(not (num-subs_l11))
)
)
(:action CHOOSE_RAF1_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_raf1)
)
:effect
(and
(chosen_raf1)
(num-subs_l12)
(not (not-chosen_raf1))
(not (num-subs_l11))
)
)
(:action CHOOSE_RPA_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_rpa)
)
:effect
(and
(chosen_rpa)
(num-subs_l12)
(not (not-chosen_rpa))
(not (num-subs_l11))
)
)
(:action CHOOSE_SKP1_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_skp1)
)
:effect
(and
(chosen_skp1)
(num-subs_l12)
(not (not-chosen_skp1))
(not (num-subs_l11))
)
)
(:action CHOOSE_SKP2_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_skp2)
)
:effect
(and
(chosen_skp2)
(num-subs_l12)
(not (not-chosen_skp2))
(not (num-subs_l11))
)
)
(:action CHOOSE_SP1_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_sp1)
)
:effect
(and
(chosen_sp1)
(num-subs_l12)
(not (not-chosen_sp1))
(not (num-subs_l11))
)
)
(:action CHOOSE_APC_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_apc)
)
:effect
(and
(chosen_apc)
(num-subs_l11)
(not (not-chosen_apc))
(not (num-subs_l10))
)
)
(:action CHOOSE_CDK2P1_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_cdk2p1)
)
:effect
(and
(chosen_cdk2p1)
(num-subs_l11)
(not (not-chosen_cdk2p1))
(not (num-subs_l10))
)
)
(:action CHOOSE_CDK46P1_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_cdk46p1)
)
:effect
(and
(chosen_cdk46p1)
(num-subs_l11)
(not (not-chosen_cdk46p1))
(not (num-subs_l10))
)
)
(:action CHOOSE_CDK46P3-CYCD_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_cdk46p3-cycd)
)
:effect
(and
(chosen_cdk46p3-cycd)
(num-subs_l11)
(not (not-chosen_cdk46p3-cycd))
(not (num-subs_l10))
)
)
(:action CHOOSE_DMP1_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_dmp1)
)
:effect
(and
(chosen_dmp1)
(num-subs_l11)
(not (not-chosen_dmp1))
(not (num-subs_l10))
)
)
(:action CHOOSE_DP12_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_dp12)
)
:effect
(and
(chosen_dp12)
(num-subs_l11)
(not (not-chosen_dp12))
(not (num-subs_l10))
)
)
(:action CHOOSE_E2F1_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_e2f1)
)
:effect
(and
(chosen_e2f1)
(num-subs_l11)
(not (not-chosen_e2f1))
(not (num-subs_l10))
)
)
(:action CHOOSE_E2F13_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_e2f13)
)
:effect
(and
(chosen_e2f13)
(num-subs_l11)
(not (not-chosen_e2f13))
(not (num-subs_l10))
)
)
(:action CHOOSE_E2F13-DP12_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_e2f13-dp12)
)
:effect
(and
(chosen_e2f13-dp12)
(num-subs_l11)
(not (not-chosen_e2f13-dp12))
(not (num-subs_l10))
)
)
(:action CHOOSE_E2F13P1-DP12_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_e2f13p1-dp12)
)
:effect
(and
(chosen_e2f13p1-dp12)
(num-subs_l11)
(not (not-chosen_e2f13p1-dp12))
(not (num-subs_l10))
)
)
(:action CHOOSE_E2F3_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_e2f3)
)
:effect
(and
(chosen_e2f3)
(num-subs_l11)
(not (not-chosen_e2f3))
(not (num-subs_l10))
)
)
(:action CHOOSE_E2F4_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_e2f4)
)
:effect
(and
(chosen_e2f4)
(num-subs_l11)
(not (not-chosen_e2f4))
(not (num-subs_l10))
)
)
(:action CHOOSE_E2F4-DP12P1_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_e2f4-dp12p1)
)
:effect
(and
(chosen_e2f4-dp12p1)
(num-subs_l11)
(not (not-chosen_e2f4-dp12p1))
(not (num-subs_l10))
)
)
(:action CHOOSE_E2F5_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_e2f5)
)
:effect
(and
(chosen_e2f5)
(num-subs_l11)
(not (not-chosen_e2f5))
(not (num-subs_l10))
)
)
(:action CHOOSE_E2F6-DP12P1_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_e2f6-dp12p1)
)
:effect
(and
(chosen_e2f6-dp12p1)
(num-subs_l11)
(not (not-chosen_e2f6-dp12p1))
(not (num-subs_l10))
)
)
(:action CHOOSE_GCDC25A_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_gcdc25a)
)
:effect
(and
(chosen_gcdc25a)
(num-subs_l11)
(not (not-chosen_gcdc25a))
(not (num-subs_l10))
)
)
(:action CHOOSE_GE2_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_ge2)
)
:effect
(and
(chosen_ge2)
(num-subs_l11)
(not (not-chosen_ge2))
(not (num-subs_l10))
)
)
(:action CHOOSE_GP19ARF_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_gp19arf)
)
:effect
(and
(chosen_gp19arf)
(num-subs_l11)
(not (not-chosen_gp19arf))
(not (num-subs_l10))
)
)
(:action CHOOSE_HDAC1_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_hdac1)
)
:effect
(and
(chosen_hdac1)
(num-subs_l11)
(not (not-chosen_hdac1))
(not (num-subs_l10))
)
)
(:action CHOOSE_HDAC1-PRBP1-E2F13-DP12_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_hdac1-prbp1-e2f13-dp12)
)
:effect
(and
(chosen_hdac1-prbp1-e2f13-dp12)
(num-subs_l11)
(not (not-chosen_hdac1-prbp1-e2f13-dp12))
(not (num-subs_l10))
)
)
(:action CHOOSE_HDAC1-PRBP1-E2F13P1-DP12_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_hdac1-prbp1-e2f13p1-dp12)
)
:effect
(and
(chosen_hdac1-prbp1-e2f13p1-dp12)
(num-subs_l11)
(not (not-chosen_hdac1-prbp1-e2f13p1-dp12))
(not (num-subs_l10))
)
)
(:action CHOOSE_HDAC1-PRBP1-E2F4-DP12_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_hdac1-prbp1-e2f4-dp12)
)
:effect
(and
(chosen_hdac1-prbp1-e2f4-dp12)
(num-subs_l11)
(not (not-chosen_hdac1-prbp1-e2f4-dp12))
(not (num-subs_l10))
)
)
(:action CHOOSE_JUN_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_jun)
)
:effect
(and
(chosen_jun)
(num-subs_l11)
(not (not-chosen_jun))
(not (num-subs_l10))
)
)
(:action CHOOSE_MAX_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_max)
)
:effect
(and
(chosen_max)
(num-subs_l11)
(not (not-chosen_max))
(not (num-subs_l10))
)
)
(:action CHOOSE_P130_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_p130)
)
:effect
(and
(chosen_p130)
(num-subs_l11)
(not (not-chosen_p130))
(not (num-subs_l10))
)
)
(:action CHOOSE_P130-E2F4P1-DP12_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_p130-e2f4p1-dp12)
)
:effect
(and
(chosen_p130-e2f4p1-dp12)
(num-subs_l11)
(not (not-chosen_p130-e2f4p1-dp12))
(not (num-subs_l10))
)
)
(:action CHOOSE_P130-E2F5P1-DP12_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_p130-e2f5p1-dp12)
)
:effect
(and
(chosen_p130-e2f5p1-dp12)
(num-subs_l11)
(not (not-chosen_p130-e2f5p1-dp12))
(not (num-subs_l10))
)
)
(:action CHOOSE_P27_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_p27)
)
:effect
(and
(chosen_p27)
(num-subs_l11)
(not (not-chosen_p27))
(not (num-subs_l10))
)
)
(:action CHOOSE_P57_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_p57)
)
:effect
(and
(chosen_p57)
(num-subs_l11)
(not (not-chosen_p57))
(not (num-subs_l10))
)
)
(:action CHOOSE_P57P1_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_p57p1)
)
:effect
(and
(chosen_p57p1)
(num-subs_l11)
(not (not-chosen_p57p1))
(not (num-subs_l10))
)
)
(:action CHOOSE_PLK1_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_plk1)
)
:effect
(and
(chosen_plk1)
(num-subs_l11)
(not (not-chosen_plk1))
(not (num-subs_l10))
)
)
(:action CHOOSE_PRB-E2F4P1-DP12_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_prb-e2f4p1-dp12)
)
:effect
(and
(chosen_prb-e2f4p1-dp12)
(num-subs_l11)
(not (not-chosen_prb-e2f4p1-dp12))
(not (num-subs_l10))
)
)
(:action CHOOSE_PRBP1-E2F4P1-DP12_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_prbp1-e2f4p1-dp12)
)
:effect
(and
(chosen_prbp1-e2f4p1-dp12)
(num-subs_l11)
(not (not-chosen_prbp1-e2f4p1-dp12))
(not (num-subs_l10))
)
)
(:action CHOOSE_PRBP2_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_prbp2)
)
:effect
(and
(chosen_prbp2)
(num-subs_l11)
(not (not-chosen_prbp2))
(not (num-subs_l10))
)
)
(:action CHOOSE_RAF1_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_raf1)
)
:effect
(and
(chosen_raf1)
(num-subs_l11)
(not (not-chosen_raf1))
(not (num-subs_l10))
)
)
(:action CHOOSE_RPA_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_rpa)
)
:effect
(and
(chosen_rpa)
(num-subs_l11)
(not (not-chosen_rpa))
(not (num-subs_l10))
)
)
(:action CHOOSE_SKP1_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_skp1)
)
:effect
(and
(chosen_skp1)
(num-subs_l11)
(not (not-chosen_skp1))
(not (num-subs_l10))
)
)
(:action CHOOSE_SKP2_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_skp2)
)
:effect
(and
(chosen_skp2)
(num-subs_l11)
(not (not-chosen_skp2))
(not (num-subs_l10))
)
)
(:action CHOOSE_SP1_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_sp1)
)
:effect
(and
(chosen_sp1)
(num-subs_l11)
(not (not-chosen_sp1))
(not (num-subs_l10))
)
)
(:action CHOOSE_APC_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_apc)
)
:effect
(and
(chosen_apc)
(num-subs_l10)
(not (not-chosen_apc))
(not (num-subs_l9))
)
)
(:action CHOOSE_CDK2P1_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_cdk2p1)
)
:effect
(and
(chosen_cdk2p1)
(num-subs_l10)
(not (not-chosen_cdk2p1))
(not (num-subs_l9))
)
)
(:action CHOOSE_CDK46P1_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_cdk46p1)
)
:effect
(and
(chosen_cdk46p1)
(num-subs_l10)
(not (not-chosen_cdk46p1))
(not (num-subs_l9))
)
)
(:action CHOOSE_CDK46P3-CYCD_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_cdk46p3-cycd)
)
:effect
(and
(chosen_cdk46p3-cycd)
(num-subs_l10)
(not (not-chosen_cdk46p3-cycd))
(not (num-subs_l9))
)
)
(:action CHOOSE_DMP1_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_dmp1)
)
:effect
(and
(chosen_dmp1)
(num-subs_l10)
(not (not-chosen_dmp1))
(not (num-subs_l9))
)
)
(:action CHOOSE_DP12_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_dp12)
)
:effect
(and
(chosen_dp12)
(num-subs_l10)
(not (not-chosen_dp12))
(not (num-subs_l9))
)
)
(:action CHOOSE_E2F1_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_e2f1)
)
:effect
(and
(chosen_e2f1)
(num-subs_l10)
(not (not-chosen_e2f1))
(not (num-subs_l9))
)
)
(:action CHOOSE_E2F13_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_e2f13)
)
:effect
(and
(chosen_e2f13)
(num-subs_l10)
(not (not-chosen_e2f13))
(not (num-subs_l9))
)
)
(:action CHOOSE_E2F13-DP12_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_e2f13-dp12)
)
:effect
(and
(chosen_e2f13-dp12)
(num-subs_l10)
(not (not-chosen_e2f13-dp12))
(not (num-subs_l9))
)
)
(:action CHOOSE_E2F13P1-DP12_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_e2f13p1-dp12)
)
:effect
(and
(chosen_e2f13p1-dp12)
(num-subs_l10)
(not (not-chosen_e2f13p1-dp12))
(not (num-subs_l9))
)
)
(:action CHOOSE_E2F3_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_e2f3)
)
:effect
(and
(chosen_e2f3)
(num-subs_l10)
(not (not-chosen_e2f3))
(not (num-subs_l9))
)
)
(:action CHOOSE_E2F4_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_e2f4)
)
:effect
(and
(chosen_e2f4)
(num-subs_l10)
(not (not-chosen_e2f4))
(not (num-subs_l9))
)
)
(:action CHOOSE_E2F4-DP12P1_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_e2f4-dp12p1)
)
:effect
(and
(chosen_e2f4-dp12p1)
(num-subs_l10)
(not (not-chosen_e2f4-dp12p1))
(not (num-subs_l9))
)
)
(:action CHOOSE_E2F5_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_e2f5)
)
:effect
(and
(chosen_e2f5)
(num-subs_l10)
(not (not-chosen_e2f5))
(not (num-subs_l9))
)
)
(:action CHOOSE_E2F6-DP12P1_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_e2f6-dp12p1)
)
:effect
(and
(chosen_e2f6-dp12p1)
(num-subs_l10)
(not (not-chosen_e2f6-dp12p1))
(not (num-subs_l9))
)
)
(:action CHOOSE_GCDC25A_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_gcdc25a)
)
:effect
(and
(chosen_gcdc25a)
(num-subs_l10)
(not (not-chosen_gcdc25a))
(not (num-subs_l9))
)
)
(:action CHOOSE_GE2_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_ge2)
)
:effect
(and
(chosen_ge2)
(num-subs_l10)
(not (not-chosen_ge2))
(not (num-subs_l9))
)
)
(:action CHOOSE_GP19ARF_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_gp19arf)
)
:effect
(and
(chosen_gp19arf)
(num-subs_l10)
(not (not-chosen_gp19arf))
(not (num-subs_l9))
)
)
(:action CHOOSE_HDAC1_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_hdac1)
)
:effect
(and
(chosen_hdac1)
(num-subs_l10)
(not (not-chosen_hdac1))
(not (num-subs_l9))
)
)
(:action CHOOSE_HDAC1-PRBP1-E2F13-DP12_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_hdac1-prbp1-e2f13-dp12)
)
:effect
(and
(chosen_hdac1-prbp1-e2f13-dp12)
(num-subs_l10)
(not (not-chosen_hdac1-prbp1-e2f13-dp12))
(not (num-subs_l9))
)
)
(:action CHOOSE_HDAC1-PRBP1-E2F13P1-DP12_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_hdac1-prbp1-e2f13p1-dp12)
)
:effect
(and
(chosen_hdac1-prbp1-e2f13p1-dp12)
(num-subs_l10)
(not (not-chosen_hdac1-prbp1-e2f13p1-dp12))
(not (num-subs_l9))
)
)
(:action CHOOSE_HDAC1-PRBP1-E2F4-DP12_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_hdac1-prbp1-e2f4-dp12)
)
:effect
(and
(chosen_hdac1-prbp1-e2f4-dp12)
(num-subs_l10)
(not (not-chosen_hdac1-prbp1-e2f4-dp12))
(not (num-subs_l9))
)
)
(:action CHOOSE_JUN_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_jun)
)
:effect
(and
(chosen_jun)
(num-subs_l10)
(not (not-chosen_jun))
(not (num-subs_l9))
)
)
(:action CHOOSE_MAX_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_max)
)
:effect
(and
(chosen_max)
(num-subs_l10)
(not (not-chosen_max))
(not (num-subs_l9))
)
)
(:action CHOOSE_P130_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_p130)
)
:effect
(and
(chosen_p130)
(num-subs_l10)
(not (not-chosen_p130))
(not (num-subs_l9))
)
)
(:action CHOOSE_P130-E2F4P1-DP12_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_p130-e2f4p1-dp12)
)
:effect
(and
(chosen_p130-e2f4p1-dp12)
(num-subs_l10)
(not (not-chosen_p130-e2f4p1-dp12))
(not (num-subs_l9))
)
)
(:action CHOOSE_P130-E2F5P1-DP12_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_p130-e2f5p1-dp12)
)
:effect
(and
(chosen_p130-e2f5p1-dp12)
(num-subs_l10)
(not (not-chosen_p130-e2f5p1-dp12))
(not (num-subs_l9))
)
)
(:action CHOOSE_P27_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_p27)
)
:effect
(and
(chosen_p27)
(num-subs_l10)
(not (not-chosen_p27))
(not (num-subs_l9))
)
)
(:action CHOOSE_P57_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_p57)
)
:effect
(and
(chosen_p57)
(num-subs_l10)
(not (not-chosen_p57))
(not (num-subs_l9))
)
)
(:action CHOOSE_P57P1_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_p57p1)
)
:effect
(and
(chosen_p57p1)
(num-subs_l10)
(not (not-chosen_p57p1))
(not (num-subs_l9))
)
)
(:action CHOOSE_PLK1_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_plk1)
)
:effect
(and
(chosen_plk1)
(num-subs_l10)
(not (not-chosen_plk1))
(not (num-subs_l9))
)
)
(:action CHOOSE_PRB-E2F4P1-DP12_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_prb-e2f4p1-dp12)
)
:effect
(and
(chosen_prb-e2f4p1-dp12)
(num-subs_l10)
(not (not-chosen_prb-e2f4p1-dp12))
(not (num-subs_l9))
)
)
(:action CHOOSE_PRBP1-E2F4P1-DP12_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_prbp1-e2f4p1-dp12)
)
:effect
(and
(chosen_prbp1-e2f4p1-dp12)
(num-subs_l10)
(not (not-chosen_prbp1-e2f4p1-dp12))
(not (num-subs_l9))
)
)
(:action CHOOSE_PRBP2_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_prbp2)
)
:effect
(and
(chosen_prbp2)
(num-subs_l10)
(not (not-chosen_prbp2))
(not (num-subs_l9))
)
)
(:action CHOOSE_RAF1_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_raf1)
)
:effect
(and
(chosen_raf1)
(num-subs_l10)
(not (not-chosen_raf1))
(not (num-subs_l9))
)
)
(:action CHOOSE_RPA_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_rpa)
)
:effect
(and
(chosen_rpa)
(num-subs_l10)
(not (not-chosen_rpa))
(not (num-subs_l9))
)
)
(:action CHOOSE_SKP1_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_skp1)
)
:effect
(and
(chosen_skp1)
(num-subs_l10)
(not (not-chosen_skp1))
(not (num-subs_l9))
)
)
(:action CHOOSE_SKP2_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_skp2)
)
:effect
(and
(chosen_skp2)
(num-subs_l10)
(not (not-chosen_skp2))
(not (num-subs_l9))
)
)
(:action CHOOSE_SP1_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_sp1)
)
:effect
(and
(chosen_sp1)
(num-subs_l10)
(not (not-chosen_sp1))
(not (num-subs_l9))
)
)
(:action CHOOSE_APC_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_apc)
)
:effect
(and
(chosen_apc)
(num-subs_l9)
(not (not-chosen_apc))
(not (num-subs_l8))
)
)
(:action CHOOSE_CDK2P1_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_cdk2p1)
)
:effect
(and
(chosen_cdk2p1)
(num-subs_l9)
(not (not-chosen_cdk2p1))
(not (num-subs_l8))
)
)
(:action CHOOSE_CDK46P1_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_cdk46p1)
)
:effect
(and
(chosen_cdk46p1)
(num-subs_l9)
(not (not-chosen_cdk46p1))
(not (num-subs_l8))
)
)
(:action CHOOSE_CDK46P3-CYCD_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_cdk46p3-cycd)
)
:effect
(and
(chosen_cdk46p3-cycd)
(num-subs_l9)
(not (not-chosen_cdk46p3-cycd))
(not (num-subs_l8))
)
)
(:action CHOOSE_DMP1_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_dmp1)
)
:effect
(and
(chosen_dmp1)
(num-subs_l9)
(not (not-chosen_dmp1))
(not (num-subs_l8))
)
)
(:action CHOOSE_DP12_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_dp12)
)
:effect
(and
(chosen_dp12)
(num-subs_l9)
(not (not-chosen_dp12))
(not (num-subs_l8))
)
)
(:action CHOOSE_E2F1_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_e2f1)
)
:effect
(and
(chosen_e2f1)
(num-subs_l9)
(not (not-chosen_e2f1))
(not (num-subs_l8))
)
)
(:action CHOOSE_E2F13_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_e2f13)
)
:effect
(and
(chosen_e2f13)
(num-subs_l9)
(not (not-chosen_e2f13))
(not (num-subs_l8))
)
)
(:action CHOOSE_E2F13-DP12_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_e2f13-dp12)
)
:effect
(and
(chosen_e2f13-dp12)
(num-subs_l9)
(not (not-chosen_e2f13-dp12))
(not (num-subs_l8))
)
)
(:action CHOOSE_E2F13P1-DP12_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_e2f13p1-dp12)
)
:effect
(and
(chosen_e2f13p1-dp12)
(num-subs_l9)
(not (not-chosen_e2f13p1-dp12))
(not (num-subs_l8))
)
)
(:action CHOOSE_E2F3_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_e2f3)
)
:effect
(and
(chosen_e2f3)
(num-subs_l9)
(not (not-chosen_e2f3))
(not (num-subs_l8))
)
)
(:action CHOOSE_E2F4_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_e2f4)
)
:effect
(and
(chosen_e2f4)
(num-subs_l9)
(not (not-chosen_e2f4))
(not (num-subs_l8))
)
)
(:action CHOOSE_E2F4-DP12P1_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_e2f4-dp12p1)
)
:effect
(and
(chosen_e2f4-dp12p1)
(num-subs_l9)
(not (not-chosen_e2f4-dp12p1))
(not (num-subs_l8))
)
)
(:action CHOOSE_E2F5_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_e2f5)
)
:effect
(and
(chosen_e2f5)
(num-subs_l9)
(not (not-chosen_e2f5))
(not (num-subs_l8))
)
)
(:action CHOOSE_E2F6-DP12P1_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_e2f6-dp12p1)
)
:effect
(and
(chosen_e2f6-dp12p1)
(num-subs_l9)
(not (not-chosen_e2f6-dp12p1))
(not (num-subs_l8))
)
)
(:action CHOOSE_GCDC25A_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_gcdc25a)
)
:effect
(and
(chosen_gcdc25a)
(num-subs_l9)
(not (not-chosen_gcdc25a))
(not (num-subs_l8))
)
)
(:action CHOOSE_GE2_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_ge2)
)
:effect
(and
(chosen_ge2)
(num-subs_l9)
(not (not-chosen_ge2))
(not (num-subs_l8))
)
)
(:action CHOOSE_GP19ARF_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_gp19arf)
)
:effect
(and
(chosen_gp19arf)
(num-subs_l9)
(not (not-chosen_gp19arf))
(not (num-subs_l8))
)
)
(:action CHOOSE_HDAC1_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_hdac1)
)
:effect
(and
(chosen_hdac1)
(num-subs_l9)
(not (not-chosen_hdac1))
(not (num-subs_l8))
)
)
(:action CHOOSE_HDAC1-PRBP1-E2F13-DP12_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_hdac1-prbp1-e2f13-dp12)
)
:effect
(and
(chosen_hdac1-prbp1-e2f13-dp12)
(num-subs_l9)
(not (not-chosen_hdac1-prbp1-e2f13-dp12))
(not (num-subs_l8))
)
)
(:action CHOOSE_HDAC1-PRBP1-E2F13P1-DP12_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_hdac1-prbp1-e2f13p1-dp12)
)
:effect
(and
(chosen_hdac1-prbp1-e2f13p1-dp12)
(num-subs_l9)
(not (not-chosen_hdac1-prbp1-e2f13p1-dp12))
(not (num-subs_l8))
)
)
(:action CHOOSE_HDAC1-PRBP1-E2F4-DP12_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_hdac1-prbp1-e2f4-dp12)
)
:effect
(and
(chosen_hdac1-prbp1-e2f4-dp12)
(num-subs_l9)
(not (not-chosen_hdac1-prbp1-e2f4-dp12))
(not (num-subs_l8))
)
)
(:action CHOOSE_JUN_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_jun)
)
:effect
(and
(chosen_jun)
(num-subs_l9)
(not (not-chosen_jun))
(not (num-subs_l8))
)
)
(:action CHOOSE_MAX_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_max)
)
:effect
(and
(chosen_max)
(num-subs_l9)
(not (not-chosen_max))
(not (num-subs_l8))
)
)
(:action CHOOSE_P130_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_p130)
)
:effect
(and
(chosen_p130)
(num-subs_l9)
(not (not-chosen_p130))
(not (num-subs_l8))
)
)
(:action CHOOSE_P130-E2F4P1-DP12_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_p130-e2f4p1-dp12)
)
:effect
(and
(chosen_p130-e2f4p1-dp12)
(num-subs_l9)
(not (not-chosen_p130-e2f4p1-dp12))
(not (num-subs_l8))
)
)
(:action CHOOSE_P130-E2F5P1-DP12_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_p130-e2f5p1-dp12)
)
:effect
(and
(chosen_p130-e2f5p1-dp12)
(num-subs_l9)
(not (not-chosen_p130-e2f5p1-dp12))
(not (num-subs_l8))
)
)
(:action CHOOSE_P27_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_p27)
)
:effect
(and
(chosen_p27)
(num-subs_l9)
(not (not-chosen_p27))
(not (num-subs_l8))
)
)
(:action CHOOSE_P57_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_p57)
)
:effect
(and
(chosen_p57)
(num-subs_l9)
(not (not-chosen_p57))
(not (num-subs_l8))
)
)
(:action CHOOSE_P57P1_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_p57p1)
)
:effect
(and
(chosen_p57p1)
(num-subs_l9)
(not (not-chosen_p57p1))
(not (num-subs_l8))
)
)
(:action CHOOSE_PLK1_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_plk1)
)
:effect
(and
(chosen_plk1)
(num-subs_l9)
(not (not-chosen_plk1))
(not (num-subs_l8))
)
)
(:action CHOOSE_PRB-E2F4P1-DP12_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_prb-e2f4p1-dp12)
)
:effect
(and
(chosen_prb-e2f4p1-dp12)
(num-subs_l9)
(not (not-chosen_prb-e2f4p1-dp12))
(not (num-subs_l8))
)
)
(:action CHOOSE_PRBP1-E2F4P1-DP12_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_prbp1-e2f4p1-dp12)
)
:effect
(and
(chosen_prbp1-e2f4p1-dp12)
(num-subs_l9)
(not (not-chosen_prbp1-e2f4p1-dp12))
(not (num-subs_l8))
)
)
(:action CHOOSE_PRBP2_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_prbp2)
)
:effect
(and
(chosen_prbp2)
(num-subs_l9)
(not (not-chosen_prbp2))
(not (num-subs_l8))
)
)
(:action CHOOSE_RAF1_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_raf1)
)
:effect
(and
(chosen_raf1)
(num-subs_l9)
(not (not-chosen_raf1))
(not (num-subs_l8))
)
)
(:action CHOOSE_RPA_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_rpa)
)
:effect
(and
(chosen_rpa)
(num-subs_l9)
(not (not-chosen_rpa))
(not (num-subs_l8))
)
)
(:action CHOOSE_SKP1_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_skp1)
)
:effect
(and
(chosen_skp1)
(num-subs_l9)
(not (not-chosen_skp1))
(not (num-subs_l8))
)
)
(:action CHOOSE_SKP2_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_skp2)
)
:effect
(and
(chosen_skp2)
(num-subs_l9)
(not (not-chosen_skp2))
(not (num-subs_l8))
)
)
(:action CHOOSE_SP1_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_sp1)
)
:effect
(and
(chosen_sp1)
(num-subs_l9)
(not (not-chosen_sp1))
(not (num-subs_l8))
)
)
(:action CHOOSE_APC_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_apc)
)
:effect
(and
(chosen_apc)
(num-subs_l8)
(not (not-chosen_apc))
(not (num-subs_l7))
)
)
(:action CHOOSE_CDK2P1_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_cdk2p1)
)
:effect
(and
(chosen_cdk2p1)
(num-subs_l8)
(not (not-chosen_cdk2p1))
(not (num-subs_l7))
)
)
(:action CHOOSE_CDK46P1_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_cdk46p1)
)
:effect
(and
(chosen_cdk46p1)
(num-subs_l8)
(not (not-chosen_cdk46p1))
(not (num-subs_l7))
)
)
(:action CHOOSE_CDK46P3-CYCD_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_cdk46p3-cycd)
)
:effect
(and
(chosen_cdk46p3-cycd)
(num-subs_l8)
(not (not-chosen_cdk46p3-cycd))
(not (num-subs_l7))
)
)
(:action CHOOSE_DMP1_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_dmp1)
)
:effect
(and
(chosen_dmp1)
(num-subs_l8)
(not (not-chosen_dmp1))
(not (num-subs_l7))
)
)
(:action CHOOSE_DP12_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_dp12)
)
:effect
(and
(chosen_dp12)
(num-subs_l8)
(not (not-chosen_dp12))
(not (num-subs_l7))
)
)
(:action CHOOSE_E2F1_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_e2f1)
)
:effect
(and
(chosen_e2f1)
(num-subs_l8)
(not (not-chosen_e2f1))
(not (num-subs_l7))
)
)
(:action CHOOSE_E2F13_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_e2f13)
)
:effect
(and
(chosen_e2f13)
(num-subs_l8)
(not (not-chosen_e2f13))
(not (num-subs_l7))
)
)
(:action CHOOSE_E2F13-DP12_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_e2f13-dp12)
)
:effect
(and
(chosen_e2f13-dp12)
(num-subs_l8)
(not (not-chosen_e2f13-dp12))
(not (num-subs_l7))
)
)
(:action CHOOSE_E2F13P1-DP12_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_e2f13p1-dp12)
)
:effect
(and
(chosen_e2f13p1-dp12)
(num-subs_l8)
(not (not-chosen_e2f13p1-dp12))
(not (num-subs_l7))
)
)
(:action CHOOSE_E2F3_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_e2f3)
)
:effect
(and
(chosen_e2f3)
(num-subs_l8)
(not (not-chosen_e2f3))
(not (num-subs_l7))
)
)
(:action CHOOSE_E2F4_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_e2f4)
)
:effect
(and
(chosen_e2f4)
(num-subs_l8)
(not (not-chosen_e2f4))
(not (num-subs_l7))
)
)
(:action CHOOSE_E2F4-DP12P1_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_e2f4-dp12p1)
)
:effect
(and
(chosen_e2f4-dp12p1)
(num-subs_l8)
(not (not-chosen_e2f4-dp12p1))
(not (num-subs_l7))
)
)
(:action CHOOSE_E2F5_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_e2f5)
)
:effect
(and
(chosen_e2f5)
(num-subs_l8)
(not (not-chosen_e2f5))
(not (num-subs_l7))
)
)
(:action CHOOSE_E2F6-DP12P1_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_e2f6-dp12p1)
)
:effect
(and
(chosen_e2f6-dp12p1)
(num-subs_l8)
(not (not-chosen_e2f6-dp12p1))
(not (num-subs_l7))
)
)
(:action CHOOSE_GCDC25A_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_gcdc25a)
)
:effect
(and
(chosen_gcdc25a)
(num-subs_l8)
(not (not-chosen_gcdc25a))
(not (num-subs_l7))
)
)
(:action CHOOSE_GE2_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_ge2)
)
:effect
(and
(chosen_ge2)
(num-subs_l8)
(not (not-chosen_ge2))
(not (num-subs_l7))
)
)
(:action CHOOSE_GP19ARF_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_gp19arf)
)
:effect
(and
(chosen_gp19arf)
(num-subs_l8)
(not (not-chosen_gp19arf))
(not (num-subs_l7))
)
)
(:action CHOOSE_HDAC1_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_hdac1)
)
:effect
(and
(chosen_hdac1)
(num-subs_l8)
(not (not-chosen_hdac1))
(not (num-subs_l7))
)
)
(:action CHOOSE_HDAC1-PRBP1-E2F13-DP12_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_hdac1-prbp1-e2f13-dp12)
)
:effect
(and
(chosen_hdac1-prbp1-e2f13-dp12)
(num-subs_l8)
(not (not-chosen_hdac1-prbp1-e2f13-dp12))
(not (num-subs_l7))
)
)
(:action CHOOSE_HDAC1-PRBP1-E2F13P1-DP12_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_hdac1-prbp1-e2f13p1-dp12)
)
:effect
(and
(chosen_hdac1-prbp1-e2f13p1-dp12)
(num-subs_l8)
(not (not-chosen_hdac1-prbp1-e2f13p1-dp12))
(not (num-subs_l7))
)
)
(:action CHOOSE_HDAC1-PRBP1-E2F4-DP12_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_hdac1-prbp1-e2f4-dp12)
)
:effect
(and
(chosen_hdac1-prbp1-e2f4-dp12)
(num-subs_l8)
(not (not-chosen_hdac1-prbp1-e2f4-dp12))
(not (num-subs_l7))
)
)
(:action CHOOSE_JUN_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_jun)
)
:effect
(and
(chosen_jun)
(num-subs_l8)
(not (not-chosen_jun))
(not (num-subs_l7))
)
)
(:action CHOOSE_MAX_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_max)
)
:effect
(and
(chosen_max)
(num-subs_l8)
(not (not-chosen_max))
(not (num-subs_l7))
)
)
(:action CHOOSE_P130_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_p130)
)
:effect
(and
(chosen_p130)
(num-subs_l8)
(not (not-chosen_p130))
(not (num-subs_l7))
)
)
(:action CHOOSE_P130-E2F4P1-DP12_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_p130-e2f4p1-dp12)
)
:effect
(and
(chosen_p130-e2f4p1-dp12)
(num-subs_l8)
(not (not-chosen_p130-e2f4p1-dp12))
(not (num-subs_l7))
)
)
(:action CHOOSE_P130-E2F5P1-DP12_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_p130-e2f5p1-dp12)
)
:effect
(and
(chosen_p130-e2f5p1-dp12)
(num-subs_l8)
(not (not-chosen_p130-e2f5p1-dp12))
(not (num-subs_l7))
)
)
(:action CHOOSE_P27_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_p27)
)
:effect
(and
(chosen_p27)
(num-subs_l8)
(not (not-chosen_p27))
(not (num-subs_l7))
)
)
(:action CHOOSE_P57_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_p57)
)
:effect
(and
(chosen_p57)
(num-subs_l8)
(not (not-chosen_p57))
(not (num-subs_l7))
)
)
(:action CHOOSE_P57P1_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_p57p1)
)
:effect
(and
(chosen_p57p1)
(num-subs_l8)
(not (not-chosen_p57p1))
(not (num-subs_l7))
)
)
(:action CHOOSE_PLK1_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_plk1)
)
:effect
(and
(chosen_plk1)
(num-subs_l8)
(not (not-chosen_plk1))
(not (num-subs_l7))
)
)
(:action CHOOSE_PRB-E2F4P1-DP12_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_prb-e2f4p1-dp12)
)
:effect
(and
(chosen_prb-e2f4p1-dp12)
(num-subs_l8)
(not (not-chosen_prb-e2f4p1-dp12))
(not (num-subs_l7))
)
)
(:action CHOOSE_PRBP1-E2F4P1-DP12_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_prbp1-e2f4p1-dp12)
)
:effect
(and
(chosen_prbp1-e2f4p1-dp12)
(num-subs_l8)
(not (not-chosen_prbp1-e2f4p1-dp12))
(not (num-subs_l7))
)
)
(:action CHOOSE_PRBP2_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_prbp2)
)
:effect
(and
(chosen_prbp2)
(num-subs_l8)
(not (not-chosen_prbp2))
(not (num-subs_l7))
)
)
(:action CHOOSE_RAF1_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_raf1)
)
:effect
(and
(chosen_raf1)
(num-subs_l8)
(not (not-chosen_raf1))
(not (num-subs_l7))
)
)
(:action CHOOSE_RPA_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_rpa)
)
:effect
(and
(chosen_rpa)
(num-subs_l8)
(not (not-chosen_rpa))
(not (num-subs_l7))
)
)
(:action CHOOSE_SKP1_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_skp1)
)
:effect
(and
(chosen_skp1)
(num-subs_l8)
(not (not-chosen_skp1))
(not (num-subs_l7))
)
)
(:action CHOOSE_SKP2_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_skp2)
)
:effect
(and
(chosen_skp2)
(num-subs_l8)
(not (not-chosen_skp2))
(not (num-subs_l7))
)
)
(:action CHOOSE_SP1_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_sp1)
)
:effect
(and
(chosen_sp1)
(num-subs_l8)
(not (not-chosen_sp1))
(not (num-subs_l7))
)
)
(:action dummy-action-5-1
:parameters ()
:precondition
(and
(available_p27-cdk46-cycdp1)
)
:effect
(and
(goal5_)
)
)
(:action dummy-action-3-1
:parameters ()
:precondition
(and
(available_p57-cdk46-cycdp1)
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
(available_p57-cdk46-cycd)
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
(available_p27-cdk46-cycd)
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
(available_p57p1-cdk46-cycdp1)
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
(available_p57p1-cdk46-cycd)
)
:effect
(and
(goal1_)
)
)
(:action ASSOCIATE_P27_CDK46-CYCDP1_P27-CDK46-CYCDP1
:parameters ()
:precondition
(and
(available_cdk46-cycdp1)
(available_p27)
)
:effect
(and
(available_p27-cdk46-cycdp1)
(not (available_p27))
(not (available_cdk46-cycdp1))
)
)
(:action ASSOCIATE_P27_CDK46-CYCD_P27-CDK46-CYCD
:parameters ()
:precondition
(and
(available_cdk46-cycd)
(available_p27)
)
:effect
(and
(available_p27-cdk46-cycd)
(not (available_p27))
(not (available_cdk46-cycd))
)
)
(:action ASSOCIATE_P57_CDK46-CYCDP1_P57-CDK46-CYCDP1
:parameters ()
:precondition
(and
(available_cdk46-cycdp1)
(available_p57)
)
:effect
(and
(available_p57-cdk46-cycdp1)
(not (available_p57))
(not (available_cdk46-cycdp1))
)
)
(:action ASSOCIATE_P57_CDK46-CYCD_P57-CDK46-CYCD
:parameters ()
:precondition
(and
(available_cdk46-cycd)
(available_p57)
)
:effect
(and
(available_p57-cdk46-cycd)
(not (available_p57))
(not (available_cdk46-cycd))
)
)
(:action ASSOCIATE_P57P1_CDK46-CYCDP1_P57P1-CDK46-CYCDP1
:parameters ()
:precondition
(and
(available_cdk46-cycdp1)
(available_p57p1)
)
:effect
(and
(available_p57p1-cdk46-cycdp1)
(not (available_p57p1))
(not (available_cdk46-cycdp1))
)
)
(:action ASSOCIATE_P57P1_CDK46-CYCD_P57P1-CDK46-CYCD
:parameters ()
:precondition
(and
(available_cdk46-cycd)
(available_p57p1)
)
:effect
(and
(available_p57p1-cdk46-cycd)
(not (available_p57p1))
(not (available_cdk46-cycd))
)
)
(:action CHOOSE_APC_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_apc)
)
:effect
(and
(chosen_apc)
(num-subs_l7)
(not (not-chosen_apc))
(not (num-subs_l6))
)
)
(:action CHOOSE_CDK2P1_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_cdk2p1)
)
:effect
(and
(chosen_cdk2p1)
(num-subs_l7)
(not (not-chosen_cdk2p1))
(not (num-subs_l6))
)
)
(:action CHOOSE_CDK46P1_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_cdk46p1)
)
:effect
(and
(chosen_cdk46p1)
(num-subs_l7)
(not (not-chosen_cdk46p1))
(not (num-subs_l6))
)
)
(:action CHOOSE_CDK46P3-CYCD_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_cdk46p3-cycd)
)
:effect
(and
(chosen_cdk46p3-cycd)
(num-subs_l7)
(not (not-chosen_cdk46p3-cycd))
(not (num-subs_l6))
)
)
(:action CHOOSE_DMP1_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_dmp1)
)
:effect
(and
(chosen_dmp1)
(num-subs_l7)
(not (not-chosen_dmp1))
(not (num-subs_l6))
)
)
(:action CHOOSE_DP12_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_dp12)
)
:effect
(and
(chosen_dp12)
(num-subs_l7)
(not (not-chosen_dp12))
(not (num-subs_l6))
)
)
(:action CHOOSE_E2F1_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_e2f1)
)
:effect
(and
(chosen_e2f1)
(num-subs_l7)
(not (not-chosen_e2f1))
(not (num-subs_l6))
)
)
(:action CHOOSE_E2F13_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_e2f13)
)
:effect
(and
(chosen_e2f13)
(num-subs_l7)
(not (not-chosen_e2f13))
(not (num-subs_l6))
)
)
(:action CHOOSE_E2F13-DP12_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_e2f13-dp12)
)
:effect
(and
(chosen_e2f13-dp12)
(num-subs_l7)
(not (not-chosen_e2f13-dp12))
(not (num-subs_l6))
)
)
(:action CHOOSE_E2F13P1-DP12_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_e2f13p1-dp12)
)
:effect
(and
(chosen_e2f13p1-dp12)
(num-subs_l7)
(not (not-chosen_e2f13p1-dp12))
(not (num-subs_l6))
)
)
(:action CHOOSE_E2F3_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_e2f3)
)
:effect
(and
(chosen_e2f3)
(num-subs_l7)
(not (not-chosen_e2f3))
(not (num-subs_l6))
)
)
(:action CHOOSE_E2F4_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_e2f4)
)
:effect
(and
(chosen_e2f4)
(num-subs_l7)
(not (not-chosen_e2f4))
(not (num-subs_l6))
)
)
(:action CHOOSE_E2F4-DP12P1_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_e2f4-dp12p1)
)
:effect
(and
(chosen_e2f4-dp12p1)
(num-subs_l7)
(not (not-chosen_e2f4-dp12p1))
(not (num-subs_l6))
)
)
(:action CHOOSE_E2F5_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_e2f5)
)
:effect
(and
(chosen_e2f5)
(num-subs_l7)
(not (not-chosen_e2f5))
(not (num-subs_l6))
)
)
(:action CHOOSE_E2F6-DP12P1_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_e2f6-dp12p1)
)
:effect
(and
(chosen_e2f6-dp12p1)
(num-subs_l7)
(not (not-chosen_e2f6-dp12p1))
(not (num-subs_l6))
)
)
(:action CHOOSE_GCDC25A_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_gcdc25a)
)
:effect
(and
(chosen_gcdc25a)
(num-subs_l7)
(not (not-chosen_gcdc25a))
(not (num-subs_l6))
)
)
(:action CHOOSE_GE2_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_ge2)
)
:effect
(and
(chosen_ge2)
(num-subs_l7)
(not (not-chosen_ge2))
(not (num-subs_l6))
)
)
(:action CHOOSE_GP19ARF_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_gp19arf)
)
:effect
(and
(chosen_gp19arf)
(num-subs_l7)
(not (not-chosen_gp19arf))
(not (num-subs_l6))
)
)
(:action CHOOSE_HDAC1_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_hdac1)
)
:effect
(and
(chosen_hdac1)
(num-subs_l7)
(not (not-chosen_hdac1))
(not (num-subs_l6))
)
)
(:action CHOOSE_HDAC1-PRBP1-E2F13-DP12_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_hdac1-prbp1-e2f13-dp12)
)
:effect
(and
(chosen_hdac1-prbp1-e2f13-dp12)
(num-subs_l7)
(not (not-chosen_hdac1-prbp1-e2f13-dp12))
(not (num-subs_l6))
)
)
(:action CHOOSE_HDAC1-PRBP1-E2F13P1-DP12_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_hdac1-prbp1-e2f13p1-dp12)
)
:effect
(and
(chosen_hdac1-prbp1-e2f13p1-dp12)
(num-subs_l7)
(not (not-chosen_hdac1-prbp1-e2f13p1-dp12))
(not (num-subs_l6))
)
)
(:action CHOOSE_HDAC1-PRBP1-E2F4-DP12_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_hdac1-prbp1-e2f4-dp12)
)
:effect
(and
(chosen_hdac1-prbp1-e2f4-dp12)
(num-subs_l7)
(not (not-chosen_hdac1-prbp1-e2f4-dp12))
(not (num-subs_l6))
)
)
(:action CHOOSE_JUN_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_jun)
)
:effect
(and
(chosen_jun)
(num-subs_l7)
(not (not-chosen_jun))
(not (num-subs_l6))
)
)
(:action CHOOSE_MAX_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_max)
)
:effect
(and
(chosen_max)
(num-subs_l7)
(not (not-chosen_max))
(not (num-subs_l6))
)
)
(:action CHOOSE_P130_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_p130)
)
:effect
(and
(chosen_p130)
(num-subs_l7)
(not (not-chosen_p130))
(not (num-subs_l6))
)
)
(:action CHOOSE_P130-E2F4P1-DP12_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_p130-e2f4p1-dp12)
)
:effect
(and
(chosen_p130-e2f4p1-dp12)
(num-subs_l7)
(not (not-chosen_p130-e2f4p1-dp12))
(not (num-subs_l6))
)
)
(:action CHOOSE_P130-E2F5P1-DP12_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_p130-e2f5p1-dp12)
)
:effect
(and
(chosen_p130-e2f5p1-dp12)
(num-subs_l7)
(not (not-chosen_p130-e2f5p1-dp12))
(not (num-subs_l6))
)
)
(:action CHOOSE_P27_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_p27)
)
:effect
(and
(chosen_p27)
(num-subs_l7)
(not (not-chosen_p27))
(not (num-subs_l6))
)
)
(:action CHOOSE_P57_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_p57)
)
:effect
(and
(chosen_p57)
(num-subs_l7)
(not (not-chosen_p57))
(not (num-subs_l6))
)
)
(:action CHOOSE_P57P1_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_p57p1)
)
:effect
(and
(chosen_p57p1)
(num-subs_l7)
(not (not-chosen_p57p1))
(not (num-subs_l6))
)
)
(:action CHOOSE_PLK1_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_plk1)
)
:effect
(and
(chosen_plk1)
(num-subs_l7)
(not (not-chosen_plk1))
(not (num-subs_l6))
)
)
(:action CHOOSE_PRB-E2F4P1-DP12_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_prb-e2f4p1-dp12)
)
:effect
(and
(chosen_prb-e2f4p1-dp12)
(num-subs_l7)
(not (not-chosen_prb-e2f4p1-dp12))
(not (num-subs_l6))
)
)
(:action CHOOSE_PRBP1-E2F4P1-DP12_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_prbp1-e2f4p1-dp12)
)
:effect
(and
(chosen_prbp1-e2f4p1-dp12)
(num-subs_l7)
(not (not-chosen_prbp1-e2f4p1-dp12))
(not (num-subs_l6))
)
)
(:action CHOOSE_PRBP2_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_prbp2)
)
:effect
(and
(chosen_prbp2)
(num-subs_l7)
(not (not-chosen_prbp2))
(not (num-subs_l6))
)
)
(:action CHOOSE_RAF1_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_raf1)
)
:effect
(and
(chosen_raf1)
(num-subs_l7)
(not (not-chosen_raf1))
(not (num-subs_l6))
)
)
(:action CHOOSE_RPA_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_rpa)
)
:effect
(and
(chosen_rpa)
(num-subs_l7)
(not (not-chosen_rpa))
(not (num-subs_l6))
)
)
(:action CHOOSE_SKP1_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_skp1)
)
:effect
(and
(chosen_skp1)
(num-subs_l7)
(not (not-chosen_skp1))
(not (num-subs_l6))
)
)
(:action CHOOSE_SKP2_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_skp2)
)
:effect
(and
(chosen_skp2)
(num-subs_l7)
(not (not-chosen_skp2))
(not (num-subs_l6))
)
)
(:action CHOOSE_SP1_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_sp1)
)
:effect
(and
(chosen_sp1)
(num-subs_l7)
(not (not-chosen_sp1))
(not (num-subs_l6))
)
)
(:action dummy-action-14-1
:parameters ()
:precondition
(and
(available_p57-cdk2-cyca)
)
:effect
(and
(goal14_)
)
)
(:action dummy-action-13-1
:parameters ()
:precondition
(and
(available_p57-cdk2-cycep1)
)
:effect
(and
(goal13_)
)
)
(:action dummy-action-12-1
:parameters ()
:precondition
(and
(available_skp2-cdk2-cyca)
)
:effect
(and
(goal12_)
)
)
(:action dummy-action-8-1
:parameters ()
:precondition
(and
(available_cdk46-cycd)
)
:effect
(and
(goal8_)
)
)
(:action dummy-action-7-1
:parameters ()
:precondition
(and
(available_cdk2-cyca-e2f13)
)
:effect
(and
(goal7_)
)
)
(:action dummy-action-7-2
:parameters ()
:precondition
(and
(available_p27-cdk2-cycep1)
)
:effect
(and
(goal7_)
)
)
(:action dummy-action-6-1
:parameters ()
:precondition
(and
(available_p27-cdk2-cyca)
)
:effect
(and
(goal6_)
)
)
(:action dummy-action-6-2
:parameters ()
:precondition
(and
(available_p27-cdk2-cyce)
)
:effect
(and
(goal6_)
)
)
(:action dummy-action-5-2
:parameters ()
:precondition
(and
(available_p57-cdk2-cyce)
)
:effect
(and
(goal5_)
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
(:action ASSOCIATE_CDK46_CYCD_CDK46-CYCD
:parameters ()
:precondition
(and
(available_cycd)
(available_cdk46)
)
:effect
(and
(available_cdk46-cycd)
(not (available_cdk46))
(not (available_cycd))
)
)
(:action ASSOCIATE_CDK46_CYCDP1_CDK46-CYCDP1
:parameters ()
:precondition
(and
(available_cycdp1)
(available_cdk46)
)
:effect
(and
(available_cdk46-cycdp1)
(not (available_cdk46))
(not (available_cycdp1))
)
)
(:action ASSOCIATE_P27_CDK2-CYCA_P27-CDK2-CYCA
:parameters ()
:precondition
(and
(available_cdk2-cyca)
(available_p27)
)
:effect
(and
(available_p27-cdk2-cyca)
(not (available_p27))
(not (available_cdk2-cyca))
)
)
(:action ASSOCIATE_P27_CDK2-CYCEP1_P27-CDK2-CYCEP1
:parameters ()
:precondition
(and
(available_cdk2-cycep1)
(available_p27)
)
:effect
(and
(available_p27-cdk2-cycep1)
(not (available_p27))
(not (available_cdk2-cycep1))
)
)
(:action ASSOCIATE_P27_CDK2-CYCE_P27-CDK2-CYCE
:parameters ()
:precondition
(and
(available_cdk2-cyce)
(available_p27)
)
:effect
(and
(available_p27-cdk2-cyce)
(not (available_p27))
(not (available_cdk2-cyce))
)
)
(:action ASSOCIATE_P57_CDK2-CYCA_P57-CDK2-CYCA
:parameters ()
:precondition
(and
(available_cdk2-cyca)
(available_p57)
)
:effect
(and
(available_p57-cdk2-cyca)
(not (available_p57))
(not (available_cdk2-cyca))
)
)
(:action ASSOCIATE_P57_CDK2-CYCEP1_P57-CDK2-CYCEP1
:parameters ()
:precondition
(and
(available_cdk2-cycep1)
(available_p57)
)
:effect
(and
(available_p57-cdk2-cycep1)
(not (available_p57))
(not (available_cdk2-cycep1))
)
)
(:action ASSOCIATE_P57_CDK2-CYCE_P57-CDK2-CYCE
:parameters ()
:precondition
(and
(available_cdk2-cyce)
(available_p57)
)
:effect
(and
(available_p57-cdk2-cyce)
(not (available_p57))
(not (available_cdk2-cyce))
)
)
(:action ASSOCIATE_SKP2_CDK2-CYCA_SKP2-CDK2-CYCA
:parameters ()
:precondition
(and
(available_cdk2-cyca)
(available_skp2)
)
:effect
(and
(available_skp2-cdk2-cyca)
(not (available_skp2))
(not (available_cdk2-cyca))
)
)
(:action ASSOCIATE_SKP2-SKP1_CDK2-CYCA_SKP2-SKP1-CDK2-CYCA
:parameters ()
:precondition
(and
(available_cdk2-cyca)
(available_skp2-skp1)
)
:effect
(and
(available_skp2-skp1-cdk2-cyca)
(not (available_skp2-skp1))
(not (available_cdk2-cyca))
)
)
(:action CHOOSE_APC_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_apc)
)
:effect
(and
(chosen_apc)
(num-subs_l6)
(not (not-chosen_apc))
(not (num-subs_l5))
)
)
(:action CHOOSE_CDK2P1_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_cdk2p1)
)
:effect
(and
(chosen_cdk2p1)
(num-subs_l6)
(not (not-chosen_cdk2p1))
(not (num-subs_l5))
)
)
(:action CHOOSE_CDK46P1_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_cdk46p1)
)
:effect
(and
(chosen_cdk46p1)
(num-subs_l6)
(not (not-chosen_cdk46p1))
(not (num-subs_l5))
)
)
(:action CHOOSE_CDK46P3-CYCD_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_cdk46p3-cycd)
)
:effect
(and
(chosen_cdk46p3-cycd)
(num-subs_l6)
(not (not-chosen_cdk46p3-cycd))
(not (num-subs_l5))
)
)
(:action CHOOSE_DMP1_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_dmp1)
)
:effect
(and
(chosen_dmp1)
(num-subs_l6)
(not (not-chosen_dmp1))
(not (num-subs_l5))
)
)
(:action CHOOSE_DP12_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_dp12)
)
:effect
(and
(chosen_dp12)
(num-subs_l6)
(not (not-chosen_dp12))
(not (num-subs_l5))
)
)
(:action CHOOSE_E2F1_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_e2f1)
)
:effect
(and
(chosen_e2f1)
(num-subs_l6)
(not (not-chosen_e2f1))
(not (num-subs_l5))
)
)
(:action CHOOSE_E2F13_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_e2f13)
)
:effect
(and
(chosen_e2f13)
(num-subs_l6)
(not (not-chosen_e2f13))
(not (num-subs_l5))
)
)
(:action CHOOSE_E2F13-DP12_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_e2f13-dp12)
)
:effect
(and
(chosen_e2f13-dp12)
(num-subs_l6)
(not (not-chosen_e2f13-dp12))
(not (num-subs_l5))
)
)
(:action CHOOSE_E2F13P1-DP12_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_e2f13p1-dp12)
)
:effect
(and
(chosen_e2f13p1-dp12)
(num-subs_l6)
(not (not-chosen_e2f13p1-dp12))
(not (num-subs_l5))
)
)
(:action CHOOSE_E2F3_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_e2f3)
)
:effect
(and
(chosen_e2f3)
(num-subs_l6)
(not (not-chosen_e2f3))
(not (num-subs_l5))
)
)
(:action CHOOSE_E2F4_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_e2f4)
)
:effect
(and
(chosen_e2f4)
(num-subs_l6)
(not (not-chosen_e2f4))
(not (num-subs_l5))
)
)
(:action CHOOSE_E2F4-DP12P1_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_e2f4-dp12p1)
)
:effect
(and
(chosen_e2f4-dp12p1)
(num-subs_l6)
(not (not-chosen_e2f4-dp12p1))
(not (num-subs_l5))
)
)
(:action CHOOSE_E2F5_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_e2f5)
)
:effect
(and
(chosen_e2f5)
(num-subs_l6)
(not (not-chosen_e2f5))
(not (num-subs_l5))
)
)
(:action CHOOSE_E2F6-DP12P1_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_e2f6-dp12p1)
)
:effect
(and
(chosen_e2f6-dp12p1)
(num-subs_l6)
(not (not-chosen_e2f6-dp12p1))
(not (num-subs_l5))
)
)
(:action CHOOSE_GCDC25A_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_gcdc25a)
)
:effect
(and
(chosen_gcdc25a)
(num-subs_l6)
(not (not-chosen_gcdc25a))
(not (num-subs_l5))
)
)
(:action CHOOSE_GE2_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_ge2)
)
:effect
(and
(chosen_ge2)
(num-subs_l6)
(not (not-chosen_ge2))
(not (num-subs_l5))
)
)
(:action CHOOSE_GP19ARF_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_gp19arf)
)
:effect
(and
(chosen_gp19arf)
(num-subs_l6)
(not (not-chosen_gp19arf))
(not (num-subs_l5))
)
)
(:action CHOOSE_HDAC1_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_hdac1)
)
:effect
(and
(chosen_hdac1)
(num-subs_l6)
(not (not-chosen_hdac1))
(not (num-subs_l5))
)
)
(:action CHOOSE_HDAC1-PRBP1-E2F13-DP12_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_hdac1-prbp1-e2f13-dp12)
)
:effect
(and
(chosen_hdac1-prbp1-e2f13-dp12)
(num-subs_l6)
(not (not-chosen_hdac1-prbp1-e2f13-dp12))
(not (num-subs_l5))
)
)
(:action CHOOSE_HDAC1-PRBP1-E2F13P1-DP12_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_hdac1-prbp1-e2f13p1-dp12)
)
:effect
(and
(chosen_hdac1-prbp1-e2f13p1-dp12)
(num-subs_l6)
(not (not-chosen_hdac1-prbp1-e2f13p1-dp12))
(not (num-subs_l5))
)
)
(:action CHOOSE_HDAC1-PRBP1-E2F4-DP12_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_hdac1-prbp1-e2f4-dp12)
)
:effect
(and
(chosen_hdac1-prbp1-e2f4-dp12)
(num-subs_l6)
(not (not-chosen_hdac1-prbp1-e2f4-dp12))
(not (num-subs_l5))
)
)
(:action CHOOSE_JUN_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_jun)
)
:effect
(and
(chosen_jun)
(num-subs_l6)
(not (not-chosen_jun))
(not (num-subs_l5))
)
)
(:action CHOOSE_MAX_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_max)
)
:effect
(and
(chosen_max)
(num-subs_l6)
(not (not-chosen_max))
(not (num-subs_l5))
)
)
(:action CHOOSE_P130_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_p130)
)
:effect
(and
(chosen_p130)
(num-subs_l6)
(not (not-chosen_p130))
(not (num-subs_l5))
)
)
(:action CHOOSE_P130-E2F4P1-DP12_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_p130-e2f4p1-dp12)
)
:effect
(and
(chosen_p130-e2f4p1-dp12)
(num-subs_l6)
(not (not-chosen_p130-e2f4p1-dp12))
(not (num-subs_l5))
)
)
(:action CHOOSE_P130-E2F5P1-DP12_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_p130-e2f5p1-dp12)
)
:effect
(and
(chosen_p130-e2f5p1-dp12)
(num-subs_l6)
(not (not-chosen_p130-e2f5p1-dp12))
(not (num-subs_l5))
)
)
(:action CHOOSE_P27_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_p27)
)
:effect
(and
(chosen_p27)
(num-subs_l6)
(not (not-chosen_p27))
(not (num-subs_l5))
)
)
(:action CHOOSE_P57_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_p57)
)
:effect
(and
(chosen_p57)
(num-subs_l6)
(not (not-chosen_p57))
(not (num-subs_l5))
)
)
(:action CHOOSE_P57P1_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_p57p1)
)
:effect
(and
(chosen_p57p1)
(num-subs_l6)
(not (not-chosen_p57p1))
(not (num-subs_l5))
)
)
(:action CHOOSE_PLK1_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_plk1)
)
:effect
(and
(chosen_plk1)
(num-subs_l6)
(not (not-chosen_plk1))
(not (num-subs_l5))
)
)
(:action CHOOSE_PRB-E2F4P1-DP12_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_prb-e2f4p1-dp12)
)
:effect
(and
(chosen_prb-e2f4p1-dp12)
(num-subs_l6)
(not (not-chosen_prb-e2f4p1-dp12))
(not (num-subs_l5))
)
)
(:action CHOOSE_PRBP1-E2F4P1-DP12_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_prbp1-e2f4p1-dp12)
)
:effect
(and
(chosen_prbp1-e2f4p1-dp12)
(num-subs_l6)
(not (not-chosen_prbp1-e2f4p1-dp12))
(not (num-subs_l5))
)
)
(:action CHOOSE_PRBP2_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_prbp2)
)
:effect
(and
(chosen_prbp2)
(num-subs_l6)
(not (not-chosen_prbp2))
(not (num-subs_l5))
)
)
(:action CHOOSE_RAF1_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_raf1)
)
:effect
(and
(chosen_raf1)
(num-subs_l6)
(not (not-chosen_raf1))
(not (num-subs_l5))
)
)
(:action CHOOSE_RPA_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_rpa)
)
:effect
(and
(chosen_rpa)
(num-subs_l6)
(not (not-chosen_rpa))
(not (num-subs_l5))
)
)
(:action CHOOSE_SKP1_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_skp1)
)
:effect
(and
(chosen_skp1)
(num-subs_l6)
(not (not-chosen_skp1))
(not (num-subs_l5))
)
)
(:action CHOOSE_SKP2_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_skp2)
)
:effect
(and
(chosen_skp2)
(num-subs_l6)
(not (not-chosen_skp2))
(not (num-subs_l5))
)
)
(:action CHOOSE_SP1_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_sp1)
)
:effect
(and
(chosen_sp1)
(num-subs_l6)
(not (not-chosen_sp1))
(not (num-subs_l5))
)
)
(:action dummy-action-11-1
:parameters ()
:precondition
(and
(available_cdk2-cyca)
)
:effect
(and
(goal11_)
)
)
(:action dummy-action-10-1
:parameters ()
:precondition
(and
(available_raf1-cdc25ap1)
)
:effect
(and
(goal10_)
)
)
(:action dummy-action-10-2
:parameters ()
:precondition
(and
(available_cdk2-cyce)
)
:effect
(and
(goal10_)
)
)
(:action dummy-action-9-1
:parameters ()
:precondition
(and
(available_cdk46)
)
:effect
(and
(goal9_)
)
)
(:action dummy-action-9-2
:parameters ()
:precondition
(and
(available_cdk2-cycep1)
)
:effect
(and
(goal9_)
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDK2P1-CYCA_CDC25AP1_CDK2-CYCA
:parameters ()
:precondition
(and
(available_cdc25ap1)
(available_cdk2p1-cyca)
)
:effect
(and
(available_cdk2-cyca)
(not (available_cdk2p1-cyca))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDK2P1-CYCE_CDC25AP1_CDK2-CYCE
:parameters ()
:precondition
(and
(available_cdc25ap1)
(available_cdk2p1-cyce)
)
:effect
(and
(available_cdk2-cyce)
(not (available_cdk2p1-cyce))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDK2P1-CYCEP1_CDC25AP1_CDK2-CYCEP1
:parameters ()
:precondition
(and
(available_cdc25ap1)
(available_cdk2p1-cycep1)
)
:effect
(and
(available_cdk2-cycep1)
(not (available_cdk2p1-cycep1))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDK46P1_CDC25AP1_CDK46
:parameters ()
:precondition
(and
(available_cdc25ap1)
(available_cdk46p1)
)
:effect
(and
(available_cdk46)
(not (available_cdk46p1))
)
)
(:action ASSOCIATE_RAF1_CDC25AP1_RAF1-CDC25AP1
:parameters ()
:precondition
(and
(available_cdc25ap1)
(available_raf1)
)
:effect
(and
(available_raf1-cdc25ap1)
(not (available_raf1))
(not (available_cdc25ap1))
)
)
(:action CHOOSE_APC_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_apc)
)
:effect
(and
(chosen_apc)
(num-subs_l5)
(not (not-chosen_apc))
(not (num-subs_l4))
)
)
(:action CHOOSE_CDK2P1_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_cdk2p1)
)
:effect
(and
(chosen_cdk2p1)
(num-subs_l5)
(not (not-chosen_cdk2p1))
(not (num-subs_l4))
)
)
(:action CHOOSE_CDK46P1_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_cdk46p1)
)
:effect
(and
(chosen_cdk46p1)
(num-subs_l5)
(not (not-chosen_cdk46p1))
(not (num-subs_l4))
)
)
(:action CHOOSE_CDK46P3-CYCD_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_cdk46p3-cycd)
)
:effect
(and
(chosen_cdk46p3-cycd)
(num-subs_l5)
(not (not-chosen_cdk46p3-cycd))
(not (num-subs_l4))
)
)
(:action CHOOSE_DMP1_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_dmp1)
)
:effect
(and
(chosen_dmp1)
(num-subs_l5)
(not (not-chosen_dmp1))
(not (num-subs_l4))
)
)
(:action CHOOSE_DP12_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_dp12)
)
:effect
(and
(chosen_dp12)
(num-subs_l5)
(not (not-chosen_dp12))
(not (num-subs_l4))
)
)
(:action CHOOSE_E2F1_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_e2f1)
)
:effect
(and
(chosen_e2f1)
(num-subs_l5)
(not (not-chosen_e2f1))
(not (num-subs_l4))
)
)
(:action CHOOSE_E2F13_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_e2f13)
)
:effect
(and
(chosen_e2f13)
(num-subs_l5)
(not (not-chosen_e2f13))
(not (num-subs_l4))
)
)
(:action CHOOSE_E2F13-DP12_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_e2f13-dp12)
)
:effect
(and
(chosen_e2f13-dp12)
(num-subs_l5)
(not (not-chosen_e2f13-dp12))
(not (num-subs_l4))
)
)
(:action CHOOSE_E2F13P1-DP12_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_e2f13p1-dp12)
)
:effect
(and
(chosen_e2f13p1-dp12)
(num-subs_l5)
(not (not-chosen_e2f13p1-dp12))
(not (num-subs_l4))
)
)
(:action CHOOSE_E2F3_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_e2f3)
)
:effect
(and
(chosen_e2f3)
(num-subs_l5)
(not (not-chosen_e2f3))
(not (num-subs_l4))
)
)
(:action CHOOSE_E2F4_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_e2f4)
)
:effect
(and
(chosen_e2f4)
(num-subs_l5)
(not (not-chosen_e2f4))
(not (num-subs_l4))
)
)
(:action CHOOSE_E2F4-DP12P1_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_e2f4-dp12p1)
)
:effect
(and
(chosen_e2f4-dp12p1)
(num-subs_l5)
(not (not-chosen_e2f4-dp12p1))
(not (num-subs_l4))
)
)
(:action CHOOSE_E2F5_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_e2f5)
)
:effect
(and
(chosen_e2f5)
(num-subs_l5)
(not (not-chosen_e2f5))
(not (num-subs_l4))
)
)
(:action CHOOSE_E2F6-DP12P1_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_e2f6-dp12p1)
)
:effect
(and
(chosen_e2f6-dp12p1)
(num-subs_l5)
(not (not-chosen_e2f6-dp12p1))
(not (num-subs_l4))
)
)
(:action CHOOSE_GCDC25A_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_gcdc25a)
)
:effect
(and
(chosen_gcdc25a)
(num-subs_l5)
(not (not-chosen_gcdc25a))
(not (num-subs_l4))
)
)
(:action CHOOSE_GE2_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_ge2)
)
:effect
(and
(chosen_ge2)
(num-subs_l5)
(not (not-chosen_ge2))
(not (num-subs_l4))
)
)
(:action CHOOSE_GP19ARF_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_gp19arf)
)
:effect
(and
(chosen_gp19arf)
(num-subs_l5)
(not (not-chosen_gp19arf))
(not (num-subs_l4))
)
)
(:action CHOOSE_HDAC1_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_hdac1)
)
:effect
(and
(chosen_hdac1)
(num-subs_l5)
(not (not-chosen_hdac1))
(not (num-subs_l4))
)
)
(:action CHOOSE_HDAC1-PRBP1-E2F13-DP12_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_hdac1-prbp1-e2f13-dp12)
)
:effect
(and
(chosen_hdac1-prbp1-e2f13-dp12)
(num-subs_l5)
(not (not-chosen_hdac1-prbp1-e2f13-dp12))
(not (num-subs_l4))
)
)
(:action CHOOSE_HDAC1-PRBP1-E2F13P1-DP12_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_hdac1-prbp1-e2f13p1-dp12)
)
:effect
(and
(chosen_hdac1-prbp1-e2f13p1-dp12)
(num-subs_l5)
(not (not-chosen_hdac1-prbp1-e2f13p1-dp12))
(not (num-subs_l4))
)
)
(:action CHOOSE_HDAC1-PRBP1-E2F4-DP12_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_hdac1-prbp1-e2f4-dp12)
)
:effect
(and
(chosen_hdac1-prbp1-e2f4-dp12)
(num-subs_l5)
(not (not-chosen_hdac1-prbp1-e2f4-dp12))
(not (num-subs_l4))
)
)
(:action CHOOSE_JUN_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_jun)
)
:effect
(and
(chosen_jun)
(num-subs_l5)
(not (not-chosen_jun))
(not (num-subs_l4))
)
)
(:action CHOOSE_MAX_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_max)
)
:effect
(and
(chosen_max)
(num-subs_l5)
(not (not-chosen_max))
(not (num-subs_l4))
)
)
(:action CHOOSE_P130_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_p130)
)
:effect
(and
(chosen_p130)
(num-subs_l5)
(not (not-chosen_p130))
(not (num-subs_l4))
)
)
(:action CHOOSE_P130-E2F4P1-DP12_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_p130-e2f4p1-dp12)
)
:effect
(and
(chosen_p130-e2f4p1-dp12)
(num-subs_l5)
(not (not-chosen_p130-e2f4p1-dp12))
(not (num-subs_l4))
)
)
(:action CHOOSE_P130-E2F5P1-DP12_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_p130-e2f5p1-dp12)
)
:effect
(and
(chosen_p130-e2f5p1-dp12)
(num-subs_l5)
(not (not-chosen_p130-e2f5p1-dp12))
(not (num-subs_l4))
)
)
(:action CHOOSE_P27_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_p27)
)
:effect
(and
(chosen_p27)
(num-subs_l5)
(not (not-chosen_p27))
(not (num-subs_l4))
)
)
(:action CHOOSE_P57_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_p57)
)
:effect
(and
(chosen_p57)
(num-subs_l5)
(not (not-chosen_p57))
(not (num-subs_l4))
)
)
(:action CHOOSE_P57P1_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_p57p1)
)
:effect
(and
(chosen_p57p1)
(num-subs_l5)
(not (not-chosen_p57p1))
(not (num-subs_l4))
)
)
(:action CHOOSE_PLK1_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_plk1)
)
:effect
(and
(chosen_plk1)
(num-subs_l5)
(not (not-chosen_plk1))
(not (num-subs_l4))
)
)
(:action CHOOSE_PRB-E2F4P1-DP12_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_prb-e2f4p1-dp12)
)
:effect
(and
(chosen_prb-e2f4p1-dp12)
(num-subs_l5)
(not (not-chosen_prb-e2f4p1-dp12))
(not (num-subs_l4))
)
)
(:action CHOOSE_PRBP1-E2F4P1-DP12_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_prbp1-e2f4p1-dp12)
)
:effect
(and
(chosen_prbp1-e2f4p1-dp12)
(num-subs_l5)
(not (not-chosen_prbp1-e2f4p1-dp12))
(not (num-subs_l4))
)
)
(:action CHOOSE_PRBP2_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_prbp2)
)
:effect
(and
(chosen_prbp2)
(num-subs_l5)
(not (not-chosen_prbp2))
(not (num-subs_l4))
)
)
(:action CHOOSE_RAF1_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_raf1)
)
:effect
(and
(chosen_raf1)
(num-subs_l5)
(not (not-chosen_raf1))
(not (num-subs_l4))
)
)
(:action CHOOSE_RPA_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_rpa)
)
:effect
(and
(chosen_rpa)
(num-subs_l5)
(not (not-chosen_rpa))
(not (num-subs_l4))
)
)
(:action CHOOSE_SKP1_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_skp1)
)
:effect
(and
(chosen_skp1)
(num-subs_l5)
(not (not-chosen_skp1))
(not (num-subs_l4))
)
)
(:action CHOOSE_SKP2_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_skp2)
)
:effect
(and
(chosen_skp2)
(num-subs_l5)
(not (not-chosen_skp2))
(not (num-subs_l4))
)
)
(:action CHOOSE_SP1_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_sp1)
)
:effect
(and
(chosen_sp1)
(num-subs_l5)
(not (not-chosen_sp1))
(not (num-subs_l4))
)
)
(:action dummy-action-13-2
:parameters ()
:precondition
(and
(available_cdc25ap1)
)
:effect
(and
(goal13_)
)
)
(:action dummy-action-12-2
:parameters ()
:precondition
(and
(available_raf1-cdc25a)
)
:effect
(and
(goal12_)
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDC25A_RAF1_CDC25AP1
:parameters ()
:precondition
(and
(available_raf1)
(available_cdc25a)
)
:effect
(and
(available_cdc25ap1)
(not (available_cdc25a))
)
)
(:action ASSOCIATE_RAF1_CDC25A_RAF1-CDC25A
:parameters ()
:precondition
(and
(available_cdc25a)
(available_raf1)
)
:effect
(and
(available_raf1-cdc25a)
(not (available_raf1))
(not (available_cdc25a))
)
)
(:action CHOOSE_APC_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_apc)
)
:effect
(and
(chosen_apc)
(num-subs_l4)
(not (not-chosen_apc))
(not (num-subs_l3))
)
)
(:action CHOOSE_CDK2P1_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_cdk2p1)
)
:effect
(and
(chosen_cdk2p1)
(num-subs_l4)
(not (not-chosen_cdk2p1))
(not (num-subs_l3))
)
)
(:action CHOOSE_CDK46P1_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_cdk46p1)
)
:effect
(and
(chosen_cdk46p1)
(num-subs_l4)
(not (not-chosen_cdk46p1))
(not (num-subs_l3))
)
)
(:action CHOOSE_CDK46P3-CYCD_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_cdk46p3-cycd)
)
:effect
(and
(chosen_cdk46p3-cycd)
(num-subs_l4)
(not (not-chosen_cdk46p3-cycd))
(not (num-subs_l3))
)
)
(:action CHOOSE_DMP1_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_dmp1)
)
:effect
(and
(chosen_dmp1)
(num-subs_l4)
(not (not-chosen_dmp1))
(not (num-subs_l3))
)
)
(:action CHOOSE_DP12_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_dp12)
)
:effect
(and
(chosen_dp12)
(num-subs_l4)
(not (not-chosen_dp12))
(not (num-subs_l3))
)
)
(:action CHOOSE_E2F1_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_e2f1)
)
:effect
(and
(chosen_e2f1)
(num-subs_l4)
(not (not-chosen_e2f1))
(not (num-subs_l3))
)
)
(:action CHOOSE_E2F13_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_e2f13)
)
:effect
(and
(chosen_e2f13)
(num-subs_l4)
(not (not-chosen_e2f13))
(not (num-subs_l3))
)
)
(:action CHOOSE_E2F13-DP12_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_e2f13-dp12)
)
:effect
(and
(chosen_e2f13-dp12)
(num-subs_l4)
(not (not-chosen_e2f13-dp12))
(not (num-subs_l3))
)
)
(:action CHOOSE_E2F13P1-DP12_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_e2f13p1-dp12)
)
:effect
(and
(chosen_e2f13p1-dp12)
(num-subs_l4)
(not (not-chosen_e2f13p1-dp12))
(not (num-subs_l3))
)
)
(:action CHOOSE_E2F3_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_e2f3)
)
:effect
(and
(chosen_e2f3)
(num-subs_l4)
(not (not-chosen_e2f3))
(not (num-subs_l3))
)
)
(:action CHOOSE_E2F4_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_e2f4)
)
:effect
(and
(chosen_e2f4)
(num-subs_l4)
(not (not-chosen_e2f4))
(not (num-subs_l3))
)
)
(:action CHOOSE_E2F4-DP12P1_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_e2f4-dp12p1)
)
:effect
(and
(chosen_e2f4-dp12p1)
(num-subs_l4)
(not (not-chosen_e2f4-dp12p1))
(not (num-subs_l3))
)
)
(:action CHOOSE_E2F5_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_e2f5)
)
:effect
(and
(chosen_e2f5)
(num-subs_l4)
(not (not-chosen_e2f5))
(not (num-subs_l3))
)
)
(:action CHOOSE_E2F6-DP12P1_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_e2f6-dp12p1)
)
:effect
(and
(chosen_e2f6-dp12p1)
(num-subs_l4)
(not (not-chosen_e2f6-dp12p1))
(not (num-subs_l3))
)
)
(:action CHOOSE_GCDC25A_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_gcdc25a)
)
:effect
(and
(chosen_gcdc25a)
(num-subs_l4)
(not (not-chosen_gcdc25a))
(not (num-subs_l3))
)
)
(:action CHOOSE_GE2_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_ge2)
)
:effect
(and
(chosen_ge2)
(num-subs_l4)
(not (not-chosen_ge2))
(not (num-subs_l3))
)
)
(:action CHOOSE_GP19ARF_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_gp19arf)
)
:effect
(and
(chosen_gp19arf)
(num-subs_l4)
(not (not-chosen_gp19arf))
(not (num-subs_l3))
)
)
(:action CHOOSE_HDAC1_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_hdac1)
)
:effect
(and
(chosen_hdac1)
(num-subs_l4)
(not (not-chosen_hdac1))
(not (num-subs_l3))
)
)
(:action CHOOSE_HDAC1-PRBP1-E2F13-DP12_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_hdac1-prbp1-e2f13-dp12)
)
:effect
(and
(chosen_hdac1-prbp1-e2f13-dp12)
(num-subs_l4)
(not (not-chosen_hdac1-prbp1-e2f13-dp12))
(not (num-subs_l3))
)
)
(:action CHOOSE_HDAC1-PRBP1-E2F13P1-DP12_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_hdac1-prbp1-e2f13p1-dp12)
)
:effect
(and
(chosen_hdac1-prbp1-e2f13p1-dp12)
(num-subs_l4)
(not (not-chosen_hdac1-prbp1-e2f13p1-dp12))
(not (num-subs_l3))
)
)
(:action CHOOSE_HDAC1-PRBP1-E2F4-DP12_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_hdac1-prbp1-e2f4-dp12)
)
:effect
(and
(chosen_hdac1-prbp1-e2f4-dp12)
(num-subs_l4)
(not (not-chosen_hdac1-prbp1-e2f4-dp12))
(not (num-subs_l3))
)
)
(:action CHOOSE_JUN_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_jun)
)
:effect
(and
(chosen_jun)
(num-subs_l4)
(not (not-chosen_jun))
(not (num-subs_l3))
)
)
(:action CHOOSE_MAX_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_max)
)
:effect
(and
(chosen_max)
(num-subs_l4)
(not (not-chosen_max))
(not (num-subs_l3))
)
)
(:action CHOOSE_P130_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_p130)
)
:effect
(and
(chosen_p130)
(num-subs_l4)
(not (not-chosen_p130))
(not (num-subs_l3))
)
)
(:action CHOOSE_P130-E2F4P1-DP12_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_p130-e2f4p1-dp12)
)
:effect
(and
(chosen_p130-e2f4p1-dp12)
(num-subs_l4)
(not (not-chosen_p130-e2f4p1-dp12))
(not (num-subs_l3))
)
)
(:action CHOOSE_P130-E2F5P1-DP12_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_p130-e2f5p1-dp12)
)
:effect
(and
(chosen_p130-e2f5p1-dp12)
(num-subs_l4)
(not (not-chosen_p130-e2f5p1-dp12))
(not (num-subs_l3))
)
)
(:action CHOOSE_P27_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_p27)
)
:effect
(and
(chosen_p27)
(num-subs_l4)
(not (not-chosen_p27))
(not (num-subs_l3))
)
)
(:action CHOOSE_P57_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_p57)
)
:effect
(and
(chosen_p57)
(num-subs_l4)
(not (not-chosen_p57))
(not (num-subs_l3))
)
)
(:action CHOOSE_P57P1_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_p57p1)
)
:effect
(and
(chosen_p57p1)
(num-subs_l4)
(not (not-chosen_p57p1))
(not (num-subs_l3))
)
)
(:action CHOOSE_PLK1_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_plk1)
)
:effect
(and
(chosen_plk1)
(num-subs_l4)
(not (not-chosen_plk1))
(not (num-subs_l3))
)
)
(:action CHOOSE_PRB-E2F4P1-DP12_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_prb-e2f4p1-dp12)
)
:effect
(and
(chosen_prb-e2f4p1-dp12)
(num-subs_l4)
(not (not-chosen_prb-e2f4p1-dp12))
(not (num-subs_l3))
)
)
(:action CHOOSE_PRBP1-E2F4P1-DP12_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_prbp1-e2f4p1-dp12)
)
:effect
(and
(chosen_prbp1-e2f4p1-dp12)
(num-subs_l4)
(not (not-chosen_prbp1-e2f4p1-dp12))
(not (num-subs_l3))
)
)
(:action CHOOSE_PRBP2_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_prbp2)
)
:effect
(and
(chosen_prbp2)
(num-subs_l4)
(not (not-chosen_prbp2))
(not (num-subs_l3))
)
)
(:action CHOOSE_RAF1_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_raf1)
)
:effect
(and
(chosen_raf1)
(num-subs_l4)
(not (not-chosen_raf1))
(not (num-subs_l3))
)
)
(:action CHOOSE_RPA_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_rpa)
)
:effect
(and
(chosen_rpa)
(num-subs_l4)
(not (not-chosen_rpa))
(not (num-subs_l3))
)
)
(:action CHOOSE_SKP1_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_skp1)
)
:effect
(and
(chosen_skp1)
(num-subs_l4)
(not (not-chosen_skp1))
(not (num-subs_l3))
)
)
(:action CHOOSE_SKP2_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_skp2)
)
:effect
(and
(chosen_skp2)
(num-subs_l4)
(not (not-chosen_skp2))
(not (num-subs_l3))
)
)
(:action CHOOSE_SP1_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_sp1)
)
:effect
(and
(chosen_sp1)
(num-subs_l4)
(not (not-chosen_sp1))
(not (num-subs_l3))
)
)
(:action dummy-action-14-2
:parameters ()
:precondition
(and
(available_cdk2p1-cyca-e2f13)
)
:effect
(and
(goal14_)
)
)
(:action SYNTHESIZE_C-MYC-MAX-GCDC25A_CDC25A
:parameters ()
:precondition
(and
(available_c-myc-max-gcdc25a)
)
:effect
(and
(available_cdc25a)
)
)
(:action SYNTHESIZE_RAF1-P130-E2F4-DP12-GE2_C-MYC
:parameters ()
:precondition
(and
(available_raf1-p130-e2f4-dp12-ge2)
)
:effect
(and
(available_c-myc)
)
)
(:action SYNTHESIZE_RAF1-P130-E2F4-DP12-GE2_CYCA
:parameters ()
:precondition
(and
(available_raf1-p130-e2f4-dp12-ge2)
)
:effect
(and
(available_cyca)
)
)
(:action SYNTHESIZE_RAF1-P130-E2F4-DP12-GE2_CYCD
:parameters ()
:precondition
(and
(available_raf1-p130-e2f4-dp12-ge2)
)
:effect
(and
(available_cycd)
)
)
(:action SYNTHESIZE_RAF1-P130-E2F4-DP12-GE2_CYCDP1
:parameters ()
:precondition
(and
(available_raf1-p130-e2f4-dp12-ge2)
)
:effect
(and
(available_cycdp1)
)
)
(:action SYNTHESIZE_RAF1-P130-E2F4-DP12-GE2_CYCE
:parameters ()
:precondition
(and
(available_raf1-p130-e2f4-dp12-ge2)
)
:effect
(and
(available_cyce)
)
)
(:action SYNTHESIZE_RAF1-P130-E2F4-DP12-GE2_CYCEP1
:parameters ()
:precondition
(and
(available_raf1-p130-e2f4-dp12-ge2)
)
:effect
(and
(available_cycep1)
)
)
(:action SYNTHESIZE_RAF1-P130-E2F4-DP12-GE2_P107
:parameters ()
:precondition
(and
(available_raf1-p130-e2f4-dp12-ge2)
)
:effect
(and
(available_p107)
)
)
(:action SYNTHESIZE_RAF1-P130-E2F4-DP12-GE2_P107P1
:parameters ()
:precondition
(and
(available_raf1-p130-e2f4-dp12-ge2)
)
:effect
(and
(available_p107p1)
)
)
(:action SYNTHESIZE_RAF1-P130-E2F4-DP12-GE2_P19ARF
:parameters ()
:precondition
(and
(available_raf1-p130-e2f4-dp12-ge2)
)
:effect
(and
(available_p19arf)
)
)
(:action SYNTHESIZE_RAF1-P130-E2F4-DP12-GE2_POL
:parameters ()
:precondition
(and
(available_raf1-p130-e2f4-dp12-ge2)
)
:effect
(and
(available_pol)
)
)
(:action SYNTHESIZE_RAF1-P130-E2F5-DP12-GE2_C-MYC
:parameters ()
:precondition
(and
(available_raf1-p130-e2f5-dp12-ge2)
)
:effect
(and
(available_c-myc)
)
)
(:action SYNTHESIZE_RAF1-P130-E2F5-DP12-GE2_CYCA
:parameters ()
:precondition
(and
(available_raf1-p130-e2f5-dp12-ge2)
)
:effect
(and
(available_cyca)
)
)
(:action SYNTHESIZE_RAF1-P130-E2F5-DP12-GE2_CYCD
:parameters ()
:precondition
(and
(available_raf1-p130-e2f5-dp12-ge2)
)
:effect
(and
(available_cycd)
)
)
(:action SYNTHESIZE_RAF1-P130-E2F5-DP12-GE2_CYCDP1
:parameters ()
:precondition
(and
(available_raf1-p130-e2f5-dp12-ge2)
)
:effect
(and
(available_cycdp1)
)
)
(:action SYNTHESIZE_RAF1-P130-E2F5-DP12-GE2_CYCE
:parameters ()
:precondition
(and
(available_raf1-p130-e2f5-dp12-ge2)
)
:effect
(and
(available_cyce)
)
)
(:action SYNTHESIZE_RAF1-P130-E2F5-DP12-GE2_CYCEP1
:parameters ()
:precondition
(and
(available_raf1-p130-e2f5-dp12-ge2)
)
:effect
(and
(available_cycep1)
)
)
(:action SYNTHESIZE_RAF1-P130-E2F5-DP12-GE2_P107
:parameters ()
:precondition
(and
(available_raf1-p130-e2f5-dp12-ge2)
)
:effect
(and
(available_p107)
)
)
(:action SYNTHESIZE_RAF1-P130-E2F5-DP12-GE2_P107P1
:parameters ()
:precondition
(and
(available_raf1-p130-e2f5-dp12-ge2)
)
:effect
(and
(available_p107p1)
)
)
(:action SYNTHESIZE_RAF1-P130-E2F5-DP12-GE2_P19ARF
:parameters ()
:precondition
(and
(available_raf1-p130-e2f5-dp12-ge2)
)
:effect
(and
(available_p19arf)
)
)
(:action SYNTHESIZE_RAF1-P130-E2F5-DP12-GE2_POL
:parameters ()
:precondition
(and
(available_raf1-p130-e2f5-dp12-ge2)
)
:effect
(and
(available_pol)
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
(:action ASSOCIATE_C-MYC-MAX_GCDC25A_C-MYC-MAX-GCDC25A
:parameters ()
:precondition
(and
(available_gcdc25a)
(available_c-myc-max)
)
:effect
(and
(available_c-myc-max-gcdc25a)
(not (available_c-myc-max))
(not (available_gcdc25a))
)
)
(:action ASSOCIATE_P27_CDK2P1-CYCA_P27-CDK2P1-CYCA
:parameters ()
:precondition
(and
(available_cdk2p1-cyca)
(available_p27)
)
:effect
(and
(available_p27-cdk2p1-cyca)
(not (available_p27))
(not (available_cdk2p1-cyca))
)
)
(:action ASSOCIATE_P27_CDK2P1-CYCEP1_P27-CDK2P1-CYCEP1
:parameters ()
:precondition
(and
(available_cdk2p1-cycep1)
(available_p27)
)
:effect
(and
(available_p27-cdk2p1-cycep1)
(not (available_p27))
(not (available_cdk2p1-cycep1))
)
)
(:action ASSOCIATE_P27_CDK2P1-CYCE_P27-CDK2P1-CYCE
:parameters ()
:precondition
(and
(available_cdk2p1-cyce)
(available_p27)
)
:effect
(and
(available_p27-cdk2p1-cyce)
(not (available_p27))
(not (available_cdk2p1-cyce))
)
)
(:action ASSOCIATE_P27_CDK46P1-CYCDP1_P27-CDK46P1-CYCDP1
:parameters ()
:precondition
(and
(available_cdk46p1-cycdp1)
(available_p27)
)
:effect
(and
(available_p27-cdk46p1-cycdp1)
(not (available_p27))
(not (available_cdk46p1-cycdp1))
)
)
(:action ASSOCIATE_P27_CDK46P1-CYCD_P27-CDK46P1-CYCD
:parameters ()
:precondition
(and
(available_cdk46p1-cycd)
(available_p27)
)
:effect
(and
(available_p27-cdk46p1-cycd)
(not (available_p27))
(not (available_cdk46p1-cycd))
)
)
(:action ASSOCIATE_P57_CDK2P1-CYCA_P57-CDK2P1-CYCA
:parameters ()
:precondition
(and
(available_cdk2p1-cyca)
(available_p57)
)
:effect
(and
(available_p57-cdk2p1-cyca)
(not (available_p57))
(not (available_cdk2p1-cyca))
)
)
(:action ASSOCIATE_P57_CDK2P1-CYCEP1_P57-CDK2P1-CYCEP1
:parameters ()
:precondition
(and
(available_cdk2p1-cycep1)
(available_p57)
)
:effect
(and
(available_p57-cdk2p1-cycep1)
(not (available_p57))
(not (available_cdk2p1-cycep1))
)
)
(:action ASSOCIATE_P57_CDK2P1-CYCE_P57-CDK2P1-CYCE
:parameters ()
:precondition
(and
(available_cdk2p1-cyce)
(available_p57)
)
:effect
(and
(available_p57-cdk2p1-cyce)
(not (available_p57))
(not (available_cdk2p1-cyce))
)
)
(:action ASSOCIATE_P57_CDK46P1-CYCDP1_P57-CDK46P1-CYCDP1
:parameters ()
:precondition
(and
(available_cdk46p1-cycdp1)
(available_p57)
)
:effect
(and
(available_p57-cdk46p1-cycdp1)
(not (available_p57))
(not (available_cdk46p1-cycdp1))
)
)
(:action ASSOCIATE_P57_CDK46P1-CYCD_P57-CDK46P1-CYCD
:parameters ()
:precondition
(and
(available_cdk46p1-cycd)
(available_p57)
)
:effect
(and
(available_p57-cdk46p1-cycd)
(not (available_p57))
(not (available_cdk46p1-cycd))
)
)
(:action ASSOCIATE_P57P1_CDK46P1-CYCDP1_P57P1-CDK46P1-CYCDP1
:parameters ()
:precondition
(and
(available_cdk46p1-cycdp1)
(available_p57p1)
)
:effect
(and
(available_p57p1-cdk46p1-cycdp1)
(not (available_p57p1))
(not (available_cdk46p1-cycdp1))
)
)
(:action ASSOCIATE_P57P1_CDK46P1-CYCD_P57P1-CDK46P1-CYCD
:parameters ()
:precondition
(and
(available_cdk46p1-cycd)
(available_p57p1)
)
:effect
(and
(available_p57p1-cdk46p1-cycd)
(not (available_p57p1))
(not (available_cdk46p1-cycd))
)
)
(:action ASSOCIATE_RAF1-P130-E2F4-DP12_GE2_RAF1-P130-E2F4-DP12-GE2
:parameters ()
:precondition
(and
(available_ge2)
(available_raf1-p130-e2f4-dp12)
)
:effect
(and
(available_raf1-p130-e2f4-dp12-ge2)
(not (available_raf1-p130-e2f4-dp12))
(not (available_ge2))
)
)
(:action ASSOCIATE_RAF1_P130-E2F4-DP12_RAF1-P130-E2F4-DP12
:parameters ()
:precondition
(and
(available_p130-e2f4-dp12)
(available_raf1)
)
:effect
(and
(available_raf1-p130-e2f4-dp12)
(not (available_raf1))
(not (available_p130-e2f4-dp12))
)
)
(:action ASSOCIATE_RAF1-P130-E2F5-DP12_GE2_RAF1-P130-E2F5-DP12-GE2
:parameters ()
:precondition
(and
(available_ge2)
(available_raf1-p130-e2f5-dp12)
)
:effect
(and
(available_raf1-p130-e2f5-dp12-ge2)
(not (available_raf1-p130-e2f5-dp12))
(not (available_ge2))
)
)
(:action ASSOCIATE_RAF1_P130-E2F5-DP12_RAF1-P130-E2F5-DP12
:parameters ()
:precondition
(and
(available_p130-e2f5-dp12)
(available_raf1)
)
:effect
(and
(available_raf1-p130-e2f5-dp12)
(not (available_raf1))
(not (available_p130-e2f5-dp12))
)
)
(:action ASSOCIATE_SKP2_CDK2P1-CYCA_SKP2-CDK2P1-CYCA
:parameters ()
:precondition
(and
(available_cdk2p1-cyca)
(available_skp2)
)
:effect
(and
(available_skp2-cdk2p1-cyca)
(not (available_skp2))
(not (available_cdk2p1-cyca))
)
)
(:action ASSOCIATE_SKP2-SKP1_CDK2P1-CYCA_SKP2-SKP1-CDK2P1-CYCA
:parameters ()
:precondition
(and
(available_cdk2p1-cyca)
(available_skp2-skp1)
)
:effect
(and
(available_skp2-skp1-cdk2p1-cyca)
(not (available_skp2-skp1))
(not (available_cdk2p1-cyca))
)
)
(:action CHOOSE_APC_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_apc)
)
:effect
(and
(chosen_apc)
(num-subs_l3)
(not (not-chosen_apc))
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
(:action CHOOSE_DP12_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_dp12)
)
:effect
(and
(chosen_dp12)
(num-subs_l3)
(not (not-chosen_dp12))
(not (num-subs_l2))
)
)
(:action CHOOSE_E2F1_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_e2f1)
)
:effect
(and
(chosen_e2f1)
(num-subs_l3)
(not (not-chosen_e2f1))
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
(:action CHOOSE_E2F13-DP12_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_e2f13-dp12)
)
:effect
(and
(chosen_e2f13-dp12)
(num-subs_l3)
(not (not-chosen_e2f13-dp12))
(not (num-subs_l2))
)
)
(:action CHOOSE_E2F13P1-DP12_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_e2f13p1-dp12)
)
:effect
(and
(chosen_e2f13p1-dp12)
(num-subs_l3)
(not (not-chosen_e2f13p1-dp12))
(not (num-subs_l2))
)
)
(:action CHOOSE_E2F3_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_e2f3)
)
:effect
(and
(chosen_e2f3)
(num-subs_l3)
(not (not-chosen_e2f3))
(not (num-subs_l2))
)
)
(:action CHOOSE_E2F4_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_e2f4)
)
:effect
(and
(chosen_e2f4)
(num-subs_l3)
(not (not-chosen_e2f4))
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
(:action CHOOSE_E2F5_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_e2f5)
)
:effect
(and
(chosen_e2f5)
(num-subs_l3)
(not (not-chosen_e2f5))
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
(:action CHOOSE_GCDC25A_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_gcdc25a)
)
:effect
(and
(chosen_gcdc25a)
(num-subs_l3)
(not (not-chosen_gcdc25a))
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
(:action CHOOSE_GP19ARF_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_gp19arf)
)
:effect
(and
(chosen_gp19arf)
(num-subs_l3)
(not (not-chosen_gp19arf))
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
(:action CHOOSE_HDAC1-PRBP1-E2F13-DP12_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_hdac1-prbp1-e2f13-dp12)
)
:effect
(and
(chosen_hdac1-prbp1-e2f13-dp12)
(num-subs_l3)
(not (not-chosen_hdac1-prbp1-e2f13-dp12))
(not (num-subs_l2))
)
)
(:action CHOOSE_HDAC1-PRBP1-E2F13P1-DP12_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_hdac1-prbp1-e2f13p1-dp12)
)
:effect
(and
(chosen_hdac1-prbp1-e2f13p1-dp12)
(num-subs_l3)
(not (not-chosen_hdac1-prbp1-e2f13p1-dp12))
(not (num-subs_l2))
)
)
(:action CHOOSE_HDAC1-PRBP1-E2F4-DP12_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_hdac1-prbp1-e2f4-dp12)
)
:effect
(and
(chosen_hdac1-prbp1-e2f4-dp12)
(num-subs_l3)
(not (not-chosen_hdac1-prbp1-e2f4-dp12))
(not (num-subs_l2))
)
)
(:action CHOOSE_JUN_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_jun)
)
:effect
(and
(chosen_jun)
(num-subs_l3)
(not (not-chosen_jun))
(not (num-subs_l2))
)
)
(:action CHOOSE_MAX_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_max)
)
:effect
(and
(chosen_max)
(num-subs_l3)
(not (not-chosen_max))
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
(:action CHOOSE_P130-E2F4P1-DP12_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_p130-e2f4p1-dp12)
)
:effect
(and
(chosen_p130-e2f4p1-dp12)
(num-subs_l3)
(not (not-chosen_p130-e2f4p1-dp12))
(not (num-subs_l2))
)
)
(:action CHOOSE_P130-E2F5P1-DP12_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_p130-e2f5p1-dp12)
)
:effect
(and
(chosen_p130-e2f5p1-dp12)
(num-subs_l3)
(not (not-chosen_p130-e2f5p1-dp12))
(not (num-subs_l2))
)
)
(:action CHOOSE_P27_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_p27)
)
:effect
(and
(chosen_p27)
(num-subs_l3)
(not (not-chosen_p27))
(not (num-subs_l2))
)
)
(:action CHOOSE_P57_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_p57)
)
:effect
(and
(chosen_p57)
(num-subs_l3)
(not (not-chosen_p57))
(not (num-subs_l2))
)
)
(:action CHOOSE_P57P1_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_p57p1)
)
:effect
(and
(chosen_p57p1)
(num-subs_l3)
(not (not-chosen_p57p1))
(not (num-subs_l2))
)
)
(:action CHOOSE_PLK1_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_plk1)
)
:effect
(and
(chosen_plk1)
(num-subs_l3)
(not (not-chosen_plk1))
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
(:action CHOOSE_RAF1_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_raf1)
)
:effect
(and
(chosen_raf1)
(num-subs_l3)
(not (not-chosen_raf1))
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
(:action CHOOSE_SKP1_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_skp1)
)
:effect
(and
(chosen_skp1)
(num-subs_l3)
(not (not-chosen_skp1))
(not (num-subs_l2))
)
)
(:action CHOOSE_SKP2_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_skp2)
)
:effect
(and
(chosen_skp2)
(num-subs_l3)
(not (not-chosen_skp2))
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
(:action dummy-action-8-2
:parameters ()
:precondition
(and
(available_hdac1-p130-e2f5-dp12)
)
:effect
(and
(goal8_)
)
)
(:action dummy-action-4-1
:parameters ()
:precondition
(and
(available_hdac1-p107-e2f4-dp12-ge2)
)
:effect
(and
(goal4_)
)
)
(:action SYNTHESIZE_DMP1P1-GP19ARF_P19ARF
:parameters ()
:precondition
(and
(available_dmp1p1-gp19arf)
)
:effect
(and
(available_p19arf)
)
)
(:action SYNTHESIZE_E2F4-DP12-GE2_C-MYC
:parameters ()
:precondition
(and
(available_e2f4-dp12-ge2)
)
:effect
(and
(available_c-myc)
)
)
(:action SYNTHESIZE_E2F4-DP12-GE2_CYCA
:parameters ()
:precondition
(and
(available_e2f4-dp12-ge2)
)
:effect
(and
(available_cyca)
)
)
(:action SYNTHESIZE_E2F4-DP12-GE2_CYCD
:parameters ()
:precondition
(and
(available_e2f4-dp12-ge2)
)
:effect
(and
(available_cycd)
)
)
(:action SYNTHESIZE_E2F4-DP12-GE2_CYCDP1
:parameters ()
:precondition
(and
(available_e2f4-dp12-ge2)
)
:effect
(and
(available_cycdp1)
)
)
(:action SYNTHESIZE_E2F4-DP12-GE2_CYCE
:parameters ()
:precondition
(and
(available_e2f4-dp12-ge2)
)
:effect
(and
(available_cyce)
)
)
(:action SYNTHESIZE_E2F4-DP12-GE2_CYCEP1
:parameters ()
:precondition
(and
(available_e2f4-dp12-ge2)
)
:effect
(and
(available_cycep1)
)
)
(:action SYNTHESIZE_E2F4-DP12-GE2_P107
:parameters ()
:precondition
(and
(available_e2f4-dp12-ge2)
)
:effect
(and
(available_p107)
)
)
(:action SYNTHESIZE_E2F4-DP12-GE2_P107P1
:parameters ()
:precondition
(and
(available_e2f4-dp12-ge2)
)
:effect
(and
(available_p107p1)
)
)
(:action SYNTHESIZE_E2F4-DP12-GE2_P19ARF
:parameters ()
:precondition
(and
(available_e2f4-dp12-ge2)
)
:effect
(and
(available_p19arf)
)
)
(:action SYNTHESIZE_E2F4-DP12-GE2_POL
:parameters ()
:precondition
(and
(available_e2f4-dp12-ge2)
)
:effect
(and
(available_pol)
)
)
(:action SYNTHESIZE_E2F5-DP12-GE2_C-MYC
:parameters ()
:precondition
(and
(available_e2f5-dp12-ge2)
)
:effect
(and
(available_c-myc)
)
)
(:action SYNTHESIZE_E2F5-DP12-GE2_CYCA
:parameters ()
:precondition
(and
(available_e2f5-dp12-ge2)
)
:effect
(and
(available_cyca)
)
)
(:action SYNTHESIZE_E2F5-DP12-GE2_CYCD
:parameters ()
:precondition
(and
(available_e2f5-dp12-ge2)
)
:effect
(and
(available_cycd)
)
)
(:action SYNTHESIZE_E2F5-DP12-GE2_CYCDP1
:parameters ()
:precondition
(and
(available_e2f5-dp12-ge2)
)
:effect
(and
(available_cycdp1)
)
)
(:action SYNTHESIZE_E2F5-DP12-GE2_CYCE
:parameters ()
:precondition
(and
(available_e2f5-dp12-ge2)
)
:effect
(and
(available_cyce)
)
)
(:action SYNTHESIZE_E2F5-DP12-GE2_CYCEP1
:parameters ()
:precondition
(and
(available_e2f5-dp12-ge2)
)
:effect
(and
(available_cycep1)
)
)
(:action SYNTHESIZE_E2F5-DP12-GE2_P107
:parameters ()
:precondition
(and
(available_e2f5-dp12-ge2)
)
:effect
(and
(available_p107)
)
)
(:action SYNTHESIZE_E2F5-DP12-GE2_P107P1
:parameters ()
:precondition
(and
(available_e2f5-dp12-ge2)
)
:effect
(and
(available_p107p1)
)
)
(:action SYNTHESIZE_E2F5-DP12-GE2_P19ARF
:parameters ()
:precondition
(and
(available_e2f5-dp12-ge2)
)
:effect
(and
(available_p19arf)
)
)
(:action SYNTHESIZE_E2F5-DP12-GE2_POL
:parameters ()
:precondition
(and
(available_e2f5-dp12-ge2)
)
:effect
(and
(available_pol)
)
)
(:action ASSOCIATE-WITH-CATALYZE_CYCA_SKP2-SKP1_SKP2-SKP1
:parameters ()
:precondition
(and
(available_skp2-skp1)
(available_cyca)
)
:effect
(and
(available_skp2-skp1)
(not (available_cyca))
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
(:action ASSOCIATE_C-MYC_MAX_C-MYC-MAX
:parameters ()
:precondition
(and
(available_max)
(available_c-myc)
)
:effect
(and
(available_c-myc-max)
(not (available_c-myc))
(not (available_max))
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
(:action ASSOCIATE_DMP1P1_CYCD_DMP1P1-CYCD
:parameters ()
:precondition
(and
(available_cycd)
(available_dmp1p1)
)
:effect
(and
(available_dmp1p1-cycd)
(not (available_dmp1p1))
(not (available_cycd))
)
)
(:action ASSOCIATE_DMP1P1_CYCDP1_DMP1P1-CYCDP1
:parameters ()
:precondition
(and
(available_cycdp1)
(available_dmp1p1)
)
:effect
(and
(available_dmp1p1-cycdp1)
(not (available_dmp1p1))
(not (available_cycdp1))
)
)
(:action ASSOCIATE_DMP1P1_GP19ARF_DMP1P1-GP19ARF
:parameters ()
:precondition
(and
(available_gp19arf)
(available_dmp1p1)
)
:effect
(and
(available_dmp1p1-gp19arf)
(not (available_dmp1p1))
(not (available_gp19arf))
)
)
(:action ASSOCIATE_E2F4-DP12_GE2_E2F4-DP12-GE2
:parameters ()
:precondition
(and
(available_ge2)
(available_e2f4-dp12)
)
:effect
(and
(available_e2f4-dp12-ge2)
(not (available_e2f4-dp12))
(not (available_ge2))
)
)
(:action ASSOCIATE_E2F5-DP12_GE2_E2F5-DP12-GE2
:parameters ()
:precondition
(and
(available_ge2)
(available_e2f5-dp12)
)
:effect
(and
(available_e2f5-dp12-ge2)
(not (available_e2f5-dp12))
(not (available_ge2))
)
)
(:action ASSOCIATE_HDAC1-P107-E2F4-DP12_GE2_HDAC1-P107-E2F4-DP12-GE2
:parameters ()
:precondition
(and
(available_ge2)
(available_hdac1-p107-e2f4-dp12)
)
:effect
(and
(available_hdac1-p107-e2f4-dp12-ge2)
(not (available_hdac1-p107-e2f4-dp12))
(not (available_ge2))
)
)
(:action ASSOCIATE_HDAC1_P107-E2F4-DP12_HDAC1-P107-E2F4-DP12
:parameters ()
:precondition
(and
(available_p107-e2f4-dp12)
(available_hdac1)
)
:effect
(and
(available_hdac1-p107-e2f4-dp12)
(not (available_hdac1))
(not (available_p107-e2f4-dp12))
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
(:action ASSOCIATE_HDAC1-P130-E2F4-DP12_GE2_HDAC1-P130-E2F4-DP12-GE2
:parameters ()
:precondition
(and
(available_ge2)
(available_hdac1-p130-e2f4-dp12)
)
:effect
(and
(available_hdac1-p130-e2f4-dp12-ge2)
(not (available_hdac1-p130-e2f4-dp12))
(not (available_ge2))
)
)
(:action ASSOCIATE_HDAC1_P130-E2F4-DP12_HDAC1-P130-E2F4-DP12
:parameters ()
:precondition
(and
(available_p130-e2f4-dp12)
(available_hdac1)
)
:effect
(and
(available_hdac1-p130-e2f4-dp12)
(not (available_hdac1))
(not (available_p130-e2f4-dp12))
)
)
(:action ASSOCIATE_HDAC1-P130-E2F5-DP12_GE2_HDAC1-P130-E2F5-DP12-GE2
:parameters ()
:precondition
(and
(available_ge2)
(available_hdac1-p130-e2f5-dp12)
)
:effect
(and
(available_hdac1-p130-e2f5-dp12-ge2)
(not (available_hdac1-p130-e2f5-dp12))
(not (available_ge2))
)
)
(:action ASSOCIATE_HDAC1_P130-E2F5-DP12_HDAC1-P130-E2F5-DP12
:parameters ()
:precondition
(and
(available_p130-e2f5-dp12)
(available_hdac1)
)
:effect
(and
(available_hdac1-p130-e2f5-dp12)
(not (available_hdac1))
(not (available_p130-e2f5-dp12))
)
)
(:action ASSOCIATE_P107-E2F4-DP12_GE2_P107-E2F4-DP12-GE2
:parameters ()
:precondition
(and
(available_ge2)
(available_p107-e2f4-dp12)
)
:effect
(and
(available_p107-e2f4-dp12-ge2)
(not (available_p107-e2f4-dp12))
(not (available_ge2))
)
)
(:action ASSOCIATE_P107_E2F4-DP12_P107-E2F4-DP12
:parameters ()
:precondition
(and
(available_e2f4-dp12)
(available_p107)
)
:effect
(and
(available_p107-e2f4-dp12)
(not (available_p107))
(not (available_e2f4-dp12))
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
(:action ASSOCIATE_P130-E2F4-DP12_GE2_P130-E2F4-DP12-GE2
:parameters ()
:precondition
(and
(available_ge2)
(available_p130-e2f4-dp12)
)
:effect
(and
(available_p130-e2f4-dp12-ge2)
(not (available_p130-e2f4-dp12))
(not (available_ge2))
)
)
(:action ASSOCIATE_P130_E2F4-DP12_P130-E2F4-DP12
:parameters ()
:precondition
(and
(available_e2f4-dp12)
(available_p130)
)
:effect
(and
(available_p130-e2f4-dp12)
(not (available_p130))
(not (available_e2f4-dp12))
)
)
(:action ASSOCIATE_P130-E2F5-DP12_GE2_P130-E2F5-DP12-GE2
:parameters ()
:precondition
(and
(available_ge2)
(available_p130-e2f5-dp12)
)
:effect
(and
(available_p130-e2f5-dp12-ge2)
(not (available_p130-e2f5-dp12))
(not (available_ge2))
)
)
(:action ASSOCIATE_P130_E2F5-DP12_P130-E2F5-DP12
:parameters ()
:precondition
(and
(available_e2f5-dp12)
(available_p130)
)
:effect
(and
(available_p130-e2f5-dp12)
(not (available_p130))
(not (available_e2f5-dp12))
)
)
(:action ASSOCIATE_PRBP1P2_JUN_PRBP1P2-JUN
:parameters ()
:precondition
(and
(available_jun)
(available_prbp1p2)
)
:effect
(and
(available_prbp1p2-jun)
(not (available_prbp1p2))
(not (available_jun))
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
(:action CHOOSE_APC_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_apc)
)
:effect
(and
(chosen_apc)
(num-subs_l2)
(not (not-chosen_apc))
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
(:action CHOOSE_DP12_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_dp12)
)
:effect
(and
(chosen_dp12)
(num-subs_l2)
(not (not-chosen_dp12))
(not (num-subs_l1))
)
)
(:action CHOOSE_E2F1_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_e2f1)
)
:effect
(and
(chosen_e2f1)
(num-subs_l2)
(not (not-chosen_e2f1))
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
(:action CHOOSE_E2F13-DP12_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_e2f13-dp12)
)
:effect
(and
(chosen_e2f13-dp12)
(num-subs_l2)
(not (not-chosen_e2f13-dp12))
(not (num-subs_l1))
)
)
(:action CHOOSE_E2F13P1-DP12_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_e2f13p1-dp12)
)
:effect
(and
(chosen_e2f13p1-dp12)
(num-subs_l2)
(not (not-chosen_e2f13p1-dp12))
(not (num-subs_l1))
)
)
(:action CHOOSE_E2F3_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_e2f3)
)
:effect
(and
(chosen_e2f3)
(num-subs_l2)
(not (not-chosen_e2f3))
(not (num-subs_l1))
)
)
(:action CHOOSE_E2F4_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_e2f4)
)
:effect
(and
(chosen_e2f4)
(num-subs_l2)
(not (not-chosen_e2f4))
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
(:action CHOOSE_E2F5_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_e2f5)
)
:effect
(and
(chosen_e2f5)
(num-subs_l2)
(not (not-chosen_e2f5))
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
(:action CHOOSE_GCDC25A_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_gcdc25a)
)
:effect
(and
(chosen_gcdc25a)
(num-subs_l2)
(not (not-chosen_gcdc25a))
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
(:action CHOOSE_GP19ARF_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_gp19arf)
)
:effect
(and
(chosen_gp19arf)
(num-subs_l2)
(not (not-chosen_gp19arf))
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
(:action CHOOSE_HDAC1-PRBP1-E2F13-DP12_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_hdac1-prbp1-e2f13-dp12)
)
:effect
(and
(chosen_hdac1-prbp1-e2f13-dp12)
(num-subs_l2)
(not (not-chosen_hdac1-prbp1-e2f13-dp12))
(not (num-subs_l1))
)
)
(:action CHOOSE_HDAC1-PRBP1-E2F13P1-DP12_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_hdac1-prbp1-e2f13p1-dp12)
)
:effect
(and
(chosen_hdac1-prbp1-e2f13p1-dp12)
(num-subs_l2)
(not (not-chosen_hdac1-prbp1-e2f13p1-dp12))
(not (num-subs_l1))
)
)
(:action CHOOSE_HDAC1-PRBP1-E2F4-DP12_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_hdac1-prbp1-e2f4-dp12)
)
:effect
(and
(chosen_hdac1-prbp1-e2f4-dp12)
(num-subs_l2)
(not (not-chosen_hdac1-prbp1-e2f4-dp12))
(not (num-subs_l1))
)
)
(:action CHOOSE_JUN_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_jun)
)
:effect
(and
(chosen_jun)
(num-subs_l2)
(not (not-chosen_jun))
(not (num-subs_l1))
)
)
(:action CHOOSE_MAX_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_max)
)
:effect
(and
(chosen_max)
(num-subs_l2)
(not (not-chosen_max))
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
(:action CHOOSE_P130-E2F4P1-DP12_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_p130-e2f4p1-dp12)
)
:effect
(and
(chosen_p130-e2f4p1-dp12)
(num-subs_l2)
(not (not-chosen_p130-e2f4p1-dp12))
(not (num-subs_l1))
)
)
(:action CHOOSE_P130-E2F5P1-DP12_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_p130-e2f5p1-dp12)
)
:effect
(and
(chosen_p130-e2f5p1-dp12)
(num-subs_l2)
(not (not-chosen_p130-e2f5p1-dp12))
(not (num-subs_l1))
)
)
(:action CHOOSE_P27_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_p27)
)
:effect
(and
(chosen_p27)
(num-subs_l2)
(not (not-chosen_p27))
(not (num-subs_l1))
)
)
(:action CHOOSE_P57_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_p57)
)
:effect
(and
(chosen_p57)
(num-subs_l2)
(not (not-chosen_p57))
(not (num-subs_l1))
)
)
(:action CHOOSE_P57P1_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_p57p1)
)
:effect
(and
(chosen_p57p1)
(num-subs_l2)
(not (not-chosen_p57p1))
(not (num-subs_l1))
)
)
(:action CHOOSE_PLK1_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_plk1)
)
:effect
(and
(chosen_plk1)
(num-subs_l2)
(not (not-chosen_plk1))
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
(:action CHOOSE_RAF1_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_raf1)
)
:effect
(and
(chosen_raf1)
(num-subs_l2)
(not (not-chosen_raf1))
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
(:action CHOOSE_SKP1_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_skp1)
)
:effect
(and
(chosen_skp1)
(num-subs_l2)
(not (not-chosen_skp1))
(not (num-subs_l1))
)
)
(:action CHOOSE_SKP2_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_skp2)
)
:effect
(and
(chosen_skp2)
(num-subs_l2)
(not (not-chosen_skp2))
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
(:action dummy-action-11-2
:parameters ()
:precondition
(and
(available_pol)
)
:effect
(and
(goal11_)
)
)
(:action dummy-action-4-2
:parameters ()
:precondition
(and
(available_c-myc)
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
(available_cyca)
)
:effect
(and
(goal2_)
)
)
(:action SYNTHESIZE_E2F13-DP12-GE2_C-MYC
:parameters ()
:precondition
(and
(available_e2f13-dp12-ge2)
)
:effect
(and
(available_c-myc)
)
)
(:action SYNTHESIZE_E2F13-DP12-GE2_CYCA
:parameters ()
:precondition
(and
(available_e2f13-dp12-ge2)
)
:effect
(and
(available_cyca)
)
)
(:action SYNTHESIZE_E2F13-DP12-GE2_CYCD
:parameters ()
:precondition
(and
(available_e2f13-dp12-ge2)
)
:effect
(and
(available_cycd)
)
)
(:action SYNTHESIZE_E2F13-DP12-GE2_CYCDP1
:parameters ()
:precondition
(and
(available_e2f13-dp12-ge2)
)
:effect
(and
(available_cycdp1)
)
)
(:action SYNTHESIZE_E2F13-DP12-GE2_CYCE
:parameters ()
:precondition
(and
(available_e2f13-dp12-ge2)
)
:effect
(and
(available_cyce)
)
)
(:action SYNTHESIZE_E2F13-DP12-GE2_CYCEP1
:parameters ()
:precondition
(and
(available_e2f13-dp12-ge2)
)
:effect
(and
(available_cycep1)
)
)
(:action SYNTHESIZE_E2F13-DP12-GE2_P107
:parameters ()
:precondition
(and
(available_e2f13-dp12-ge2)
)
:effect
(and
(available_p107)
)
)
(:action SYNTHESIZE_E2F13-DP12-GE2_P107P1
:parameters ()
:precondition
(and
(available_e2f13-dp12-ge2)
)
:effect
(and
(available_p107p1)
)
)
(:action SYNTHESIZE_E2F13-DP12-GE2_P19ARF
:parameters ()
:precondition
(and
(available_e2f13-dp12-ge2)
)
:effect
(and
(available_p19arf)
)
)
(:action SYNTHESIZE_E2F13-DP12-GE2_POL
:parameters ()
:precondition
(and
(available_e2f13-dp12-ge2)
)
:effect
(and
(available_pol)
)
)
(:action SYNTHESIZE_E2F13P1-DP12-GE2_C-MYC
:parameters ()
:precondition
(and
(available_e2f13p1-dp12-ge2)
)
:effect
(and
(available_c-myc)
)
)
(:action SYNTHESIZE_E2F13P1-DP12-GE2_CYCA
:parameters ()
:precondition
(and
(available_e2f13p1-dp12-ge2)
)
:effect
(and
(available_cyca)
)
)
(:action SYNTHESIZE_E2F13P1-DP12-GE2_CYCD
:parameters ()
:precondition
(and
(available_e2f13p1-dp12-ge2)
)
:effect
(and
(available_cycd)
)
)
(:action SYNTHESIZE_E2F13P1-DP12-GE2_CYCDP1
:parameters ()
:precondition
(and
(available_e2f13p1-dp12-ge2)
)
:effect
(and
(available_cycdp1)
)
)
(:action SYNTHESIZE_E2F13P1-DP12-GE2_CYCE
:parameters ()
:precondition
(and
(available_e2f13p1-dp12-ge2)
)
:effect
(and
(available_cyce)
)
)
(:action SYNTHESIZE_E2F13P1-DP12-GE2_CYCEP1
:parameters ()
:precondition
(and
(available_e2f13p1-dp12-ge2)
)
:effect
(and
(available_cycep1)
)
)
(:action SYNTHESIZE_E2F13P1-DP12-GE2_P107
:parameters ()
:precondition
(and
(available_e2f13p1-dp12-ge2)
)
:effect
(and
(available_p107)
)
)
(:action SYNTHESIZE_E2F13P1-DP12-GE2_P107P1
:parameters ()
:precondition
(and
(available_e2f13p1-dp12-ge2)
)
:effect
(and
(available_p107p1)
)
)
(:action SYNTHESIZE_E2F13P1-DP12-GE2_P19ARF
:parameters ()
:precondition
(and
(available_e2f13p1-dp12-ge2)
)
:effect
(and
(available_p19arf)
)
)
(:action SYNTHESIZE_E2F13P1-DP12-GE2_POL
:parameters ()
:precondition
(and
(available_e2f13p1-dp12-ge2)
)
:effect
(and
(available_pol)
)
)
(:action SYNTHESIZE_RAF1-P130-E2F4P1-DP12-GE2_C-MYC
:parameters ()
:precondition
(and
(available_raf1-p130-e2f4p1-dp12-ge2)
)
:effect
(and
(available_c-myc)
)
)
(:action SYNTHESIZE_RAF1-P130-E2F4P1-DP12-GE2_CYCA
:parameters ()
:precondition
(and
(available_raf1-p130-e2f4p1-dp12-ge2)
)
:effect
(and
(available_cyca)
)
)
(:action SYNTHESIZE_RAF1-P130-E2F4P1-DP12-GE2_CYCD
:parameters ()
:precondition
(and
(available_raf1-p130-e2f4p1-dp12-ge2)
)
:effect
(and
(available_cycd)
)
)
(:action SYNTHESIZE_RAF1-P130-E2F4P1-DP12-GE2_CYCDP1
:parameters ()
:precondition
(and
(available_raf1-p130-e2f4p1-dp12-ge2)
)
:effect
(and
(available_cycdp1)
)
)
(:action SYNTHESIZE_RAF1-P130-E2F4P1-DP12-GE2_CYCE
:parameters ()
:precondition
(and
(available_raf1-p130-e2f4p1-dp12-ge2)
)
:effect
(and
(available_cyce)
)
)
(:action SYNTHESIZE_RAF1-P130-E2F4P1-DP12-GE2_CYCEP1
:parameters ()
:precondition
(and
(available_raf1-p130-e2f4p1-dp12-ge2)
)
:effect
(and
(available_cycep1)
)
)
(:action SYNTHESIZE_RAF1-P130-E2F4P1-DP12-GE2_P107
:parameters ()
:precondition
(and
(available_raf1-p130-e2f4p1-dp12-ge2)
)
:effect
(and
(available_p107)
)
)
(:action SYNTHESIZE_RAF1-P130-E2F4P1-DP12-GE2_P107P1
:parameters ()
:precondition
(and
(available_raf1-p130-e2f4p1-dp12-ge2)
)
:effect
(and
(available_p107p1)
)
)
(:action SYNTHESIZE_RAF1-P130-E2F4P1-DP12-GE2_P19ARF
:parameters ()
:precondition
(and
(available_raf1-p130-e2f4p1-dp12-ge2)
)
:effect
(and
(available_p19arf)
)
)
(:action SYNTHESIZE_RAF1-P130-E2F4P1-DP12-GE2_POL
:parameters ()
:precondition
(and
(available_raf1-p130-e2f4p1-dp12-ge2)
)
:effect
(and
(available_pol)
)
)
(:action SYNTHESIZE_RAF1-P130-E2F5P1-DP12-GE2_C-MYC
:parameters ()
:precondition
(and
(available_raf1-p130-e2f5p1-dp12-ge2)
)
:effect
(and
(available_c-myc)
)
)
(:action SYNTHESIZE_RAF1-P130-E2F5P1-DP12-GE2_CYCA
:parameters ()
:precondition
(and
(available_raf1-p130-e2f5p1-dp12-ge2)
)
:effect
(and
(available_cyca)
)
)
(:action SYNTHESIZE_RAF1-P130-E2F5P1-DP12-GE2_CYCD
:parameters ()
:precondition
(and
(available_raf1-p130-e2f5p1-dp12-ge2)
)
:effect
(and
(available_cycd)
)
)
(:action SYNTHESIZE_RAF1-P130-E2F5P1-DP12-GE2_CYCDP1
:parameters ()
:precondition
(and
(available_raf1-p130-e2f5p1-dp12-ge2)
)
:effect
(and
(available_cycdp1)
)
)
(:action SYNTHESIZE_RAF1-P130-E2F5P1-DP12-GE2_CYCE
:parameters ()
:precondition
(and
(available_raf1-p130-e2f5p1-dp12-ge2)
)
:effect
(and
(available_cyce)
)
)
(:action SYNTHESIZE_RAF1-P130-E2F5P1-DP12-GE2_CYCEP1
:parameters ()
:precondition
(and
(available_raf1-p130-e2f5p1-dp12-ge2)
)
:effect
(and
(available_cycep1)
)
)
(:action SYNTHESIZE_RAF1-P130-E2F5P1-DP12-GE2_P107
:parameters ()
:precondition
(and
(available_raf1-p130-e2f5p1-dp12-ge2)
)
:effect
(and
(available_p107)
)
)
(:action SYNTHESIZE_RAF1-P130-E2F5P1-DP12-GE2_P107P1
:parameters ()
:precondition
(and
(available_raf1-p130-e2f5p1-dp12-ge2)
)
:effect
(and
(available_p107p1)
)
)
(:action SYNTHESIZE_RAF1-P130-E2F5P1-DP12-GE2_P19ARF
:parameters ()
:precondition
(and
(available_raf1-p130-e2f5p1-dp12-ge2)
)
:effect
(and
(available_p19arf)
)
)
(:action SYNTHESIZE_RAF1-P130-E2F5P1-DP12-GE2_POL
:parameters ()
:precondition
(and
(available_raf1-p130-e2f5p1-dp12-ge2)
)
:effect
(and
(available_pol)
)
)
(:action SYNTHESIZE_RAF1-PRB-E2F4P1-DP12-GE2_C-MYC
:parameters ()
:precondition
(and
(available_raf1-prb-e2f4p1-dp12-ge2)
)
:effect
(and
(available_c-myc)
)
)
(:action SYNTHESIZE_RAF1-PRB-E2F4P1-DP12-GE2_CYCA
:parameters ()
:precondition
(and
(available_raf1-prb-e2f4p1-dp12-ge2)
)
:effect
(and
(available_cyca)
)
)
(:action SYNTHESIZE_RAF1-PRB-E2F4P1-DP12-GE2_CYCD
:parameters ()
:precondition
(and
(available_raf1-prb-e2f4p1-dp12-ge2)
)
:effect
(and
(available_cycd)
)
)
(:action SYNTHESIZE_RAF1-PRB-E2F4P1-DP12-GE2_CYCDP1
:parameters ()
:precondition
(and
(available_raf1-prb-e2f4p1-dp12-ge2)
)
:effect
(and
(available_cycdp1)
)
)
(:action SYNTHESIZE_RAF1-PRB-E2F4P1-DP12-GE2_CYCE
:parameters ()
:precondition
(and
(available_raf1-prb-e2f4p1-dp12-ge2)
)
:effect
(and
(available_cyce)
)
)
(:action SYNTHESIZE_RAF1-PRB-E2F4P1-DP12-GE2_CYCEP1
:parameters ()
:precondition
(and
(available_raf1-prb-e2f4p1-dp12-ge2)
)
:effect
(and
(available_cycep1)
)
)
(:action SYNTHESIZE_RAF1-PRB-E2F4P1-DP12-GE2_P107
:parameters ()
:precondition
(and
(available_raf1-prb-e2f4p1-dp12-ge2)
)
:effect
(and
(available_p107)
)
)
(:action SYNTHESIZE_RAF1-PRB-E2F4P1-DP12-GE2_P107P1
:parameters ()
:precondition
(and
(available_raf1-prb-e2f4p1-dp12-ge2)
)
:effect
(and
(available_p107p1)
)
)
(:action SYNTHESIZE_RAF1-PRB-E2F4P1-DP12-GE2_P19ARF
:parameters ()
:precondition
(and
(available_raf1-prb-e2f4p1-dp12-ge2)
)
:effect
(and
(available_p19arf)
)
)
(:action SYNTHESIZE_RAF1-PRB-E2F4P1-DP12-GE2_POL
:parameters ()
:precondition
(and
(available_raf1-prb-e2f4p1-dp12-ge2)
)
:effect
(and
(available_pol)
)
)
(:action SYNTHESIZE_RAF1-PRBP1-E2F4P1-DP12-GE2_C-MYC
:parameters ()
:precondition
(and
(available_raf1-prbp1-e2f4p1-dp12-ge2)
)
:effect
(and
(available_c-myc)
)
)
(:action SYNTHESIZE_RAF1-PRBP1-E2F4P1-DP12-GE2_CYCA
:parameters ()
:precondition
(and
(available_raf1-prbp1-e2f4p1-dp12-ge2)
)
:effect
(and
(available_cyca)
)
)
(:action SYNTHESIZE_RAF1-PRBP1-E2F4P1-DP12-GE2_CYCD
:parameters ()
:precondition
(and
(available_raf1-prbp1-e2f4p1-dp12-ge2)
)
:effect
(and
(available_cycd)
)
)
(:action SYNTHESIZE_RAF1-PRBP1-E2F4P1-DP12-GE2_CYCDP1
:parameters ()
:precondition
(and
(available_raf1-prbp1-e2f4p1-dp12-ge2)
)
:effect
(and
(available_cycdp1)
)
)
(:action SYNTHESIZE_RAF1-PRBP1-E2F4P1-DP12-GE2_CYCE
:parameters ()
:precondition
(and
(available_raf1-prbp1-e2f4p1-dp12-ge2)
)
:effect
(and
(available_cyce)
)
)
(:action SYNTHESIZE_RAF1-PRBP1-E2F4P1-DP12-GE2_CYCEP1
:parameters ()
:precondition
(and
(available_raf1-prbp1-e2f4p1-dp12-ge2)
)
:effect
(and
(available_cycep1)
)
)
(:action SYNTHESIZE_RAF1-PRBP1-E2F4P1-DP12-GE2_P107
:parameters ()
:precondition
(and
(available_raf1-prbp1-e2f4p1-dp12-ge2)
)
:effect
(and
(available_p107)
)
)
(:action SYNTHESIZE_RAF1-PRBP1-E2F4P1-DP12-GE2_P107P1
:parameters ()
:precondition
(and
(available_raf1-prbp1-e2f4p1-dp12-ge2)
)
:effect
(and
(available_p107p1)
)
)
(:action SYNTHESIZE_RAF1-PRBP1-E2F4P1-DP12-GE2_P19ARF
:parameters ()
:precondition
(and
(available_raf1-prbp1-e2f4p1-dp12-ge2)
)
:effect
(and
(available_p19arf)
)
)
(:action SYNTHESIZE_RAF1-PRBP1-E2F4P1-DP12-GE2_POL
:parameters ()
:precondition
(and
(available_raf1-prbp1-e2f4p1-dp12-ge2)
)
:effect
(and
(available_pol)
)
)
(:action ASSOCIATE-WITH-CATALYZE_APC_PLK1_APCP1
:parameters ()
:precondition
(and
(available_plk1)
(available_apc)
)
:effect
(and
(available_apcp1)
(not (available_apc))
)
)
(:action ASSOCIATE-WITH-CATALYZE_DMP1_CDK46P3-CYCD_DMP1P1
:parameters ()
:precondition
(and
(available_cdk46p3-cycd)
(available_dmp1)
)
:effect
(and
(available_dmp1p1)
(not (available_dmp1))
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
(:action ASSOCIATE_DMP1_GP19ARF_DMP1-GP19ARF
:parameters ()
:precondition
(and
(available_gp19arf)
(available_dmp1)
)
:effect
(and
(available_dmp1-gp19arf)
(not (available_dmp1))
(not (available_gp19arf))
)
)
(:action ASSOCIATE_E2F13-DP12_GE2_E2F13-DP12-GE2
:parameters ()
:precondition
(and
(available_ge2)
(available_e2f13-dp12)
)
:effect
(and
(available_e2f13-dp12-ge2)
(not (available_e2f13-dp12))
(not (available_ge2))
)
)
(:action ASSOCIATE_E2F13P1-DP12_GE2_E2F13P1-DP12-GE2
:parameters ()
:precondition
(and
(available_ge2)
(available_e2f13p1-dp12)
)
:effect
(and
(available_e2f13p1-dp12-ge2)
(not (available_e2f13p1-dp12))
(not (available_ge2))
)
)
(:action ASSOCIATE_E2F1_DP12_E2F1-DP12
:parameters ()
:precondition
(and
(available_dp12)
(available_e2f1)
)
:effect
(and
(available_e2f1-dp12)
(not (available_e2f1))
(not (available_dp12))
)
)
(:action ASSOCIATE_E2F3_DP12_E2F3-DP12
:parameters ()
:precondition
(and
(available_dp12)
(available_e2f3)
)
:effect
(and
(available_e2f3-dp12)
(not (available_e2f3))
(not (available_dp12))
)
)
(:action ASSOCIATE_E2F4_DP12_E2F4-DP12
:parameters ()
:precondition
(and
(available_dp12)
(available_e2f4)
)
:effect
(and
(available_e2f4-dp12)
(not (available_e2f4))
(not (available_dp12))
)
)
(:action ASSOCIATE_E2F5_DP12_E2F5-DP12
:parameters ()
:precondition
(and
(available_dp12)
(available_e2f5)
)
:effect
(and
(available_e2f5-dp12)
(not (available_e2f5))
(not (available_dp12))
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
(:action ASSOCIATE_HDAC1-PRBP1-E2F13-DP12_GE2_HDAC1-PRBP1-E2F13-DP12-GE2
:parameters ()
:precondition
(and
(available_ge2)
(available_hdac1-prbp1-e2f13-dp12)
)
:effect
(and
(available_hdac1-prbp1-e2f13-dp12-ge2)
(not (available_hdac1-prbp1-e2f13-dp12))
(not (available_ge2))
)
)
(:action ASSOCIATE_HDAC1-PRBP1-E2F13P1-DP12_GE2_HDAC1-PRBP1-E2F13P1-DP12-GE2
:parameters ()
:precondition
(and
(available_ge2)
(available_hdac1-prbp1-e2f13p1-dp12)
)
:effect
(and
(available_hdac1-prbp1-e2f13p1-dp12-ge2)
(not (available_hdac1-prbp1-e2f13p1-dp12))
(not (available_ge2))
)
)
(:action ASSOCIATE_HDAC1-PRBP1-E2F4-DP12_GE2_HDAC1-PRBP1-E2F4-DP12-GE2
:parameters ()
:precondition
(and
(available_ge2)
(available_hdac1-prbp1-e2f4-dp12)
)
:effect
(and
(available_hdac1-prbp1-e2f4-dp12-ge2)
(not (available_hdac1-prbp1-e2f4-dp12))
(not (available_ge2))
)
)
(:action ASSOCIATE_P130-E2F4-DP12P1_GE2_P130-E2F4-DP12P1-GE2
:parameters ()
:precondition
(and
(available_ge2)
(available_p130-e2f4-dp12p1)
)
:effect
(and
(available_p130-e2f4-dp12p1-ge2)
(not (available_p130-e2f4-dp12p1))
(not (available_ge2))
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
(:action ASSOCIATE_PRBP2_JUN_PRBP2-JUN
:parameters ()
:precondition
(and
(available_jun)
(available_prbp2)
)
:effect
(and
(available_prbp2-jun)
(not (available_prbp2))
(not (available_jun))
)
)
(:action ASSOCIATE_RAF1-P130-E2F4P1-DP12_GE2_RAF1-P130-E2F4P1-DP12-GE2
:parameters ()
:precondition
(and
(available_ge2)
(available_raf1-p130-e2f4p1-dp12)
)
:effect
(and
(available_raf1-p130-e2f4p1-dp12-ge2)
(not (available_raf1-p130-e2f4p1-dp12))
(not (available_ge2))
)
)
(:action ASSOCIATE_RAF1_P130-E2F4P1-DP12_RAF1-P130-E2F4P1-DP12
:parameters ()
:precondition
(and
(available_p130-e2f4p1-dp12)
(available_raf1)
)
:effect
(and
(available_raf1-p130-e2f4p1-dp12)
(not (available_raf1))
(not (available_p130-e2f4p1-dp12))
)
)
(:action ASSOCIATE_RAF1-P130-E2F5P1-DP12_GE2_RAF1-P130-E2F5P1-DP12-GE2
:parameters ()
:precondition
(and
(available_ge2)
(available_raf1-p130-e2f5p1-dp12)
)
:effect
(and
(available_raf1-p130-e2f5p1-dp12-ge2)
(not (available_raf1-p130-e2f5p1-dp12))
(not (available_ge2))
)
)
(:action ASSOCIATE_RAF1_P130-E2F5P1-DP12_RAF1-P130-E2F5P1-DP12
:parameters ()
:precondition
(and
(available_p130-e2f5p1-dp12)
(available_raf1)
)
:effect
(and
(available_raf1-p130-e2f5p1-dp12)
(not (available_raf1))
(not (available_p130-e2f5p1-dp12))
)
)
(:action ASSOCIATE_RAF1-PRB-E2F4P1-DP12_GE2_RAF1-PRB-E2F4P1-DP12-GE2
:parameters ()
:precondition
(and
(available_ge2)
(available_raf1-prb-e2f4p1-dp12)
)
:effect
(and
(available_raf1-prb-e2f4p1-dp12-ge2)
(not (available_raf1-prb-e2f4p1-dp12))
(not (available_ge2))
)
)
(:action ASSOCIATE_RAF1_PRB-E2F4P1-DP12_RAF1-PRB-E2F4P1-DP12
:parameters ()
:precondition
(and
(available_prb-e2f4p1-dp12)
(available_raf1)
)
:effect
(and
(available_raf1-prb-e2f4p1-dp12)
(not (available_raf1))
(not (available_prb-e2f4p1-dp12))
)
)
(:action ASSOCIATE_RAF1-PRBP1-E2F4P1-DP12_GE2_RAF1-PRBP1-E2F4P1-DP12-GE2
:parameters ()
:precondition
(and
(available_ge2)
(available_raf1-prbp1-e2f4p1-dp12)
)
:effect
(and
(available_raf1-prbp1-e2f4p1-dp12-ge2)
(not (available_raf1-prbp1-e2f4p1-dp12))
(not (available_ge2))
)
)
(:action ASSOCIATE_RAF1_PRBP1-E2F4P1-DP12_RAF1-PRBP1-E2F4P1-DP12
:parameters ()
:precondition
(and
(available_prbp1-e2f4p1-dp12)
(available_raf1)
)
:effect
(and
(available_raf1-prbp1-e2f4p1-dp12)
(not (available_raf1))
(not (available_prbp1-e2f4p1-dp12))
)
)
(:action ASSOCIATE_SKP2_SKP1_SKP2-SKP1
:parameters ()
:precondition
(and
(available_skp1)
(available_skp2)
)
:effect
(and
(available_skp2-skp1)
(not (available_skp2))
(not (available_skp1))
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
(:action INITIALIZE_APC
:parameters ()
:precondition
(and
(chosen_apc)
)
:effect
(and
(available_apc)
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
(:action INITIALIZE_DP12
:parameters ()
:precondition
(and
(chosen_dp12)
)
:effect
(and
(available_dp12)
)
)
(:action INITIALIZE_E2F1
:parameters ()
:precondition
(and
(chosen_e2f1)
)
:effect
(and
(available_e2f1)
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
(:action INITIALIZE_E2F13-DP12
:parameters ()
:precondition
(and
(chosen_e2f13-dp12)
)
:effect
(and
(available_e2f13-dp12)
)
)
(:action INITIALIZE_E2F13P1-DP12
:parameters ()
:precondition
(and
(chosen_e2f13p1-dp12)
)
:effect
(and
(available_e2f13p1-dp12)
)
)
(:action INITIALIZE_E2F3
:parameters ()
:precondition
(and
(chosen_e2f3)
)
:effect
(and
(available_e2f3)
)
)
(:action INITIALIZE_E2F4
:parameters ()
:precondition
(and
(chosen_e2f4)
)
:effect
(and
(available_e2f4)
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
(:action INITIALIZE_E2F5
:parameters ()
:precondition
(and
(chosen_e2f5)
)
:effect
(and
(available_e2f5)
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
(:action INITIALIZE_GCDC25A
:parameters ()
:precondition
(and
(chosen_gcdc25a)
)
:effect
(and
(available_gcdc25a)
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
(:action INITIALIZE_GP19ARF
:parameters ()
:precondition
(and
(chosen_gp19arf)
)
:effect
(and
(available_gp19arf)
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
(:action INITIALIZE_HDAC1-PRBP1-E2F13-DP12
:parameters ()
:precondition
(and
(chosen_hdac1-prbp1-e2f13-dp12)
)
:effect
(and
(available_hdac1-prbp1-e2f13-dp12)
)
)
(:action INITIALIZE_HDAC1-PRBP1-E2F13P1-DP12
:parameters ()
:precondition
(and
(chosen_hdac1-prbp1-e2f13p1-dp12)
)
:effect
(and
(available_hdac1-prbp1-e2f13p1-dp12)
)
)
(:action INITIALIZE_HDAC1-PRBP1-E2F4-DP12
:parameters ()
:precondition
(and
(chosen_hdac1-prbp1-e2f4-dp12)
)
:effect
(and
(available_hdac1-prbp1-e2f4-dp12)
)
)
(:action INITIALIZE_JUN
:parameters ()
:precondition
(and
(chosen_jun)
)
:effect
(and
(available_jun)
)
)
(:action INITIALIZE_MAX
:parameters ()
:precondition
(and
(chosen_max)
)
:effect
(and
(available_max)
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
(:action INITIALIZE_P130-E2F4P1-DP12
:parameters ()
:precondition
(and
(chosen_p130-e2f4p1-dp12)
)
:effect
(and
(available_p130-e2f4p1-dp12)
)
)
(:action INITIALIZE_P130-E2F5P1-DP12
:parameters ()
:precondition
(and
(chosen_p130-e2f5p1-dp12)
)
:effect
(and
(available_p130-e2f5p1-dp12)
)
)
(:action INITIALIZE_P27
:parameters ()
:precondition
(and
(chosen_p27)
)
:effect
(and
(available_p27)
)
)
(:action INITIALIZE_P57
:parameters ()
:precondition
(and
(chosen_p57)
)
:effect
(and
(available_p57)
)
)
(:action INITIALIZE_P57P1
:parameters ()
:precondition
(and
(chosen_p57p1)
)
:effect
(and
(available_p57p1)
)
)
(:action INITIALIZE_PLK1
:parameters ()
:precondition
(and
(chosen_plk1)
)
:effect
(and
(available_plk1)
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
(:action INITIALIZE_RAF1
:parameters ()
:precondition
(and
(chosen_raf1)
)
:effect
(and
(available_raf1)
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
(:action INITIALIZE_SKP1
:parameters ()
:precondition
(and
(chosen_skp1)
)
:effect
(and
(available_skp1)
)
)
(:action INITIALIZE_SKP2
:parameters ()
:precondition
(and
(chosen_skp2)
)
:effect
(and
(available_skp2)
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
(:action CHOOSE_APC_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_apc)
)
:effect
(and
(chosen_apc)
(num-subs_l1)
(not (not-chosen_apc))
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
(:action CHOOSE_DP12_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_dp12)
)
:effect
(and
(chosen_dp12)
(num-subs_l1)
(not (not-chosen_dp12))
(not (num-subs_l0))
)
)
(:action CHOOSE_E2F1_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_e2f1)
)
:effect
(and
(chosen_e2f1)
(num-subs_l1)
(not (not-chosen_e2f1))
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
(:action CHOOSE_E2F13-DP12_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_e2f13-dp12)
)
:effect
(and
(chosen_e2f13-dp12)
(num-subs_l1)
(not (not-chosen_e2f13-dp12))
(not (num-subs_l0))
)
)
(:action CHOOSE_E2F13P1-DP12_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_e2f13p1-dp12)
)
:effect
(and
(chosen_e2f13p1-dp12)
(num-subs_l1)
(not (not-chosen_e2f13p1-dp12))
(not (num-subs_l0))
)
)
(:action CHOOSE_E2F3_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_e2f3)
)
:effect
(and
(chosen_e2f3)
(num-subs_l1)
(not (not-chosen_e2f3))
(not (num-subs_l0))
)
)
(:action CHOOSE_E2F4_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_e2f4)
)
:effect
(and
(chosen_e2f4)
(num-subs_l1)
(not (not-chosen_e2f4))
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
(:action CHOOSE_E2F5_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_e2f5)
)
:effect
(and
(chosen_e2f5)
(num-subs_l1)
(not (not-chosen_e2f5))
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
(:action CHOOSE_GCDC25A_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_gcdc25a)
)
:effect
(and
(chosen_gcdc25a)
(num-subs_l1)
(not (not-chosen_gcdc25a))
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
(:action CHOOSE_GP19ARF_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_gp19arf)
)
:effect
(and
(chosen_gp19arf)
(num-subs_l1)
(not (not-chosen_gp19arf))
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
(:action CHOOSE_HDAC1-PRBP1-E2F13-DP12_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_hdac1-prbp1-e2f13-dp12)
)
:effect
(and
(chosen_hdac1-prbp1-e2f13-dp12)
(num-subs_l1)
(not (not-chosen_hdac1-prbp1-e2f13-dp12))
(not (num-subs_l0))
)
)
(:action CHOOSE_HDAC1-PRBP1-E2F13P1-DP12_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_hdac1-prbp1-e2f13p1-dp12)
)
:effect
(and
(chosen_hdac1-prbp1-e2f13p1-dp12)
(num-subs_l1)
(not (not-chosen_hdac1-prbp1-e2f13p1-dp12))
(not (num-subs_l0))
)
)
(:action CHOOSE_HDAC1-PRBP1-E2F4-DP12_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_hdac1-prbp1-e2f4-dp12)
)
:effect
(and
(chosen_hdac1-prbp1-e2f4-dp12)
(num-subs_l1)
(not (not-chosen_hdac1-prbp1-e2f4-dp12))
(not (num-subs_l0))
)
)
(:action CHOOSE_JUN_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_jun)
)
:effect
(and
(chosen_jun)
(num-subs_l1)
(not (not-chosen_jun))
(not (num-subs_l0))
)
)
(:action CHOOSE_MAX_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_max)
)
:effect
(and
(chosen_max)
(num-subs_l1)
(not (not-chosen_max))
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
(:action CHOOSE_P130-E2F4P1-DP12_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_p130-e2f4p1-dp12)
)
:effect
(and
(chosen_p130-e2f4p1-dp12)
(num-subs_l1)
(not (not-chosen_p130-e2f4p1-dp12))
(not (num-subs_l0))
)
)
(:action CHOOSE_P130-E2F5P1-DP12_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_p130-e2f5p1-dp12)
)
:effect
(and
(chosen_p130-e2f5p1-dp12)
(num-subs_l1)
(not (not-chosen_p130-e2f5p1-dp12))
(not (num-subs_l0))
)
)
(:action CHOOSE_P27_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_p27)
)
:effect
(and
(chosen_p27)
(num-subs_l1)
(not (not-chosen_p27))
(not (num-subs_l0))
)
)
(:action CHOOSE_P57_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_p57)
)
:effect
(and
(chosen_p57)
(num-subs_l1)
(not (not-chosen_p57))
(not (num-subs_l0))
)
)
(:action CHOOSE_P57P1_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_p57p1)
)
:effect
(and
(chosen_p57p1)
(num-subs_l1)
(not (not-chosen_p57p1))
(not (num-subs_l0))
)
)
(:action CHOOSE_PLK1_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_plk1)
)
:effect
(and
(chosen_plk1)
(num-subs_l1)
(not (not-chosen_plk1))
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
(:action CHOOSE_RAF1_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_raf1)
)
:effect
(and
(chosen_raf1)
(num-subs_l1)
(not (not-chosen_raf1))
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
(:action CHOOSE_SKP1_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_skp1)
)
:effect
(and
(chosen_skp1)
(num-subs_l1)
(not (not-chosen_skp1))
(not (num-subs_l0))
)
)
(:action CHOOSE_SKP2_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_skp2)
)
:effect
(and
(chosen_skp2)
(num-subs_l1)
(not (not-chosen_skp2))
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
)
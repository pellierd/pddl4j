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
(chosen_skp2)
(chosen_rpa)
(chosen_prb-e2f4p1-dp12)
(chosen_prb)
(chosen_plk1)
(chosen_p57)
(chosen_p53p1)
(chosen_p53)
(chosen_p27)
(chosen_max)
(chosen_m1433)
(chosen_jun)
(chosen_hdac1-prbp1-e2f13p1-dp12)
(chosen_hdac1-prbp1-e2f13-dp12)
(chosen_hdac1-p130-e2f4p1-dp12)
(chosen_hdac1-p107-e2f4p1-dp12)
(chosen_hdac1)
(chosen_gp19arf)
(chosen_gercc1)
(chosen_ge-c)
(chosen_ge2)
(chosen_e2f13p1-dp12p1)
(chosen_e2f13p1-dp12)
(chosen_e2f13-dp12p1)
(chosen_e2f13-dp12)
(chosen_e2f13)
(chosen_dmp1)
(chosen_cych)
(chosen_cycb)
(chosen_c-tak1)
(chosen_cks1)
(chosen_chk1)
(chosen_cdk7)
(chosen_cdk46p3-cycdp1)
(chosen_cdk2p2-cycb)
(chosen_cdk2p1)
(chosen_cdk1p1p2)
(chosen_cdc25c)
(chosen_c-abl)
(chosen_apc)
(chosen_ap2)
(available_wee1)
(available_sp1)
(available_skp2)
(available_rpa)
(available_prb-e2f4p1-dp12)
(available_prb)
(available_plk1)
(available_p57)
(available_p53p1)
(available_p53)
(available_p27)
(available_max)
(available_m1433)
(available_jun)
(available_hdac1-prbp1-e2f13p1-dp12)
(available_hdac1-prbp1-e2f13-dp12)
(available_hdac1-p130-e2f4p1-dp12)
(available_hdac1-p107-e2f4p1-dp12)
(available_hdac1)
(available_gp19arf)
(available_gercc1)
(available_ge-c)
(available_ge2)
(available_e2f13p1-dp12p1)
(available_e2f13p1-dp12)
(available_e2f13-dp12p1)
(available_e2f13-dp12)
(available_e2f13)
(available_dmp1)
(available_cych)
(available_cycb)
(available_c-tak1)
(available_cks1)
(available_chk1)
(available_cdk7)
(available_cdk46p3-cycdp1)
(available_cdk2p2-cycb)
(available_cdk2p1)
(available_cdk1p1p2)
(available_cdc25c)
(available_c-abl)
(available_apc)
(available_ap2)
(available_sp1-e2f13)
(available_prb-jun)
(available_prb-e2f4p1-dp12-ge2)
(available_prb-e2f13p1-dp12)
(available_prb-e2f13p1-dp12p1)
(available_prb-e2f13p1-dp12p1-ge2)
(available_prb-e2f13p1-dp12-ge2)
(available_prb-e2f13-dp12)
(available_prb-e2f13-dp12p1)
(available_prb-e2f13-dp12p1-ge2)
(available_prb-e2f13-dp12-ge2)
(available_prb-ap2)
(available_prb-ap2-ge-c)
(available_hdac1-prbp1-e2f13p1-dp12-ge2)
(available_hdac1-prbp1-e2f13-dp12-ge2)
(available_hdac1-prb-e2f4p1-dp12)
(available_hdac1-prb-e2f13p1-dp12p1)
(available_hdac1-prb-e2f13p1-dp12)
(available_hdac1-prb-e2f13p1-dp12-ge2)
(available_hdac1-prb-e2f13-dp12p1)
(available_hdac1-prb-e2f13-dp12)
(available_hdac1-prb-e2f13-dp12-ge2)
(available_hdac1-p130-e2f4p1-dp12-ge2)
(available_hdac1-p107-e2f4p1-dp12-ge2)
(available_e2f13p1-dp12-ge2)
(available_e2f13-dp12-ge2)
(available_dmp1-gp19arf)
(available_cdk7-cych)
(available_cdk2p1-cks1)
(available_cdk1p1p2-cks1)
(available_c-abl-prb)
(available_ap2-ge-c)
(available_prbp1)
(available_dmp1p1)
(available_apcp1)
(available_cdk7p1-cych)
(available_cdk7p1)
(available_cdk2p1p2-cycb)
(available_cdk2p1p2)
(available_cdk1p1p2p3)
(available_cdc25cp1)
(available_cdc25cp1p2)
(available_cdc25cp2)
(available_ecadherin)
(available_p21)
(available_mdm2)
(available_gadd45)
(available_c-fos)
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
(goal17_)
(num-subs_l2)
(available_sp1-p107)
(available_sp1-p107p1)
(available_rpa-cyca)
(available_prbp1-jun)
(available_prbp1-jun-c-fos)
(available_prbp1-jun-c-fos-gercc1)
(available_prbp1-e2f13p1-dp12)
(available_prbp1-e2f13p1-dp12p1)
(available_prbp1-e2f13p1-dp12p1-ge2)
(available_prbp1-e2f13p1-dp12-ge2)
(available_prbp1-e2f13-dp12)
(available_prbp1-e2f13-dp12p1)
(available_prbp1-e2f13-dp12p1-ge2)
(available_prbp1-e2f13-dp12-ge2)
(available_prbp1-ap2)
(available_prbp1-ap2-ge-c)
(available_prb-jun-c-fos)
(available_prb-jun-c-fos-gercc1)
(available_p21-gadd45)
(available_mdm2-prbp1)
(available_mdm2-prb)
(available_mdm2-e2f13p1-dp12p1)
(available_mdm2-e2f13p1-dp12)
(available_mdm2-e2f13-dp12p1)
(available_mdm2-e2f13-dp12)
(available_m1433-cdc25cp2)
(available_m1433-cdc25cp1p2)
(available_jun-c-fos)
(available_jun-c-fos-gercc1)
(available_dmp1p1-gp19arf)
(available_dmp1p1-cycdp1)
(available_dmp1p1-cycd)
(available_dmp1-cycdp1)
(available_dmp1-cycd)
(available_c-myc-max)
(available_c-myc-ap2)
(available_cdk2p1p2-cycep1)
(available_cdk2p1p2-cyce)
(available_cdk2p1p2-cyca)
(available_cdk2p1p2-cks1)
(available_cdk2p1-cycep1)
(available_cdk2p1-cyce)
(available_cdk2p1-cyca)
(available_cdk1p1p2p3-gadd45)
(available_cdk1p1p2p3-cycb)
(available_cdk1p1p2p3-cyca)
(available_cdk1p1p2p3-cks1)
(available_cdk1p1p2-gadd45)
(available_c-abl-prbp1)
(available_cdk1p2p3-cycb)
(available_cdk1p1p3-cycb)
(available_cdk1p2p3-cyca)
(available_cdk1p1p3-cyca)
(available_cdk1p2p3)
(available_cdk1p1p3)
(available_cdk1p2)
(available_cdk1p1)
(available_cdk1)
(available_cdk1p3)
(available_ercc1)
(goal5_)
(goal6_)
(goal7_)
(goal8_)
(goal9_)
(goal10_)
(goal11_)
(goal12_)
(goal14_)
(goal18_)
(num-subs_l3)
(available_skp2-cdk2p1p2-cyca)
(available_skp2-cdk2p1-cyca)
(available_p57-cdk2p1p2-cyce)
(available_p57-cdk2p1p2-cycep1)
(available_p57-cdk2p1p2-cyca)
(available_p57-cdk2p1-cyce)
(available_p57-cdk2p1-cycep1)
(available_p57-cdk2p1-cyca)
(available_p27-cdk2p1p2-cyce)
(available_p27-cdk2p1p2-cycep1)
(available_p27-cdk2p1p2-cyca)
(available_p27-cdk2p1-cyce)
(available_p27-cdk2p1-cycep1)
(available_p27-cdk2p1-cyca)
(available_p21-cdk2p1p2-cyce)
(available_p21-cdk2p1p2-cycep1)
(available_p21-cdk2p1p2-cyca)
(available_p21-cdk2p1-cyce)
(available_p21-cdk2p1-cycep1)
(available_p21-cdk2p1-cyca)
(available_cdk2p1p2-cyca-e2f13)
(available_cdk2p1-cyca-e2f13)
(available_cdk1p3-gadd45)
(available_cdk1p3-cycb)
(available_cdk1p3-cyca)
(available_cdk1p3-cks1)
(available_cdk1p2p3-gadd45)
(available_cdk1p2p3-cks1)
(available_cdk1p2-gadd45)
(available_cdk1p2-cks1)
(available_cdk1p1p3-gadd45)
(available_cdk1p1p3-cks1)
(available_cdk1p1-gadd45)
(available_cdk1p1-cks1)
(available_cdk1-gadd45)
(available_cdk1-cks1)
(available_wee1p1)
(goal1_)
(goal2_)
(goal3_)
(goal4_)
(goal13_)
(goal15_)
(goal16_)
(num-subs_l4)
(num-subs_l5)
(num-subs_l6)
(num-subs_l7)
(num-subs_l8)
(num-subs_l9)
(num-subs_l10)
(num-subs_l11)
(num-subs_l12)
(num-subs_l13)
(num-subs_l14)
(num-subs_l15)
(num-subs_l16)
(num-subs_l17)
(num-subs_l18)
(not-chosen_ap2)
(not-chosen_apc)
(not-chosen_c-abl)
(not-chosen_cdc25c)
(not-chosen_cdk1p1p2)
(not-chosen_cdk2p1)
(not-chosen_cdk2p2-cycb)
(not-chosen_cdk46p3-cycdp1)
(not-chosen_cdk7)
(not-chosen_chk1)
(not-chosen_cks1)
(not-chosen_c-tak1)
(not-chosen_cycb)
(not-chosen_cych)
(not-chosen_dmp1)
(not-chosen_e2f13)
(not-chosen_e2f13-dp12)
(not-chosen_e2f13-dp12p1)
(not-chosen_e2f13p1-dp12)
(not-chosen_e2f13p1-dp12p1)
(not-chosen_ge2)
(not-chosen_ge-c)
(not-chosen_gercc1)
(not-chosen_gp19arf)
(not-chosen_hdac1)
(not-chosen_hdac1-p107-e2f4p1-dp12)
(not-chosen_hdac1-p130-e2f4p1-dp12)
(not-chosen_hdac1-prbp1-e2f13-dp12)
(not-chosen_hdac1-prbp1-e2f13p1-dp12)
(not-chosen_jun)
(not-chosen_m1433)
(not-chosen_max)
(not-chosen_p27)
(not-chosen_p53)
(not-chosen_p53p1)
(not-chosen_p57)
(not-chosen_plk1)
(not-chosen_prb)
(not-chosen_prb-e2f4p1-dp12)
(not-chosen_rpa)
(not-chosen_skp2)
(not-chosen_sp1)
(not-chosen_wee1)
(num-subs_l0)
)
(:action CHOOSE_AP2_L18_L17
:parameters ()
:precondition
(and
(num-subs_l17)
(not-chosen_ap2)
)
:effect
(and
(chosen_ap2)
(num-subs_l18)
(not (not-chosen_ap2))
(not (num-subs_l17))
)
)
(:action CHOOSE_APC_L18_L17
:parameters ()
:precondition
(and
(num-subs_l17)
(not-chosen_apc)
)
:effect
(and
(chosen_apc)
(num-subs_l18)
(not (not-chosen_apc))
(not (num-subs_l17))
)
)
(:action CHOOSE_C-ABL_L18_L17
:parameters ()
:precondition
(and
(num-subs_l17)
(not-chosen_c-abl)
)
:effect
(and
(chosen_c-abl)
(num-subs_l18)
(not (not-chosen_c-abl))
(not (num-subs_l17))
)
)
(:action CHOOSE_CDC25C_L18_L17
:parameters ()
:precondition
(and
(num-subs_l17)
(not-chosen_cdc25c)
)
:effect
(and
(chosen_cdc25c)
(num-subs_l18)
(not (not-chosen_cdc25c))
(not (num-subs_l17))
)
)
(:action CHOOSE_CDK1P1P2_L18_L17
:parameters ()
:precondition
(and
(num-subs_l17)
(not-chosen_cdk1p1p2)
)
:effect
(and
(chosen_cdk1p1p2)
(num-subs_l18)
(not (not-chosen_cdk1p1p2))
(not (num-subs_l17))
)
)
(:action CHOOSE_CDK2P1_L18_L17
:parameters ()
:precondition
(and
(num-subs_l17)
(not-chosen_cdk2p1)
)
:effect
(and
(chosen_cdk2p1)
(num-subs_l18)
(not (not-chosen_cdk2p1))
(not (num-subs_l17))
)
)
(:action CHOOSE_CDK2P2-CYCB_L18_L17
:parameters ()
:precondition
(and
(num-subs_l17)
(not-chosen_cdk2p2-cycb)
)
:effect
(and
(chosen_cdk2p2-cycb)
(num-subs_l18)
(not (not-chosen_cdk2p2-cycb))
(not (num-subs_l17))
)
)
(:action CHOOSE_CDK46P3-CYCDP1_L18_L17
:parameters ()
:precondition
(and
(num-subs_l17)
(not-chosen_cdk46p3-cycdp1)
)
:effect
(and
(chosen_cdk46p3-cycdp1)
(num-subs_l18)
(not (not-chosen_cdk46p3-cycdp1))
(not (num-subs_l17))
)
)
(:action CHOOSE_CDK7_L18_L17
:parameters ()
:precondition
(and
(num-subs_l17)
(not-chosen_cdk7)
)
:effect
(and
(chosen_cdk7)
(num-subs_l18)
(not (not-chosen_cdk7))
(not (num-subs_l17))
)
)
(:action CHOOSE_CHK1_L18_L17
:parameters ()
:precondition
(and
(num-subs_l17)
(not-chosen_chk1)
)
:effect
(and
(chosen_chk1)
(num-subs_l18)
(not (not-chosen_chk1))
(not (num-subs_l17))
)
)
(:action CHOOSE_CKS1_L18_L17
:parameters ()
:precondition
(and
(num-subs_l17)
(not-chosen_cks1)
)
:effect
(and
(chosen_cks1)
(num-subs_l18)
(not (not-chosen_cks1))
(not (num-subs_l17))
)
)
(:action CHOOSE_C-TAK1_L18_L17
:parameters ()
:precondition
(and
(num-subs_l17)
(not-chosen_c-tak1)
)
:effect
(and
(chosen_c-tak1)
(num-subs_l18)
(not (not-chosen_c-tak1))
(not (num-subs_l17))
)
)
(:action CHOOSE_CYCB_L18_L17
:parameters ()
:precondition
(and
(num-subs_l17)
(not-chosen_cycb)
)
:effect
(and
(chosen_cycb)
(num-subs_l18)
(not (not-chosen_cycb))
(not (num-subs_l17))
)
)
(:action CHOOSE_CYCH_L18_L17
:parameters ()
:precondition
(and
(num-subs_l17)
(not-chosen_cych)
)
:effect
(and
(chosen_cych)
(num-subs_l18)
(not (not-chosen_cych))
(not (num-subs_l17))
)
)
(:action CHOOSE_DMP1_L18_L17
:parameters ()
:precondition
(and
(num-subs_l17)
(not-chosen_dmp1)
)
:effect
(and
(chosen_dmp1)
(num-subs_l18)
(not (not-chosen_dmp1))
(not (num-subs_l17))
)
)
(:action CHOOSE_E2F13_L18_L17
:parameters ()
:precondition
(and
(num-subs_l17)
(not-chosen_e2f13)
)
:effect
(and
(chosen_e2f13)
(num-subs_l18)
(not (not-chosen_e2f13))
(not (num-subs_l17))
)
)
(:action CHOOSE_E2F13-DP12_L18_L17
:parameters ()
:precondition
(and
(num-subs_l17)
(not-chosen_e2f13-dp12)
)
:effect
(and
(chosen_e2f13-dp12)
(num-subs_l18)
(not (not-chosen_e2f13-dp12))
(not (num-subs_l17))
)
)
(:action CHOOSE_E2F13-DP12P1_L18_L17
:parameters ()
:precondition
(and
(num-subs_l17)
(not-chosen_e2f13-dp12p1)
)
:effect
(and
(chosen_e2f13-dp12p1)
(num-subs_l18)
(not (not-chosen_e2f13-dp12p1))
(not (num-subs_l17))
)
)
(:action CHOOSE_E2F13P1-DP12_L18_L17
:parameters ()
:precondition
(and
(num-subs_l17)
(not-chosen_e2f13p1-dp12)
)
:effect
(and
(chosen_e2f13p1-dp12)
(num-subs_l18)
(not (not-chosen_e2f13p1-dp12))
(not (num-subs_l17))
)
)
(:action CHOOSE_E2F13P1-DP12P1_L18_L17
:parameters ()
:precondition
(and
(num-subs_l17)
(not-chosen_e2f13p1-dp12p1)
)
:effect
(and
(chosen_e2f13p1-dp12p1)
(num-subs_l18)
(not (not-chosen_e2f13p1-dp12p1))
(not (num-subs_l17))
)
)
(:action CHOOSE_GE2_L18_L17
:parameters ()
:precondition
(and
(num-subs_l17)
(not-chosen_ge2)
)
:effect
(and
(chosen_ge2)
(num-subs_l18)
(not (not-chosen_ge2))
(not (num-subs_l17))
)
)
(:action CHOOSE_GE-C_L18_L17
:parameters ()
:precondition
(and
(num-subs_l17)
(not-chosen_ge-c)
)
:effect
(and
(chosen_ge-c)
(num-subs_l18)
(not (not-chosen_ge-c))
(not (num-subs_l17))
)
)
(:action CHOOSE_GERCC1_L18_L17
:parameters ()
:precondition
(and
(num-subs_l17)
(not-chosen_gercc1)
)
:effect
(and
(chosen_gercc1)
(num-subs_l18)
(not (not-chosen_gercc1))
(not (num-subs_l17))
)
)
(:action CHOOSE_GP19ARF_L18_L17
:parameters ()
:precondition
(and
(num-subs_l17)
(not-chosen_gp19arf)
)
:effect
(and
(chosen_gp19arf)
(num-subs_l18)
(not (not-chosen_gp19arf))
(not (num-subs_l17))
)
)
(:action CHOOSE_HDAC1_L18_L17
:parameters ()
:precondition
(and
(num-subs_l17)
(not-chosen_hdac1)
)
:effect
(and
(chosen_hdac1)
(num-subs_l18)
(not (not-chosen_hdac1))
(not (num-subs_l17))
)
)
(:action CHOOSE_HDAC1-P107-E2F4P1-DP12_L18_L17
:parameters ()
:precondition
(and
(num-subs_l17)
(not-chosen_hdac1-p107-e2f4p1-dp12)
)
:effect
(and
(chosen_hdac1-p107-e2f4p1-dp12)
(num-subs_l18)
(not (not-chosen_hdac1-p107-e2f4p1-dp12))
(not (num-subs_l17))
)
)
(:action CHOOSE_HDAC1-P130-E2F4P1-DP12_L18_L17
:parameters ()
:precondition
(and
(num-subs_l17)
(not-chosen_hdac1-p130-e2f4p1-dp12)
)
:effect
(and
(chosen_hdac1-p130-e2f4p1-dp12)
(num-subs_l18)
(not (not-chosen_hdac1-p130-e2f4p1-dp12))
(not (num-subs_l17))
)
)
(:action CHOOSE_HDAC1-PRBP1-E2F13-DP12_L18_L17
:parameters ()
:precondition
(and
(num-subs_l17)
(not-chosen_hdac1-prbp1-e2f13-dp12)
)
:effect
(and
(chosen_hdac1-prbp1-e2f13-dp12)
(num-subs_l18)
(not (not-chosen_hdac1-prbp1-e2f13-dp12))
(not (num-subs_l17))
)
)
(:action CHOOSE_HDAC1-PRBP1-E2F13P1-DP12_L18_L17
:parameters ()
:precondition
(and
(num-subs_l17)
(not-chosen_hdac1-prbp1-e2f13p1-dp12)
)
:effect
(and
(chosen_hdac1-prbp1-e2f13p1-dp12)
(num-subs_l18)
(not (not-chosen_hdac1-prbp1-e2f13p1-dp12))
(not (num-subs_l17))
)
)
(:action CHOOSE_JUN_L18_L17
:parameters ()
:precondition
(and
(num-subs_l17)
(not-chosen_jun)
)
:effect
(and
(chosen_jun)
(num-subs_l18)
(not (not-chosen_jun))
(not (num-subs_l17))
)
)
(:action CHOOSE_M1433_L18_L17
:parameters ()
:precondition
(and
(num-subs_l17)
(not-chosen_m1433)
)
:effect
(and
(chosen_m1433)
(num-subs_l18)
(not (not-chosen_m1433))
(not (num-subs_l17))
)
)
(:action CHOOSE_MAX_L18_L17
:parameters ()
:precondition
(and
(num-subs_l17)
(not-chosen_max)
)
:effect
(and
(chosen_max)
(num-subs_l18)
(not (not-chosen_max))
(not (num-subs_l17))
)
)
(:action CHOOSE_P27_L18_L17
:parameters ()
:precondition
(and
(num-subs_l17)
(not-chosen_p27)
)
:effect
(and
(chosen_p27)
(num-subs_l18)
(not (not-chosen_p27))
(not (num-subs_l17))
)
)
(:action CHOOSE_P53_L18_L17
:parameters ()
:precondition
(and
(num-subs_l17)
(not-chosen_p53)
)
:effect
(and
(chosen_p53)
(num-subs_l18)
(not (not-chosen_p53))
(not (num-subs_l17))
)
)
(:action CHOOSE_P53P1_L18_L17
:parameters ()
:precondition
(and
(num-subs_l17)
(not-chosen_p53p1)
)
:effect
(and
(chosen_p53p1)
(num-subs_l18)
(not (not-chosen_p53p1))
(not (num-subs_l17))
)
)
(:action CHOOSE_P57_L18_L17
:parameters ()
:precondition
(and
(num-subs_l17)
(not-chosen_p57)
)
:effect
(and
(chosen_p57)
(num-subs_l18)
(not (not-chosen_p57))
(not (num-subs_l17))
)
)
(:action CHOOSE_PLK1_L18_L17
:parameters ()
:precondition
(and
(num-subs_l17)
(not-chosen_plk1)
)
:effect
(and
(chosen_plk1)
(num-subs_l18)
(not (not-chosen_plk1))
(not (num-subs_l17))
)
)
(:action CHOOSE_PRB_L18_L17
:parameters ()
:precondition
(and
(num-subs_l17)
(not-chosen_prb)
)
:effect
(and
(chosen_prb)
(num-subs_l18)
(not (not-chosen_prb))
(not (num-subs_l17))
)
)
(:action CHOOSE_PRB-E2F4P1-DP12_L18_L17
:parameters ()
:precondition
(and
(num-subs_l17)
(not-chosen_prb-e2f4p1-dp12)
)
:effect
(and
(chosen_prb-e2f4p1-dp12)
(num-subs_l18)
(not (not-chosen_prb-e2f4p1-dp12))
(not (num-subs_l17))
)
)
(:action CHOOSE_RPA_L18_L17
:parameters ()
:precondition
(and
(num-subs_l17)
(not-chosen_rpa)
)
:effect
(and
(chosen_rpa)
(num-subs_l18)
(not (not-chosen_rpa))
(not (num-subs_l17))
)
)
(:action CHOOSE_SKP2_L18_L17
:parameters ()
:precondition
(and
(num-subs_l17)
(not-chosen_skp2)
)
:effect
(and
(chosen_skp2)
(num-subs_l18)
(not (not-chosen_skp2))
(not (num-subs_l17))
)
)
(:action CHOOSE_SP1_L18_L17
:parameters ()
:precondition
(and
(num-subs_l17)
(not-chosen_sp1)
)
:effect
(and
(chosen_sp1)
(num-subs_l18)
(not (not-chosen_sp1))
(not (num-subs_l17))
)
)
(:action CHOOSE_WEE1_L18_L17
:parameters ()
:precondition
(and
(num-subs_l17)
(not-chosen_wee1)
)
:effect
(and
(chosen_wee1)
(num-subs_l18)
(not (not-chosen_wee1))
(not (num-subs_l17))
)
)
(:action CHOOSE_AP2_L17_L16
:parameters ()
:precondition
(and
(num-subs_l16)
(not-chosen_ap2)
)
:effect
(and
(chosen_ap2)
(num-subs_l17)
(not (not-chosen_ap2))
(not (num-subs_l16))
)
)
(:action CHOOSE_APC_L17_L16
:parameters ()
:precondition
(and
(num-subs_l16)
(not-chosen_apc)
)
:effect
(and
(chosen_apc)
(num-subs_l17)
(not (not-chosen_apc))
(not (num-subs_l16))
)
)
(:action CHOOSE_C-ABL_L17_L16
:parameters ()
:precondition
(and
(num-subs_l16)
(not-chosen_c-abl)
)
:effect
(and
(chosen_c-abl)
(num-subs_l17)
(not (not-chosen_c-abl))
(not (num-subs_l16))
)
)
(:action CHOOSE_CDC25C_L17_L16
:parameters ()
:precondition
(and
(num-subs_l16)
(not-chosen_cdc25c)
)
:effect
(and
(chosen_cdc25c)
(num-subs_l17)
(not (not-chosen_cdc25c))
(not (num-subs_l16))
)
)
(:action CHOOSE_CDK1P1P2_L17_L16
:parameters ()
:precondition
(and
(num-subs_l16)
(not-chosen_cdk1p1p2)
)
:effect
(and
(chosen_cdk1p1p2)
(num-subs_l17)
(not (not-chosen_cdk1p1p2))
(not (num-subs_l16))
)
)
(:action CHOOSE_CDK2P1_L17_L16
:parameters ()
:precondition
(and
(num-subs_l16)
(not-chosen_cdk2p1)
)
:effect
(and
(chosen_cdk2p1)
(num-subs_l17)
(not (not-chosen_cdk2p1))
(not (num-subs_l16))
)
)
(:action CHOOSE_CDK2P2-CYCB_L17_L16
:parameters ()
:precondition
(and
(num-subs_l16)
(not-chosen_cdk2p2-cycb)
)
:effect
(and
(chosen_cdk2p2-cycb)
(num-subs_l17)
(not (not-chosen_cdk2p2-cycb))
(not (num-subs_l16))
)
)
(:action CHOOSE_CDK46P3-CYCDP1_L17_L16
:parameters ()
:precondition
(and
(num-subs_l16)
(not-chosen_cdk46p3-cycdp1)
)
:effect
(and
(chosen_cdk46p3-cycdp1)
(num-subs_l17)
(not (not-chosen_cdk46p3-cycdp1))
(not (num-subs_l16))
)
)
(:action CHOOSE_CDK7_L17_L16
:parameters ()
:precondition
(and
(num-subs_l16)
(not-chosen_cdk7)
)
:effect
(and
(chosen_cdk7)
(num-subs_l17)
(not (not-chosen_cdk7))
(not (num-subs_l16))
)
)
(:action CHOOSE_CHK1_L17_L16
:parameters ()
:precondition
(and
(num-subs_l16)
(not-chosen_chk1)
)
:effect
(and
(chosen_chk1)
(num-subs_l17)
(not (not-chosen_chk1))
(not (num-subs_l16))
)
)
(:action CHOOSE_CKS1_L17_L16
:parameters ()
:precondition
(and
(num-subs_l16)
(not-chosen_cks1)
)
:effect
(and
(chosen_cks1)
(num-subs_l17)
(not (not-chosen_cks1))
(not (num-subs_l16))
)
)
(:action CHOOSE_C-TAK1_L17_L16
:parameters ()
:precondition
(and
(num-subs_l16)
(not-chosen_c-tak1)
)
:effect
(and
(chosen_c-tak1)
(num-subs_l17)
(not (not-chosen_c-tak1))
(not (num-subs_l16))
)
)
(:action CHOOSE_CYCB_L17_L16
:parameters ()
:precondition
(and
(num-subs_l16)
(not-chosen_cycb)
)
:effect
(and
(chosen_cycb)
(num-subs_l17)
(not (not-chosen_cycb))
(not (num-subs_l16))
)
)
(:action CHOOSE_CYCH_L17_L16
:parameters ()
:precondition
(and
(num-subs_l16)
(not-chosen_cych)
)
:effect
(and
(chosen_cych)
(num-subs_l17)
(not (not-chosen_cych))
(not (num-subs_l16))
)
)
(:action CHOOSE_DMP1_L17_L16
:parameters ()
:precondition
(and
(num-subs_l16)
(not-chosen_dmp1)
)
:effect
(and
(chosen_dmp1)
(num-subs_l17)
(not (not-chosen_dmp1))
(not (num-subs_l16))
)
)
(:action CHOOSE_E2F13_L17_L16
:parameters ()
:precondition
(and
(num-subs_l16)
(not-chosen_e2f13)
)
:effect
(and
(chosen_e2f13)
(num-subs_l17)
(not (not-chosen_e2f13))
(not (num-subs_l16))
)
)
(:action CHOOSE_E2F13-DP12_L17_L16
:parameters ()
:precondition
(and
(num-subs_l16)
(not-chosen_e2f13-dp12)
)
:effect
(and
(chosen_e2f13-dp12)
(num-subs_l17)
(not (not-chosen_e2f13-dp12))
(not (num-subs_l16))
)
)
(:action CHOOSE_E2F13-DP12P1_L17_L16
:parameters ()
:precondition
(and
(num-subs_l16)
(not-chosen_e2f13-dp12p1)
)
:effect
(and
(chosen_e2f13-dp12p1)
(num-subs_l17)
(not (not-chosen_e2f13-dp12p1))
(not (num-subs_l16))
)
)
(:action CHOOSE_E2F13P1-DP12_L17_L16
:parameters ()
:precondition
(and
(num-subs_l16)
(not-chosen_e2f13p1-dp12)
)
:effect
(and
(chosen_e2f13p1-dp12)
(num-subs_l17)
(not (not-chosen_e2f13p1-dp12))
(not (num-subs_l16))
)
)
(:action CHOOSE_E2F13P1-DP12P1_L17_L16
:parameters ()
:precondition
(and
(num-subs_l16)
(not-chosen_e2f13p1-dp12p1)
)
:effect
(and
(chosen_e2f13p1-dp12p1)
(num-subs_l17)
(not (not-chosen_e2f13p1-dp12p1))
(not (num-subs_l16))
)
)
(:action CHOOSE_GE2_L17_L16
:parameters ()
:precondition
(and
(num-subs_l16)
(not-chosen_ge2)
)
:effect
(and
(chosen_ge2)
(num-subs_l17)
(not (not-chosen_ge2))
(not (num-subs_l16))
)
)
(:action CHOOSE_GE-C_L17_L16
:parameters ()
:precondition
(and
(num-subs_l16)
(not-chosen_ge-c)
)
:effect
(and
(chosen_ge-c)
(num-subs_l17)
(not (not-chosen_ge-c))
(not (num-subs_l16))
)
)
(:action CHOOSE_GERCC1_L17_L16
:parameters ()
:precondition
(and
(num-subs_l16)
(not-chosen_gercc1)
)
:effect
(and
(chosen_gercc1)
(num-subs_l17)
(not (not-chosen_gercc1))
(not (num-subs_l16))
)
)
(:action CHOOSE_GP19ARF_L17_L16
:parameters ()
:precondition
(and
(num-subs_l16)
(not-chosen_gp19arf)
)
:effect
(and
(chosen_gp19arf)
(num-subs_l17)
(not (not-chosen_gp19arf))
(not (num-subs_l16))
)
)
(:action CHOOSE_HDAC1_L17_L16
:parameters ()
:precondition
(and
(num-subs_l16)
(not-chosen_hdac1)
)
:effect
(and
(chosen_hdac1)
(num-subs_l17)
(not (not-chosen_hdac1))
(not (num-subs_l16))
)
)
(:action CHOOSE_HDAC1-P107-E2F4P1-DP12_L17_L16
:parameters ()
:precondition
(and
(num-subs_l16)
(not-chosen_hdac1-p107-e2f4p1-dp12)
)
:effect
(and
(chosen_hdac1-p107-e2f4p1-dp12)
(num-subs_l17)
(not (not-chosen_hdac1-p107-e2f4p1-dp12))
(not (num-subs_l16))
)
)
(:action CHOOSE_HDAC1-P130-E2F4P1-DP12_L17_L16
:parameters ()
:precondition
(and
(num-subs_l16)
(not-chosen_hdac1-p130-e2f4p1-dp12)
)
:effect
(and
(chosen_hdac1-p130-e2f4p1-dp12)
(num-subs_l17)
(not (not-chosen_hdac1-p130-e2f4p1-dp12))
(not (num-subs_l16))
)
)
(:action CHOOSE_HDAC1-PRBP1-E2F13-DP12_L17_L16
:parameters ()
:precondition
(and
(num-subs_l16)
(not-chosen_hdac1-prbp1-e2f13-dp12)
)
:effect
(and
(chosen_hdac1-prbp1-e2f13-dp12)
(num-subs_l17)
(not (not-chosen_hdac1-prbp1-e2f13-dp12))
(not (num-subs_l16))
)
)
(:action CHOOSE_HDAC1-PRBP1-E2F13P1-DP12_L17_L16
:parameters ()
:precondition
(and
(num-subs_l16)
(not-chosen_hdac1-prbp1-e2f13p1-dp12)
)
:effect
(and
(chosen_hdac1-prbp1-e2f13p1-dp12)
(num-subs_l17)
(not (not-chosen_hdac1-prbp1-e2f13p1-dp12))
(not (num-subs_l16))
)
)
(:action CHOOSE_JUN_L17_L16
:parameters ()
:precondition
(and
(num-subs_l16)
(not-chosen_jun)
)
:effect
(and
(chosen_jun)
(num-subs_l17)
(not (not-chosen_jun))
(not (num-subs_l16))
)
)
(:action CHOOSE_M1433_L17_L16
:parameters ()
:precondition
(and
(num-subs_l16)
(not-chosen_m1433)
)
:effect
(and
(chosen_m1433)
(num-subs_l17)
(not (not-chosen_m1433))
(not (num-subs_l16))
)
)
(:action CHOOSE_MAX_L17_L16
:parameters ()
:precondition
(and
(num-subs_l16)
(not-chosen_max)
)
:effect
(and
(chosen_max)
(num-subs_l17)
(not (not-chosen_max))
(not (num-subs_l16))
)
)
(:action CHOOSE_P27_L17_L16
:parameters ()
:precondition
(and
(num-subs_l16)
(not-chosen_p27)
)
:effect
(and
(chosen_p27)
(num-subs_l17)
(not (not-chosen_p27))
(not (num-subs_l16))
)
)
(:action CHOOSE_P53_L17_L16
:parameters ()
:precondition
(and
(num-subs_l16)
(not-chosen_p53)
)
:effect
(and
(chosen_p53)
(num-subs_l17)
(not (not-chosen_p53))
(not (num-subs_l16))
)
)
(:action CHOOSE_P53P1_L17_L16
:parameters ()
:precondition
(and
(num-subs_l16)
(not-chosen_p53p1)
)
:effect
(and
(chosen_p53p1)
(num-subs_l17)
(not (not-chosen_p53p1))
(not (num-subs_l16))
)
)
(:action CHOOSE_P57_L17_L16
:parameters ()
:precondition
(and
(num-subs_l16)
(not-chosen_p57)
)
:effect
(and
(chosen_p57)
(num-subs_l17)
(not (not-chosen_p57))
(not (num-subs_l16))
)
)
(:action CHOOSE_PLK1_L17_L16
:parameters ()
:precondition
(and
(num-subs_l16)
(not-chosen_plk1)
)
:effect
(and
(chosen_plk1)
(num-subs_l17)
(not (not-chosen_plk1))
(not (num-subs_l16))
)
)
(:action CHOOSE_PRB_L17_L16
:parameters ()
:precondition
(and
(num-subs_l16)
(not-chosen_prb)
)
:effect
(and
(chosen_prb)
(num-subs_l17)
(not (not-chosen_prb))
(not (num-subs_l16))
)
)
(:action CHOOSE_PRB-E2F4P1-DP12_L17_L16
:parameters ()
:precondition
(and
(num-subs_l16)
(not-chosen_prb-e2f4p1-dp12)
)
:effect
(and
(chosen_prb-e2f4p1-dp12)
(num-subs_l17)
(not (not-chosen_prb-e2f4p1-dp12))
(not (num-subs_l16))
)
)
(:action CHOOSE_RPA_L17_L16
:parameters ()
:precondition
(and
(num-subs_l16)
(not-chosen_rpa)
)
:effect
(and
(chosen_rpa)
(num-subs_l17)
(not (not-chosen_rpa))
(not (num-subs_l16))
)
)
(:action CHOOSE_SKP2_L17_L16
:parameters ()
:precondition
(and
(num-subs_l16)
(not-chosen_skp2)
)
:effect
(and
(chosen_skp2)
(num-subs_l17)
(not (not-chosen_skp2))
(not (num-subs_l16))
)
)
(:action CHOOSE_SP1_L17_L16
:parameters ()
:precondition
(and
(num-subs_l16)
(not-chosen_sp1)
)
:effect
(and
(chosen_sp1)
(num-subs_l17)
(not (not-chosen_sp1))
(not (num-subs_l16))
)
)
(:action CHOOSE_WEE1_L17_L16
:parameters ()
:precondition
(and
(num-subs_l16)
(not-chosen_wee1)
)
:effect
(and
(chosen_wee1)
(num-subs_l17)
(not (not-chosen_wee1))
(not (num-subs_l16))
)
)
(:action CHOOSE_AP2_L16_L15
:parameters ()
:precondition
(and
(num-subs_l15)
(not-chosen_ap2)
)
:effect
(and
(chosen_ap2)
(num-subs_l16)
(not (not-chosen_ap2))
(not (num-subs_l15))
)
)
(:action CHOOSE_APC_L16_L15
:parameters ()
:precondition
(and
(num-subs_l15)
(not-chosen_apc)
)
:effect
(and
(chosen_apc)
(num-subs_l16)
(not (not-chosen_apc))
(not (num-subs_l15))
)
)
(:action CHOOSE_C-ABL_L16_L15
:parameters ()
:precondition
(and
(num-subs_l15)
(not-chosen_c-abl)
)
:effect
(and
(chosen_c-abl)
(num-subs_l16)
(not (not-chosen_c-abl))
(not (num-subs_l15))
)
)
(:action CHOOSE_CDC25C_L16_L15
:parameters ()
:precondition
(and
(num-subs_l15)
(not-chosen_cdc25c)
)
:effect
(and
(chosen_cdc25c)
(num-subs_l16)
(not (not-chosen_cdc25c))
(not (num-subs_l15))
)
)
(:action CHOOSE_CDK1P1P2_L16_L15
:parameters ()
:precondition
(and
(num-subs_l15)
(not-chosen_cdk1p1p2)
)
:effect
(and
(chosen_cdk1p1p2)
(num-subs_l16)
(not (not-chosen_cdk1p1p2))
(not (num-subs_l15))
)
)
(:action CHOOSE_CDK2P1_L16_L15
:parameters ()
:precondition
(and
(num-subs_l15)
(not-chosen_cdk2p1)
)
:effect
(and
(chosen_cdk2p1)
(num-subs_l16)
(not (not-chosen_cdk2p1))
(not (num-subs_l15))
)
)
(:action CHOOSE_CDK2P2-CYCB_L16_L15
:parameters ()
:precondition
(and
(num-subs_l15)
(not-chosen_cdk2p2-cycb)
)
:effect
(and
(chosen_cdk2p2-cycb)
(num-subs_l16)
(not (not-chosen_cdk2p2-cycb))
(not (num-subs_l15))
)
)
(:action CHOOSE_CDK46P3-CYCDP1_L16_L15
:parameters ()
:precondition
(and
(num-subs_l15)
(not-chosen_cdk46p3-cycdp1)
)
:effect
(and
(chosen_cdk46p3-cycdp1)
(num-subs_l16)
(not (not-chosen_cdk46p3-cycdp1))
(not (num-subs_l15))
)
)
(:action CHOOSE_CDK7_L16_L15
:parameters ()
:precondition
(and
(num-subs_l15)
(not-chosen_cdk7)
)
:effect
(and
(chosen_cdk7)
(num-subs_l16)
(not (not-chosen_cdk7))
(not (num-subs_l15))
)
)
(:action CHOOSE_CHK1_L16_L15
:parameters ()
:precondition
(and
(num-subs_l15)
(not-chosen_chk1)
)
:effect
(and
(chosen_chk1)
(num-subs_l16)
(not (not-chosen_chk1))
(not (num-subs_l15))
)
)
(:action CHOOSE_CKS1_L16_L15
:parameters ()
:precondition
(and
(num-subs_l15)
(not-chosen_cks1)
)
:effect
(and
(chosen_cks1)
(num-subs_l16)
(not (not-chosen_cks1))
(not (num-subs_l15))
)
)
(:action CHOOSE_C-TAK1_L16_L15
:parameters ()
:precondition
(and
(num-subs_l15)
(not-chosen_c-tak1)
)
:effect
(and
(chosen_c-tak1)
(num-subs_l16)
(not (not-chosen_c-tak1))
(not (num-subs_l15))
)
)
(:action CHOOSE_CYCB_L16_L15
:parameters ()
:precondition
(and
(num-subs_l15)
(not-chosen_cycb)
)
:effect
(and
(chosen_cycb)
(num-subs_l16)
(not (not-chosen_cycb))
(not (num-subs_l15))
)
)
(:action CHOOSE_CYCH_L16_L15
:parameters ()
:precondition
(and
(num-subs_l15)
(not-chosen_cych)
)
:effect
(and
(chosen_cych)
(num-subs_l16)
(not (not-chosen_cych))
(not (num-subs_l15))
)
)
(:action CHOOSE_DMP1_L16_L15
:parameters ()
:precondition
(and
(num-subs_l15)
(not-chosen_dmp1)
)
:effect
(and
(chosen_dmp1)
(num-subs_l16)
(not (not-chosen_dmp1))
(not (num-subs_l15))
)
)
(:action CHOOSE_E2F13_L16_L15
:parameters ()
:precondition
(and
(num-subs_l15)
(not-chosen_e2f13)
)
:effect
(and
(chosen_e2f13)
(num-subs_l16)
(not (not-chosen_e2f13))
(not (num-subs_l15))
)
)
(:action CHOOSE_E2F13-DP12_L16_L15
:parameters ()
:precondition
(and
(num-subs_l15)
(not-chosen_e2f13-dp12)
)
:effect
(and
(chosen_e2f13-dp12)
(num-subs_l16)
(not (not-chosen_e2f13-dp12))
(not (num-subs_l15))
)
)
(:action CHOOSE_E2F13-DP12P1_L16_L15
:parameters ()
:precondition
(and
(num-subs_l15)
(not-chosen_e2f13-dp12p1)
)
:effect
(and
(chosen_e2f13-dp12p1)
(num-subs_l16)
(not (not-chosen_e2f13-dp12p1))
(not (num-subs_l15))
)
)
(:action CHOOSE_E2F13P1-DP12_L16_L15
:parameters ()
:precondition
(and
(num-subs_l15)
(not-chosen_e2f13p1-dp12)
)
:effect
(and
(chosen_e2f13p1-dp12)
(num-subs_l16)
(not (not-chosen_e2f13p1-dp12))
(not (num-subs_l15))
)
)
(:action CHOOSE_E2F13P1-DP12P1_L16_L15
:parameters ()
:precondition
(and
(num-subs_l15)
(not-chosen_e2f13p1-dp12p1)
)
:effect
(and
(chosen_e2f13p1-dp12p1)
(num-subs_l16)
(not (not-chosen_e2f13p1-dp12p1))
(not (num-subs_l15))
)
)
(:action CHOOSE_GE2_L16_L15
:parameters ()
:precondition
(and
(num-subs_l15)
(not-chosen_ge2)
)
:effect
(and
(chosen_ge2)
(num-subs_l16)
(not (not-chosen_ge2))
(not (num-subs_l15))
)
)
(:action CHOOSE_GE-C_L16_L15
:parameters ()
:precondition
(and
(num-subs_l15)
(not-chosen_ge-c)
)
:effect
(and
(chosen_ge-c)
(num-subs_l16)
(not (not-chosen_ge-c))
(not (num-subs_l15))
)
)
(:action CHOOSE_GERCC1_L16_L15
:parameters ()
:precondition
(and
(num-subs_l15)
(not-chosen_gercc1)
)
:effect
(and
(chosen_gercc1)
(num-subs_l16)
(not (not-chosen_gercc1))
(not (num-subs_l15))
)
)
(:action CHOOSE_GP19ARF_L16_L15
:parameters ()
:precondition
(and
(num-subs_l15)
(not-chosen_gp19arf)
)
:effect
(and
(chosen_gp19arf)
(num-subs_l16)
(not (not-chosen_gp19arf))
(not (num-subs_l15))
)
)
(:action CHOOSE_HDAC1_L16_L15
:parameters ()
:precondition
(and
(num-subs_l15)
(not-chosen_hdac1)
)
:effect
(and
(chosen_hdac1)
(num-subs_l16)
(not (not-chosen_hdac1))
(not (num-subs_l15))
)
)
(:action CHOOSE_HDAC1-P107-E2F4P1-DP12_L16_L15
:parameters ()
:precondition
(and
(num-subs_l15)
(not-chosen_hdac1-p107-e2f4p1-dp12)
)
:effect
(and
(chosen_hdac1-p107-e2f4p1-dp12)
(num-subs_l16)
(not (not-chosen_hdac1-p107-e2f4p1-dp12))
(not (num-subs_l15))
)
)
(:action CHOOSE_HDAC1-P130-E2F4P1-DP12_L16_L15
:parameters ()
:precondition
(and
(num-subs_l15)
(not-chosen_hdac1-p130-e2f4p1-dp12)
)
:effect
(and
(chosen_hdac1-p130-e2f4p1-dp12)
(num-subs_l16)
(not (not-chosen_hdac1-p130-e2f4p1-dp12))
(not (num-subs_l15))
)
)
(:action CHOOSE_HDAC1-PRBP1-E2F13-DP12_L16_L15
:parameters ()
:precondition
(and
(num-subs_l15)
(not-chosen_hdac1-prbp1-e2f13-dp12)
)
:effect
(and
(chosen_hdac1-prbp1-e2f13-dp12)
(num-subs_l16)
(not (not-chosen_hdac1-prbp1-e2f13-dp12))
(not (num-subs_l15))
)
)
(:action CHOOSE_HDAC1-PRBP1-E2F13P1-DP12_L16_L15
:parameters ()
:precondition
(and
(num-subs_l15)
(not-chosen_hdac1-prbp1-e2f13p1-dp12)
)
:effect
(and
(chosen_hdac1-prbp1-e2f13p1-dp12)
(num-subs_l16)
(not (not-chosen_hdac1-prbp1-e2f13p1-dp12))
(not (num-subs_l15))
)
)
(:action CHOOSE_JUN_L16_L15
:parameters ()
:precondition
(and
(num-subs_l15)
(not-chosen_jun)
)
:effect
(and
(chosen_jun)
(num-subs_l16)
(not (not-chosen_jun))
(not (num-subs_l15))
)
)
(:action CHOOSE_M1433_L16_L15
:parameters ()
:precondition
(and
(num-subs_l15)
(not-chosen_m1433)
)
:effect
(and
(chosen_m1433)
(num-subs_l16)
(not (not-chosen_m1433))
(not (num-subs_l15))
)
)
(:action CHOOSE_MAX_L16_L15
:parameters ()
:precondition
(and
(num-subs_l15)
(not-chosen_max)
)
:effect
(and
(chosen_max)
(num-subs_l16)
(not (not-chosen_max))
(not (num-subs_l15))
)
)
(:action CHOOSE_P27_L16_L15
:parameters ()
:precondition
(and
(num-subs_l15)
(not-chosen_p27)
)
:effect
(and
(chosen_p27)
(num-subs_l16)
(not (not-chosen_p27))
(not (num-subs_l15))
)
)
(:action CHOOSE_P53_L16_L15
:parameters ()
:precondition
(and
(num-subs_l15)
(not-chosen_p53)
)
:effect
(and
(chosen_p53)
(num-subs_l16)
(not (not-chosen_p53))
(not (num-subs_l15))
)
)
(:action CHOOSE_P53P1_L16_L15
:parameters ()
:precondition
(and
(num-subs_l15)
(not-chosen_p53p1)
)
:effect
(and
(chosen_p53p1)
(num-subs_l16)
(not (not-chosen_p53p1))
(not (num-subs_l15))
)
)
(:action CHOOSE_P57_L16_L15
:parameters ()
:precondition
(and
(num-subs_l15)
(not-chosen_p57)
)
:effect
(and
(chosen_p57)
(num-subs_l16)
(not (not-chosen_p57))
(not (num-subs_l15))
)
)
(:action CHOOSE_PLK1_L16_L15
:parameters ()
:precondition
(and
(num-subs_l15)
(not-chosen_plk1)
)
:effect
(and
(chosen_plk1)
(num-subs_l16)
(not (not-chosen_plk1))
(not (num-subs_l15))
)
)
(:action CHOOSE_PRB_L16_L15
:parameters ()
:precondition
(and
(num-subs_l15)
(not-chosen_prb)
)
:effect
(and
(chosen_prb)
(num-subs_l16)
(not (not-chosen_prb))
(not (num-subs_l15))
)
)
(:action CHOOSE_PRB-E2F4P1-DP12_L16_L15
:parameters ()
:precondition
(and
(num-subs_l15)
(not-chosen_prb-e2f4p1-dp12)
)
:effect
(and
(chosen_prb-e2f4p1-dp12)
(num-subs_l16)
(not (not-chosen_prb-e2f4p1-dp12))
(not (num-subs_l15))
)
)
(:action CHOOSE_RPA_L16_L15
:parameters ()
:precondition
(and
(num-subs_l15)
(not-chosen_rpa)
)
:effect
(and
(chosen_rpa)
(num-subs_l16)
(not (not-chosen_rpa))
(not (num-subs_l15))
)
)
(:action CHOOSE_SKP2_L16_L15
:parameters ()
:precondition
(and
(num-subs_l15)
(not-chosen_skp2)
)
:effect
(and
(chosen_skp2)
(num-subs_l16)
(not (not-chosen_skp2))
(not (num-subs_l15))
)
)
(:action CHOOSE_SP1_L16_L15
:parameters ()
:precondition
(and
(num-subs_l15)
(not-chosen_sp1)
)
:effect
(and
(chosen_sp1)
(num-subs_l16)
(not (not-chosen_sp1))
(not (num-subs_l15))
)
)
(:action CHOOSE_WEE1_L16_L15
:parameters ()
:precondition
(and
(num-subs_l15)
(not-chosen_wee1)
)
:effect
(and
(chosen_wee1)
(num-subs_l16)
(not (not-chosen_wee1))
(not (num-subs_l15))
)
)
(:action CHOOSE_AP2_L15_L14
:parameters ()
:precondition
(and
(num-subs_l14)
(not-chosen_ap2)
)
:effect
(and
(chosen_ap2)
(num-subs_l15)
(not (not-chosen_ap2))
(not (num-subs_l14))
)
)
(:action CHOOSE_APC_L15_L14
:parameters ()
:precondition
(and
(num-subs_l14)
(not-chosen_apc)
)
:effect
(and
(chosen_apc)
(num-subs_l15)
(not (not-chosen_apc))
(not (num-subs_l14))
)
)
(:action CHOOSE_C-ABL_L15_L14
:parameters ()
:precondition
(and
(num-subs_l14)
(not-chosen_c-abl)
)
:effect
(and
(chosen_c-abl)
(num-subs_l15)
(not (not-chosen_c-abl))
(not (num-subs_l14))
)
)
(:action CHOOSE_CDC25C_L15_L14
:parameters ()
:precondition
(and
(num-subs_l14)
(not-chosen_cdc25c)
)
:effect
(and
(chosen_cdc25c)
(num-subs_l15)
(not (not-chosen_cdc25c))
(not (num-subs_l14))
)
)
(:action CHOOSE_CDK1P1P2_L15_L14
:parameters ()
:precondition
(and
(num-subs_l14)
(not-chosen_cdk1p1p2)
)
:effect
(and
(chosen_cdk1p1p2)
(num-subs_l15)
(not (not-chosen_cdk1p1p2))
(not (num-subs_l14))
)
)
(:action CHOOSE_CDK2P1_L15_L14
:parameters ()
:precondition
(and
(num-subs_l14)
(not-chosen_cdk2p1)
)
:effect
(and
(chosen_cdk2p1)
(num-subs_l15)
(not (not-chosen_cdk2p1))
(not (num-subs_l14))
)
)
(:action CHOOSE_CDK2P2-CYCB_L15_L14
:parameters ()
:precondition
(and
(num-subs_l14)
(not-chosen_cdk2p2-cycb)
)
:effect
(and
(chosen_cdk2p2-cycb)
(num-subs_l15)
(not (not-chosen_cdk2p2-cycb))
(not (num-subs_l14))
)
)
(:action CHOOSE_CDK46P3-CYCDP1_L15_L14
:parameters ()
:precondition
(and
(num-subs_l14)
(not-chosen_cdk46p3-cycdp1)
)
:effect
(and
(chosen_cdk46p3-cycdp1)
(num-subs_l15)
(not (not-chosen_cdk46p3-cycdp1))
(not (num-subs_l14))
)
)
(:action CHOOSE_CDK7_L15_L14
:parameters ()
:precondition
(and
(num-subs_l14)
(not-chosen_cdk7)
)
:effect
(and
(chosen_cdk7)
(num-subs_l15)
(not (not-chosen_cdk7))
(not (num-subs_l14))
)
)
(:action CHOOSE_CHK1_L15_L14
:parameters ()
:precondition
(and
(num-subs_l14)
(not-chosen_chk1)
)
:effect
(and
(chosen_chk1)
(num-subs_l15)
(not (not-chosen_chk1))
(not (num-subs_l14))
)
)
(:action CHOOSE_CKS1_L15_L14
:parameters ()
:precondition
(and
(num-subs_l14)
(not-chosen_cks1)
)
:effect
(and
(chosen_cks1)
(num-subs_l15)
(not (not-chosen_cks1))
(not (num-subs_l14))
)
)
(:action CHOOSE_C-TAK1_L15_L14
:parameters ()
:precondition
(and
(num-subs_l14)
(not-chosen_c-tak1)
)
:effect
(and
(chosen_c-tak1)
(num-subs_l15)
(not (not-chosen_c-tak1))
(not (num-subs_l14))
)
)
(:action CHOOSE_CYCB_L15_L14
:parameters ()
:precondition
(and
(num-subs_l14)
(not-chosen_cycb)
)
:effect
(and
(chosen_cycb)
(num-subs_l15)
(not (not-chosen_cycb))
(not (num-subs_l14))
)
)
(:action CHOOSE_CYCH_L15_L14
:parameters ()
:precondition
(and
(num-subs_l14)
(not-chosen_cych)
)
:effect
(and
(chosen_cych)
(num-subs_l15)
(not (not-chosen_cych))
(not (num-subs_l14))
)
)
(:action CHOOSE_DMP1_L15_L14
:parameters ()
:precondition
(and
(num-subs_l14)
(not-chosen_dmp1)
)
:effect
(and
(chosen_dmp1)
(num-subs_l15)
(not (not-chosen_dmp1))
(not (num-subs_l14))
)
)
(:action CHOOSE_E2F13_L15_L14
:parameters ()
:precondition
(and
(num-subs_l14)
(not-chosen_e2f13)
)
:effect
(and
(chosen_e2f13)
(num-subs_l15)
(not (not-chosen_e2f13))
(not (num-subs_l14))
)
)
(:action CHOOSE_E2F13-DP12_L15_L14
:parameters ()
:precondition
(and
(num-subs_l14)
(not-chosen_e2f13-dp12)
)
:effect
(and
(chosen_e2f13-dp12)
(num-subs_l15)
(not (not-chosen_e2f13-dp12))
(not (num-subs_l14))
)
)
(:action CHOOSE_E2F13-DP12P1_L15_L14
:parameters ()
:precondition
(and
(num-subs_l14)
(not-chosen_e2f13-dp12p1)
)
:effect
(and
(chosen_e2f13-dp12p1)
(num-subs_l15)
(not (not-chosen_e2f13-dp12p1))
(not (num-subs_l14))
)
)
(:action CHOOSE_E2F13P1-DP12_L15_L14
:parameters ()
:precondition
(and
(num-subs_l14)
(not-chosen_e2f13p1-dp12)
)
:effect
(and
(chosen_e2f13p1-dp12)
(num-subs_l15)
(not (not-chosen_e2f13p1-dp12))
(not (num-subs_l14))
)
)
(:action CHOOSE_E2F13P1-DP12P1_L15_L14
:parameters ()
:precondition
(and
(num-subs_l14)
(not-chosen_e2f13p1-dp12p1)
)
:effect
(and
(chosen_e2f13p1-dp12p1)
(num-subs_l15)
(not (not-chosen_e2f13p1-dp12p1))
(not (num-subs_l14))
)
)
(:action CHOOSE_GE2_L15_L14
:parameters ()
:precondition
(and
(num-subs_l14)
(not-chosen_ge2)
)
:effect
(and
(chosen_ge2)
(num-subs_l15)
(not (not-chosen_ge2))
(not (num-subs_l14))
)
)
(:action CHOOSE_GE-C_L15_L14
:parameters ()
:precondition
(and
(num-subs_l14)
(not-chosen_ge-c)
)
:effect
(and
(chosen_ge-c)
(num-subs_l15)
(not (not-chosen_ge-c))
(not (num-subs_l14))
)
)
(:action CHOOSE_GERCC1_L15_L14
:parameters ()
:precondition
(and
(num-subs_l14)
(not-chosen_gercc1)
)
:effect
(and
(chosen_gercc1)
(num-subs_l15)
(not (not-chosen_gercc1))
(not (num-subs_l14))
)
)
(:action CHOOSE_GP19ARF_L15_L14
:parameters ()
:precondition
(and
(num-subs_l14)
(not-chosen_gp19arf)
)
:effect
(and
(chosen_gp19arf)
(num-subs_l15)
(not (not-chosen_gp19arf))
(not (num-subs_l14))
)
)
(:action CHOOSE_HDAC1_L15_L14
:parameters ()
:precondition
(and
(num-subs_l14)
(not-chosen_hdac1)
)
:effect
(and
(chosen_hdac1)
(num-subs_l15)
(not (not-chosen_hdac1))
(not (num-subs_l14))
)
)
(:action CHOOSE_HDAC1-P107-E2F4P1-DP12_L15_L14
:parameters ()
:precondition
(and
(num-subs_l14)
(not-chosen_hdac1-p107-e2f4p1-dp12)
)
:effect
(and
(chosen_hdac1-p107-e2f4p1-dp12)
(num-subs_l15)
(not (not-chosen_hdac1-p107-e2f4p1-dp12))
(not (num-subs_l14))
)
)
(:action CHOOSE_HDAC1-P130-E2F4P1-DP12_L15_L14
:parameters ()
:precondition
(and
(num-subs_l14)
(not-chosen_hdac1-p130-e2f4p1-dp12)
)
:effect
(and
(chosen_hdac1-p130-e2f4p1-dp12)
(num-subs_l15)
(not (not-chosen_hdac1-p130-e2f4p1-dp12))
(not (num-subs_l14))
)
)
(:action CHOOSE_HDAC1-PRBP1-E2F13-DP12_L15_L14
:parameters ()
:precondition
(and
(num-subs_l14)
(not-chosen_hdac1-prbp1-e2f13-dp12)
)
:effect
(and
(chosen_hdac1-prbp1-e2f13-dp12)
(num-subs_l15)
(not (not-chosen_hdac1-prbp1-e2f13-dp12))
(not (num-subs_l14))
)
)
(:action CHOOSE_HDAC1-PRBP1-E2F13P1-DP12_L15_L14
:parameters ()
:precondition
(and
(num-subs_l14)
(not-chosen_hdac1-prbp1-e2f13p1-dp12)
)
:effect
(and
(chosen_hdac1-prbp1-e2f13p1-dp12)
(num-subs_l15)
(not (not-chosen_hdac1-prbp1-e2f13p1-dp12))
(not (num-subs_l14))
)
)
(:action CHOOSE_JUN_L15_L14
:parameters ()
:precondition
(and
(num-subs_l14)
(not-chosen_jun)
)
:effect
(and
(chosen_jun)
(num-subs_l15)
(not (not-chosen_jun))
(not (num-subs_l14))
)
)
(:action CHOOSE_M1433_L15_L14
:parameters ()
:precondition
(and
(num-subs_l14)
(not-chosen_m1433)
)
:effect
(and
(chosen_m1433)
(num-subs_l15)
(not (not-chosen_m1433))
(not (num-subs_l14))
)
)
(:action CHOOSE_MAX_L15_L14
:parameters ()
:precondition
(and
(num-subs_l14)
(not-chosen_max)
)
:effect
(and
(chosen_max)
(num-subs_l15)
(not (not-chosen_max))
(not (num-subs_l14))
)
)
(:action CHOOSE_P27_L15_L14
:parameters ()
:precondition
(and
(num-subs_l14)
(not-chosen_p27)
)
:effect
(and
(chosen_p27)
(num-subs_l15)
(not (not-chosen_p27))
(not (num-subs_l14))
)
)
(:action CHOOSE_P53_L15_L14
:parameters ()
:precondition
(and
(num-subs_l14)
(not-chosen_p53)
)
:effect
(and
(chosen_p53)
(num-subs_l15)
(not (not-chosen_p53))
(not (num-subs_l14))
)
)
(:action CHOOSE_P53P1_L15_L14
:parameters ()
:precondition
(and
(num-subs_l14)
(not-chosen_p53p1)
)
:effect
(and
(chosen_p53p1)
(num-subs_l15)
(not (not-chosen_p53p1))
(not (num-subs_l14))
)
)
(:action CHOOSE_P57_L15_L14
:parameters ()
:precondition
(and
(num-subs_l14)
(not-chosen_p57)
)
:effect
(and
(chosen_p57)
(num-subs_l15)
(not (not-chosen_p57))
(not (num-subs_l14))
)
)
(:action CHOOSE_PLK1_L15_L14
:parameters ()
:precondition
(and
(num-subs_l14)
(not-chosen_plk1)
)
:effect
(and
(chosen_plk1)
(num-subs_l15)
(not (not-chosen_plk1))
(not (num-subs_l14))
)
)
(:action CHOOSE_PRB_L15_L14
:parameters ()
:precondition
(and
(num-subs_l14)
(not-chosen_prb)
)
:effect
(and
(chosen_prb)
(num-subs_l15)
(not (not-chosen_prb))
(not (num-subs_l14))
)
)
(:action CHOOSE_PRB-E2F4P1-DP12_L15_L14
:parameters ()
:precondition
(and
(num-subs_l14)
(not-chosen_prb-e2f4p1-dp12)
)
:effect
(and
(chosen_prb-e2f4p1-dp12)
(num-subs_l15)
(not (not-chosen_prb-e2f4p1-dp12))
(not (num-subs_l14))
)
)
(:action CHOOSE_RPA_L15_L14
:parameters ()
:precondition
(and
(num-subs_l14)
(not-chosen_rpa)
)
:effect
(and
(chosen_rpa)
(num-subs_l15)
(not (not-chosen_rpa))
(not (num-subs_l14))
)
)
(:action CHOOSE_SKP2_L15_L14
:parameters ()
:precondition
(and
(num-subs_l14)
(not-chosen_skp2)
)
:effect
(and
(chosen_skp2)
(num-subs_l15)
(not (not-chosen_skp2))
(not (num-subs_l14))
)
)
(:action CHOOSE_SP1_L15_L14
:parameters ()
:precondition
(and
(num-subs_l14)
(not-chosen_sp1)
)
:effect
(and
(chosen_sp1)
(num-subs_l15)
(not (not-chosen_sp1))
(not (num-subs_l14))
)
)
(:action CHOOSE_WEE1_L15_L14
:parameters ()
:precondition
(and
(num-subs_l14)
(not-chosen_wee1)
)
:effect
(and
(chosen_wee1)
(num-subs_l15)
(not (not-chosen_wee1))
(not (num-subs_l14))
)
)
(:action CHOOSE_AP2_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_ap2)
)
:effect
(and
(chosen_ap2)
(num-subs_l14)
(not (not-chosen_ap2))
(not (num-subs_l13))
)
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
(:action CHOOSE_C-ABL_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_c-abl)
)
:effect
(and
(chosen_c-abl)
(num-subs_l14)
(not (not-chosen_c-abl))
(not (num-subs_l13))
)
)
(:action CHOOSE_CDC25C_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_cdc25c)
)
:effect
(and
(chosen_cdc25c)
(num-subs_l14)
(not (not-chosen_cdc25c))
(not (num-subs_l13))
)
)
(:action CHOOSE_CDK1P1P2_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_cdk1p1p2)
)
:effect
(and
(chosen_cdk1p1p2)
(num-subs_l14)
(not (not-chosen_cdk1p1p2))
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
(:action CHOOSE_CDK2P2-CYCB_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_cdk2p2-cycb)
)
:effect
(and
(chosen_cdk2p2-cycb)
(num-subs_l14)
(not (not-chosen_cdk2p2-cycb))
(not (num-subs_l13))
)
)
(:action CHOOSE_CDK46P3-CYCDP1_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_cdk46p3-cycdp1)
)
:effect
(and
(chosen_cdk46p3-cycdp1)
(num-subs_l14)
(not (not-chosen_cdk46p3-cycdp1))
(not (num-subs_l13))
)
)
(:action CHOOSE_CDK7_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_cdk7)
)
:effect
(and
(chosen_cdk7)
(num-subs_l14)
(not (not-chosen_cdk7))
(not (num-subs_l13))
)
)
(:action CHOOSE_CHK1_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_chk1)
)
:effect
(and
(chosen_chk1)
(num-subs_l14)
(not (not-chosen_chk1))
(not (num-subs_l13))
)
)
(:action CHOOSE_CKS1_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_cks1)
)
:effect
(and
(chosen_cks1)
(num-subs_l14)
(not (not-chosen_cks1))
(not (num-subs_l13))
)
)
(:action CHOOSE_C-TAK1_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_c-tak1)
)
:effect
(and
(chosen_c-tak1)
(num-subs_l14)
(not (not-chosen_c-tak1))
(not (num-subs_l13))
)
)
(:action CHOOSE_CYCB_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_cycb)
)
:effect
(and
(chosen_cycb)
(num-subs_l14)
(not (not-chosen_cycb))
(not (num-subs_l13))
)
)
(:action CHOOSE_CYCH_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_cych)
)
:effect
(and
(chosen_cych)
(num-subs_l14)
(not (not-chosen_cych))
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
(:action CHOOSE_E2F13-DP12P1_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_e2f13-dp12p1)
)
:effect
(and
(chosen_e2f13-dp12p1)
(num-subs_l14)
(not (not-chosen_e2f13-dp12p1))
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
(:action CHOOSE_E2F13P1-DP12P1_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_e2f13p1-dp12p1)
)
:effect
(and
(chosen_e2f13p1-dp12p1)
(num-subs_l14)
(not (not-chosen_e2f13p1-dp12p1))
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
(:action CHOOSE_GE-C_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_ge-c)
)
:effect
(and
(chosen_ge-c)
(num-subs_l14)
(not (not-chosen_ge-c))
(not (num-subs_l13))
)
)
(:action CHOOSE_GERCC1_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_gercc1)
)
:effect
(and
(chosen_gercc1)
(num-subs_l14)
(not (not-chosen_gercc1))
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
(:action CHOOSE_HDAC1-P107-E2F4P1-DP12_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_hdac1-p107-e2f4p1-dp12)
)
:effect
(and
(chosen_hdac1-p107-e2f4p1-dp12)
(num-subs_l14)
(not (not-chosen_hdac1-p107-e2f4p1-dp12))
(not (num-subs_l13))
)
)
(:action CHOOSE_HDAC1-P130-E2F4P1-DP12_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_hdac1-p130-e2f4p1-dp12)
)
:effect
(and
(chosen_hdac1-p130-e2f4p1-dp12)
(num-subs_l14)
(not (not-chosen_hdac1-p130-e2f4p1-dp12))
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
(:action CHOOSE_M1433_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_m1433)
)
:effect
(and
(chosen_m1433)
(num-subs_l14)
(not (not-chosen_m1433))
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
(:action CHOOSE_P53_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_p53)
)
:effect
(and
(chosen_p53)
(num-subs_l14)
(not (not-chosen_p53))
(not (num-subs_l13))
)
)
(:action CHOOSE_P53P1_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_p53p1)
)
:effect
(and
(chosen_p53p1)
(num-subs_l14)
(not (not-chosen_p53p1))
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
(:action CHOOSE_PRB_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_prb)
)
:effect
(and
(chosen_prb)
(num-subs_l14)
(not (not-chosen_prb))
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
(:action CHOOSE_WEE1_L14_L13
:parameters ()
:precondition
(and
(num-subs_l13)
(not-chosen_wee1)
)
:effect
(and
(chosen_wee1)
(num-subs_l14)
(not (not-chosen_wee1))
(not (num-subs_l13))
)
)
(:action CHOOSE_AP2_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_ap2)
)
:effect
(and
(chosen_ap2)
(num-subs_l13)
(not (not-chosen_ap2))
(not (num-subs_l12))
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
(:action CHOOSE_C-ABL_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_c-abl)
)
:effect
(and
(chosen_c-abl)
(num-subs_l13)
(not (not-chosen_c-abl))
(not (num-subs_l12))
)
)
(:action CHOOSE_CDC25C_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_cdc25c)
)
:effect
(and
(chosen_cdc25c)
(num-subs_l13)
(not (not-chosen_cdc25c))
(not (num-subs_l12))
)
)
(:action CHOOSE_CDK1P1P2_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_cdk1p1p2)
)
:effect
(and
(chosen_cdk1p1p2)
(num-subs_l13)
(not (not-chosen_cdk1p1p2))
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
(:action CHOOSE_CDK2P2-CYCB_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_cdk2p2-cycb)
)
:effect
(and
(chosen_cdk2p2-cycb)
(num-subs_l13)
(not (not-chosen_cdk2p2-cycb))
(not (num-subs_l12))
)
)
(:action CHOOSE_CDK46P3-CYCDP1_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_cdk46p3-cycdp1)
)
:effect
(and
(chosen_cdk46p3-cycdp1)
(num-subs_l13)
(not (not-chosen_cdk46p3-cycdp1))
(not (num-subs_l12))
)
)
(:action CHOOSE_CDK7_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_cdk7)
)
:effect
(and
(chosen_cdk7)
(num-subs_l13)
(not (not-chosen_cdk7))
(not (num-subs_l12))
)
)
(:action CHOOSE_CHK1_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_chk1)
)
:effect
(and
(chosen_chk1)
(num-subs_l13)
(not (not-chosen_chk1))
(not (num-subs_l12))
)
)
(:action CHOOSE_CKS1_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_cks1)
)
:effect
(and
(chosen_cks1)
(num-subs_l13)
(not (not-chosen_cks1))
(not (num-subs_l12))
)
)
(:action CHOOSE_C-TAK1_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_c-tak1)
)
:effect
(and
(chosen_c-tak1)
(num-subs_l13)
(not (not-chosen_c-tak1))
(not (num-subs_l12))
)
)
(:action CHOOSE_CYCB_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_cycb)
)
:effect
(and
(chosen_cycb)
(num-subs_l13)
(not (not-chosen_cycb))
(not (num-subs_l12))
)
)
(:action CHOOSE_CYCH_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_cych)
)
:effect
(and
(chosen_cych)
(num-subs_l13)
(not (not-chosen_cych))
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
(:action CHOOSE_E2F13-DP12P1_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_e2f13-dp12p1)
)
:effect
(and
(chosen_e2f13-dp12p1)
(num-subs_l13)
(not (not-chosen_e2f13-dp12p1))
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
(:action CHOOSE_E2F13P1-DP12P1_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_e2f13p1-dp12p1)
)
:effect
(and
(chosen_e2f13p1-dp12p1)
(num-subs_l13)
(not (not-chosen_e2f13p1-dp12p1))
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
(:action CHOOSE_GE-C_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_ge-c)
)
:effect
(and
(chosen_ge-c)
(num-subs_l13)
(not (not-chosen_ge-c))
(not (num-subs_l12))
)
)
(:action CHOOSE_GERCC1_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_gercc1)
)
:effect
(and
(chosen_gercc1)
(num-subs_l13)
(not (not-chosen_gercc1))
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
(:action CHOOSE_HDAC1-P107-E2F4P1-DP12_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_hdac1-p107-e2f4p1-dp12)
)
:effect
(and
(chosen_hdac1-p107-e2f4p1-dp12)
(num-subs_l13)
(not (not-chosen_hdac1-p107-e2f4p1-dp12))
(not (num-subs_l12))
)
)
(:action CHOOSE_HDAC1-P130-E2F4P1-DP12_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_hdac1-p130-e2f4p1-dp12)
)
:effect
(and
(chosen_hdac1-p130-e2f4p1-dp12)
(num-subs_l13)
(not (not-chosen_hdac1-p130-e2f4p1-dp12))
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
(:action CHOOSE_M1433_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_m1433)
)
:effect
(and
(chosen_m1433)
(num-subs_l13)
(not (not-chosen_m1433))
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
(:action CHOOSE_P53_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_p53)
)
:effect
(and
(chosen_p53)
(num-subs_l13)
(not (not-chosen_p53))
(not (num-subs_l12))
)
)
(:action CHOOSE_P53P1_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_p53p1)
)
:effect
(and
(chosen_p53p1)
(num-subs_l13)
(not (not-chosen_p53p1))
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
(:action CHOOSE_PRB_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_prb)
)
:effect
(and
(chosen_prb)
(num-subs_l13)
(not (not-chosen_prb))
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
(:action CHOOSE_WEE1_L13_L12
:parameters ()
:precondition
(and
(num-subs_l12)
(not-chosen_wee1)
)
:effect
(and
(chosen_wee1)
(num-subs_l13)
(not (not-chosen_wee1))
(not (num-subs_l12))
)
)
(:action CHOOSE_AP2_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_ap2)
)
:effect
(and
(chosen_ap2)
(num-subs_l12)
(not (not-chosen_ap2))
(not (num-subs_l11))
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
(:action CHOOSE_C-ABL_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_c-abl)
)
:effect
(and
(chosen_c-abl)
(num-subs_l12)
(not (not-chosen_c-abl))
(not (num-subs_l11))
)
)
(:action CHOOSE_CDC25C_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_cdc25c)
)
:effect
(and
(chosen_cdc25c)
(num-subs_l12)
(not (not-chosen_cdc25c))
(not (num-subs_l11))
)
)
(:action CHOOSE_CDK1P1P2_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_cdk1p1p2)
)
:effect
(and
(chosen_cdk1p1p2)
(num-subs_l12)
(not (not-chosen_cdk1p1p2))
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
(:action CHOOSE_CDK2P2-CYCB_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_cdk2p2-cycb)
)
:effect
(and
(chosen_cdk2p2-cycb)
(num-subs_l12)
(not (not-chosen_cdk2p2-cycb))
(not (num-subs_l11))
)
)
(:action CHOOSE_CDK46P3-CYCDP1_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_cdk46p3-cycdp1)
)
:effect
(and
(chosen_cdk46p3-cycdp1)
(num-subs_l12)
(not (not-chosen_cdk46p3-cycdp1))
(not (num-subs_l11))
)
)
(:action CHOOSE_CDK7_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_cdk7)
)
:effect
(and
(chosen_cdk7)
(num-subs_l12)
(not (not-chosen_cdk7))
(not (num-subs_l11))
)
)
(:action CHOOSE_CHK1_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_chk1)
)
:effect
(and
(chosen_chk1)
(num-subs_l12)
(not (not-chosen_chk1))
(not (num-subs_l11))
)
)
(:action CHOOSE_CKS1_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_cks1)
)
:effect
(and
(chosen_cks1)
(num-subs_l12)
(not (not-chosen_cks1))
(not (num-subs_l11))
)
)
(:action CHOOSE_C-TAK1_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_c-tak1)
)
:effect
(and
(chosen_c-tak1)
(num-subs_l12)
(not (not-chosen_c-tak1))
(not (num-subs_l11))
)
)
(:action CHOOSE_CYCB_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_cycb)
)
:effect
(and
(chosen_cycb)
(num-subs_l12)
(not (not-chosen_cycb))
(not (num-subs_l11))
)
)
(:action CHOOSE_CYCH_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_cych)
)
:effect
(and
(chosen_cych)
(num-subs_l12)
(not (not-chosen_cych))
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
(:action CHOOSE_E2F13-DP12P1_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_e2f13-dp12p1)
)
:effect
(and
(chosen_e2f13-dp12p1)
(num-subs_l12)
(not (not-chosen_e2f13-dp12p1))
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
(:action CHOOSE_E2F13P1-DP12P1_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_e2f13p1-dp12p1)
)
:effect
(and
(chosen_e2f13p1-dp12p1)
(num-subs_l12)
(not (not-chosen_e2f13p1-dp12p1))
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
(:action CHOOSE_GE-C_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_ge-c)
)
:effect
(and
(chosen_ge-c)
(num-subs_l12)
(not (not-chosen_ge-c))
(not (num-subs_l11))
)
)
(:action CHOOSE_GERCC1_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_gercc1)
)
:effect
(and
(chosen_gercc1)
(num-subs_l12)
(not (not-chosen_gercc1))
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
(:action CHOOSE_HDAC1-P107-E2F4P1-DP12_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_hdac1-p107-e2f4p1-dp12)
)
:effect
(and
(chosen_hdac1-p107-e2f4p1-dp12)
(num-subs_l12)
(not (not-chosen_hdac1-p107-e2f4p1-dp12))
(not (num-subs_l11))
)
)
(:action CHOOSE_HDAC1-P130-E2F4P1-DP12_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_hdac1-p130-e2f4p1-dp12)
)
:effect
(and
(chosen_hdac1-p130-e2f4p1-dp12)
(num-subs_l12)
(not (not-chosen_hdac1-p130-e2f4p1-dp12))
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
(:action CHOOSE_M1433_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_m1433)
)
:effect
(and
(chosen_m1433)
(num-subs_l12)
(not (not-chosen_m1433))
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
(:action CHOOSE_P53_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_p53)
)
:effect
(and
(chosen_p53)
(num-subs_l12)
(not (not-chosen_p53))
(not (num-subs_l11))
)
)
(:action CHOOSE_P53P1_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_p53p1)
)
:effect
(and
(chosen_p53p1)
(num-subs_l12)
(not (not-chosen_p53p1))
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
(:action CHOOSE_PRB_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_prb)
)
:effect
(and
(chosen_prb)
(num-subs_l12)
(not (not-chosen_prb))
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
(:action CHOOSE_WEE1_L12_L11
:parameters ()
:precondition
(and
(num-subs_l11)
(not-chosen_wee1)
)
:effect
(and
(chosen_wee1)
(num-subs_l12)
(not (not-chosen_wee1))
(not (num-subs_l11))
)
)
(:action CHOOSE_AP2_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_ap2)
)
:effect
(and
(chosen_ap2)
(num-subs_l11)
(not (not-chosen_ap2))
(not (num-subs_l10))
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
(:action CHOOSE_C-ABL_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_c-abl)
)
:effect
(and
(chosen_c-abl)
(num-subs_l11)
(not (not-chosen_c-abl))
(not (num-subs_l10))
)
)
(:action CHOOSE_CDC25C_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_cdc25c)
)
:effect
(and
(chosen_cdc25c)
(num-subs_l11)
(not (not-chosen_cdc25c))
(not (num-subs_l10))
)
)
(:action CHOOSE_CDK1P1P2_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_cdk1p1p2)
)
:effect
(and
(chosen_cdk1p1p2)
(num-subs_l11)
(not (not-chosen_cdk1p1p2))
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
(:action CHOOSE_CDK2P2-CYCB_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_cdk2p2-cycb)
)
:effect
(and
(chosen_cdk2p2-cycb)
(num-subs_l11)
(not (not-chosen_cdk2p2-cycb))
(not (num-subs_l10))
)
)
(:action CHOOSE_CDK46P3-CYCDP1_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_cdk46p3-cycdp1)
)
:effect
(and
(chosen_cdk46p3-cycdp1)
(num-subs_l11)
(not (not-chosen_cdk46p3-cycdp1))
(not (num-subs_l10))
)
)
(:action CHOOSE_CDK7_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_cdk7)
)
:effect
(and
(chosen_cdk7)
(num-subs_l11)
(not (not-chosen_cdk7))
(not (num-subs_l10))
)
)
(:action CHOOSE_CHK1_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_chk1)
)
:effect
(and
(chosen_chk1)
(num-subs_l11)
(not (not-chosen_chk1))
(not (num-subs_l10))
)
)
(:action CHOOSE_CKS1_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_cks1)
)
:effect
(and
(chosen_cks1)
(num-subs_l11)
(not (not-chosen_cks1))
(not (num-subs_l10))
)
)
(:action CHOOSE_C-TAK1_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_c-tak1)
)
:effect
(and
(chosen_c-tak1)
(num-subs_l11)
(not (not-chosen_c-tak1))
(not (num-subs_l10))
)
)
(:action CHOOSE_CYCB_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_cycb)
)
:effect
(and
(chosen_cycb)
(num-subs_l11)
(not (not-chosen_cycb))
(not (num-subs_l10))
)
)
(:action CHOOSE_CYCH_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_cych)
)
:effect
(and
(chosen_cych)
(num-subs_l11)
(not (not-chosen_cych))
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
(:action CHOOSE_E2F13-DP12P1_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_e2f13-dp12p1)
)
:effect
(and
(chosen_e2f13-dp12p1)
(num-subs_l11)
(not (not-chosen_e2f13-dp12p1))
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
(:action CHOOSE_E2F13P1-DP12P1_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_e2f13p1-dp12p1)
)
:effect
(and
(chosen_e2f13p1-dp12p1)
(num-subs_l11)
(not (not-chosen_e2f13p1-dp12p1))
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
(:action CHOOSE_GE-C_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_ge-c)
)
:effect
(and
(chosen_ge-c)
(num-subs_l11)
(not (not-chosen_ge-c))
(not (num-subs_l10))
)
)
(:action CHOOSE_GERCC1_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_gercc1)
)
:effect
(and
(chosen_gercc1)
(num-subs_l11)
(not (not-chosen_gercc1))
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
(:action CHOOSE_HDAC1-P107-E2F4P1-DP12_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_hdac1-p107-e2f4p1-dp12)
)
:effect
(and
(chosen_hdac1-p107-e2f4p1-dp12)
(num-subs_l11)
(not (not-chosen_hdac1-p107-e2f4p1-dp12))
(not (num-subs_l10))
)
)
(:action CHOOSE_HDAC1-P130-E2F4P1-DP12_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_hdac1-p130-e2f4p1-dp12)
)
:effect
(and
(chosen_hdac1-p130-e2f4p1-dp12)
(num-subs_l11)
(not (not-chosen_hdac1-p130-e2f4p1-dp12))
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
(:action CHOOSE_M1433_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_m1433)
)
:effect
(and
(chosen_m1433)
(num-subs_l11)
(not (not-chosen_m1433))
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
(:action CHOOSE_P53_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_p53)
)
:effect
(and
(chosen_p53)
(num-subs_l11)
(not (not-chosen_p53))
(not (num-subs_l10))
)
)
(:action CHOOSE_P53P1_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_p53p1)
)
:effect
(and
(chosen_p53p1)
(num-subs_l11)
(not (not-chosen_p53p1))
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
(:action CHOOSE_PRB_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_prb)
)
:effect
(and
(chosen_prb)
(num-subs_l11)
(not (not-chosen_prb))
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
(:action CHOOSE_WEE1_L11_L10
:parameters ()
:precondition
(and
(num-subs_l10)
(not-chosen_wee1)
)
:effect
(and
(chosen_wee1)
(num-subs_l11)
(not (not-chosen_wee1))
(not (num-subs_l10))
)
)
(:action CHOOSE_AP2_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_ap2)
)
:effect
(and
(chosen_ap2)
(num-subs_l10)
(not (not-chosen_ap2))
(not (num-subs_l9))
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
(:action CHOOSE_C-ABL_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_c-abl)
)
:effect
(and
(chosen_c-abl)
(num-subs_l10)
(not (not-chosen_c-abl))
(not (num-subs_l9))
)
)
(:action CHOOSE_CDC25C_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_cdc25c)
)
:effect
(and
(chosen_cdc25c)
(num-subs_l10)
(not (not-chosen_cdc25c))
(not (num-subs_l9))
)
)
(:action CHOOSE_CDK1P1P2_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_cdk1p1p2)
)
:effect
(and
(chosen_cdk1p1p2)
(num-subs_l10)
(not (not-chosen_cdk1p1p2))
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
(:action CHOOSE_CDK2P2-CYCB_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_cdk2p2-cycb)
)
:effect
(and
(chosen_cdk2p2-cycb)
(num-subs_l10)
(not (not-chosen_cdk2p2-cycb))
(not (num-subs_l9))
)
)
(:action CHOOSE_CDK46P3-CYCDP1_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_cdk46p3-cycdp1)
)
:effect
(and
(chosen_cdk46p3-cycdp1)
(num-subs_l10)
(not (not-chosen_cdk46p3-cycdp1))
(not (num-subs_l9))
)
)
(:action CHOOSE_CDK7_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_cdk7)
)
:effect
(and
(chosen_cdk7)
(num-subs_l10)
(not (not-chosen_cdk7))
(not (num-subs_l9))
)
)
(:action CHOOSE_CHK1_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_chk1)
)
:effect
(and
(chosen_chk1)
(num-subs_l10)
(not (not-chosen_chk1))
(not (num-subs_l9))
)
)
(:action CHOOSE_CKS1_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_cks1)
)
:effect
(and
(chosen_cks1)
(num-subs_l10)
(not (not-chosen_cks1))
(not (num-subs_l9))
)
)
(:action CHOOSE_C-TAK1_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_c-tak1)
)
:effect
(and
(chosen_c-tak1)
(num-subs_l10)
(not (not-chosen_c-tak1))
(not (num-subs_l9))
)
)
(:action CHOOSE_CYCB_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_cycb)
)
:effect
(and
(chosen_cycb)
(num-subs_l10)
(not (not-chosen_cycb))
(not (num-subs_l9))
)
)
(:action CHOOSE_CYCH_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_cych)
)
:effect
(and
(chosen_cych)
(num-subs_l10)
(not (not-chosen_cych))
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
(:action CHOOSE_E2F13-DP12P1_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_e2f13-dp12p1)
)
:effect
(and
(chosen_e2f13-dp12p1)
(num-subs_l10)
(not (not-chosen_e2f13-dp12p1))
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
(:action CHOOSE_E2F13P1-DP12P1_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_e2f13p1-dp12p1)
)
:effect
(and
(chosen_e2f13p1-dp12p1)
(num-subs_l10)
(not (not-chosen_e2f13p1-dp12p1))
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
(:action CHOOSE_GE-C_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_ge-c)
)
:effect
(and
(chosen_ge-c)
(num-subs_l10)
(not (not-chosen_ge-c))
(not (num-subs_l9))
)
)
(:action CHOOSE_GERCC1_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_gercc1)
)
:effect
(and
(chosen_gercc1)
(num-subs_l10)
(not (not-chosen_gercc1))
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
(:action CHOOSE_HDAC1-P107-E2F4P1-DP12_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_hdac1-p107-e2f4p1-dp12)
)
:effect
(and
(chosen_hdac1-p107-e2f4p1-dp12)
(num-subs_l10)
(not (not-chosen_hdac1-p107-e2f4p1-dp12))
(not (num-subs_l9))
)
)
(:action CHOOSE_HDAC1-P130-E2F4P1-DP12_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_hdac1-p130-e2f4p1-dp12)
)
:effect
(and
(chosen_hdac1-p130-e2f4p1-dp12)
(num-subs_l10)
(not (not-chosen_hdac1-p130-e2f4p1-dp12))
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
(:action CHOOSE_M1433_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_m1433)
)
:effect
(and
(chosen_m1433)
(num-subs_l10)
(not (not-chosen_m1433))
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
(:action CHOOSE_P53_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_p53)
)
:effect
(and
(chosen_p53)
(num-subs_l10)
(not (not-chosen_p53))
(not (num-subs_l9))
)
)
(:action CHOOSE_P53P1_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_p53p1)
)
:effect
(and
(chosen_p53p1)
(num-subs_l10)
(not (not-chosen_p53p1))
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
(:action CHOOSE_PRB_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_prb)
)
:effect
(and
(chosen_prb)
(num-subs_l10)
(not (not-chosen_prb))
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
(:action CHOOSE_WEE1_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_wee1)
)
:effect
(and
(chosen_wee1)
(num-subs_l10)
(not (not-chosen_wee1))
(not (num-subs_l9))
)
)
(:action CHOOSE_AP2_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_ap2)
)
:effect
(and
(chosen_ap2)
(num-subs_l9)
(not (not-chosen_ap2))
(not (num-subs_l8))
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
(:action CHOOSE_C-ABL_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_c-abl)
)
:effect
(and
(chosen_c-abl)
(num-subs_l9)
(not (not-chosen_c-abl))
(not (num-subs_l8))
)
)
(:action CHOOSE_CDC25C_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_cdc25c)
)
:effect
(and
(chosen_cdc25c)
(num-subs_l9)
(not (not-chosen_cdc25c))
(not (num-subs_l8))
)
)
(:action CHOOSE_CDK1P1P2_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_cdk1p1p2)
)
:effect
(and
(chosen_cdk1p1p2)
(num-subs_l9)
(not (not-chosen_cdk1p1p2))
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
(:action CHOOSE_CDK2P2-CYCB_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_cdk2p2-cycb)
)
:effect
(and
(chosen_cdk2p2-cycb)
(num-subs_l9)
(not (not-chosen_cdk2p2-cycb))
(not (num-subs_l8))
)
)
(:action CHOOSE_CDK46P3-CYCDP1_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_cdk46p3-cycdp1)
)
:effect
(and
(chosen_cdk46p3-cycdp1)
(num-subs_l9)
(not (not-chosen_cdk46p3-cycdp1))
(not (num-subs_l8))
)
)
(:action CHOOSE_CDK7_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_cdk7)
)
:effect
(and
(chosen_cdk7)
(num-subs_l9)
(not (not-chosen_cdk7))
(not (num-subs_l8))
)
)
(:action CHOOSE_CHK1_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_chk1)
)
:effect
(and
(chosen_chk1)
(num-subs_l9)
(not (not-chosen_chk1))
(not (num-subs_l8))
)
)
(:action CHOOSE_CKS1_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_cks1)
)
:effect
(and
(chosen_cks1)
(num-subs_l9)
(not (not-chosen_cks1))
(not (num-subs_l8))
)
)
(:action CHOOSE_C-TAK1_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_c-tak1)
)
:effect
(and
(chosen_c-tak1)
(num-subs_l9)
(not (not-chosen_c-tak1))
(not (num-subs_l8))
)
)
(:action CHOOSE_CYCB_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_cycb)
)
:effect
(and
(chosen_cycb)
(num-subs_l9)
(not (not-chosen_cycb))
(not (num-subs_l8))
)
)
(:action CHOOSE_CYCH_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_cych)
)
:effect
(and
(chosen_cych)
(num-subs_l9)
(not (not-chosen_cych))
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
(:action CHOOSE_E2F13-DP12P1_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_e2f13-dp12p1)
)
:effect
(and
(chosen_e2f13-dp12p1)
(num-subs_l9)
(not (not-chosen_e2f13-dp12p1))
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
(:action CHOOSE_E2F13P1-DP12P1_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_e2f13p1-dp12p1)
)
:effect
(and
(chosen_e2f13p1-dp12p1)
(num-subs_l9)
(not (not-chosen_e2f13p1-dp12p1))
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
(:action CHOOSE_GE-C_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_ge-c)
)
:effect
(and
(chosen_ge-c)
(num-subs_l9)
(not (not-chosen_ge-c))
(not (num-subs_l8))
)
)
(:action CHOOSE_GERCC1_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_gercc1)
)
:effect
(and
(chosen_gercc1)
(num-subs_l9)
(not (not-chosen_gercc1))
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
(:action CHOOSE_HDAC1-P107-E2F4P1-DP12_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_hdac1-p107-e2f4p1-dp12)
)
:effect
(and
(chosen_hdac1-p107-e2f4p1-dp12)
(num-subs_l9)
(not (not-chosen_hdac1-p107-e2f4p1-dp12))
(not (num-subs_l8))
)
)
(:action CHOOSE_HDAC1-P130-E2F4P1-DP12_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_hdac1-p130-e2f4p1-dp12)
)
:effect
(and
(chosen_hdac1-p130-e2f4p1-dp12)
(num-subs_l9)
(not (not-chosen_hdac1-p130-e2f4p1-dp12))
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
(:action CHOOSE_M1433_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_m1433)
)
:effect
(and
(chosen_m1433)
(num-subs_l9)
(not (not-chosen_m1433))
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
(:action CHOOSE_P53_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_p53)
)
:effect
(and
(chosen_p53)
(num-subs_l9)
(not (not-chosen_p53))
(not (num-subs_l8))
)
)
(:action CHOOSE_P53P1_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_p53p1)
)
:effect
(and
(chosen_p53p1)
(num-subs_l9)
(not (not-chosen_p53p1))
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
(:action CHOOSE_PRB_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_prb)
)
:effect
(and
(chosen_prb)
(num-subs_l9)
(not (not-chosen_prb))
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
(:action CHOOSE_WEE1_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_wee1)
)
:effect
(and
(chosen_wee1)
(num-subs_l9)
(not (not-chosen_wee1))
(not (num-subs_l8))
)
)
(:action CHOOSE_AP2_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_ap2)
)
:effect
(and
(chosen_ap2)
(num-subs_l8)
(not (not-chosen_ap2))
(not (num-subs_l7))
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
(:action CHOOSE_C-ABL_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_c-abl)
)
:effect
(and
(chosen_c-abl)
(num-subs_l8)
(not (not-chosen_c-abl))
(not (num-subs_l7))
)
)
(:action CHOOSE_CDC25C_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_cdc25c)
)
:effect
(and
(chosen_cdc25c)
(num-subs_l8)
(not (not-chosen_cdc25c))
(not (num-subs_l7))
)
)
(:action CHOOSE_CDK1P1P2_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_cdk1p1p2)
)
:effect
(and
(chosen_cdk1p1p2)
(num-subs_l8)
(not (not-chosen_cdk1p1p2))
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
(:action CHOOSE_CDK2P2-CYCB_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_cdk2p2-cycb)
)
:effect
(and
(chosen_cdk2p2-cycb)
(num-subs_l8)
(not (not-chosen_cdk2p2-cycb))
(not (num-subs_l7))
)
)
(:action CHOOSE_CDK46P3-CYCDP1_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_cdk46p3-cycdp1)
)
:effect
(and
(chosen_cdk46p3-cycdp1)
(num-subs_l8)
(not (not-chosen_cdk46p3-cycdp1))
(not (num-subs_l7))
)
)
(:action CHOOSE_CDK7_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_cdk7)
)
:effect
(and
(chosen_cdk7)
(num-subs_l8)
(not (not-chosen_cdk7))
(not (num-subs_l7))
)
)
(:action CHOOSE_CHK1_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_chk1)
)
:effect
(and
(chosen_chk1)
(num-subs_l8)
(not (not-chosen_chk1))
(not (num-subs_l7))
)
)
(:action CHOOSE_CKS1_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_cks1)
)
:effect
(and
(chosen_cks1)
(num-subs_l8)
(not (not-chosen_cks1))
(not (num-subs_l7))
)
)
(:action CHOOSE_C-TAK1_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_c-tak1)
)
:effect
(and
(chosen_c-tak1)
(num-subs_l8)
(not (not-chosen_c-tak1))
(not (num-subs_l7))
)
)
(:action CHOOSE_CYCB_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_cycb)
)
:effect
(and
(chosen_cycb)
(num-subs_l8)
(not (not-chosen_cycb))
(not (num-subs_l7))
)
)
(:action CHOOSE_CYCH_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_cych)
)
:effect
(and
(chosen_cych)
(num-subs_l8)
(not (not-chosen_cych))
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
(:action CHOOSE_E2F13-DP12P1_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_e2f13-dp12p1)
)
:effect
(and
(chosen_e2f13-dp12p1)
(num-subs_l8)
(not (not-chosen_e2f13-dp12p1))
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
(:action CHOOSE_E2F13P1-DP12P1_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_e2f13p1-dp12p1)
)
:effect
(and
(chosen_e2f13p1-dp12p1)
(num-subs_l8)
(not (not-chosen_e2f13p1-dp12p1))
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
(:action CHOOSE_GE-C_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_ge-c)
)
:effect
(and
(chosen_ge-c)
(num-subs_l8)
(not (not-chosen_ge-c))
(not (num-subs_l7))
)
)
(:action CHOOSE_GERCC1_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_gercc1)
)
:effect
(and
(chosen_gercc1)
(num-subs_l8)
(not (not-chosen_gercc1))
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
(:action CHOOSE_HDAC1-P107-E2F4P1-DP12_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_hdac1-p107-e2f4p1-dp12)
)
:effect
(and
(chosen_hdac1-p107-e2f4p1-dp12)
(num-subs_l8)
(not (not-chosen_hdac1-p107-e2f4p1-dp12))
(not (num-subs_l7))
)
)
(:action CHOOSE_HDAC1-P130-E2F4P1-DP12_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_hdac1-p130-e2f4p1-dp12)
)
:effect
(and
(chosen_hdac1-p130-e2f4p1-dp12)
(num-subs_l8)
(not (not-chosen_hdac1-p130-e2f4p1-dp12))
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
(:action CHOOSE_M1433_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_m1433)
)
:effect
(and
(chosen_m1433)
(num-subs_l8)
(not (not-chosen_m1433))
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
(:action CHOOSE_P53_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_p53)
)
:effect
(and
(chosen_p53)
(num-subs_l8)
(not (not-chosen_p53))
(not (num-subs_l7))
)
)
(:action CHOOSE_P53P1_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_p53p1)
)
:effect
(and
(chosen_p53p1)
(num-subs_l8)
(not (not-chosen_p53p1))
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
(:action CHOOSE_PRB_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_prb)
)
:effect
(and
(chosen_prb)
(num-subs_l8)
(not (not-chosen_prb))
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
(:action CHOOSE_WEE1_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_wee1)
)
:effect
(and
(chosen_wee1)
(num-subs_l8)
(not (not-chosen_wee1))
(not (num-subs_l7))
)
)
(:action CHOOSE_AP2_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_ap2)
)
:effect
(and
(chosen_ap2)
(num-subs_l7)
(not (not-chosen_ap2))
(not (num-subs_l6))
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
(:action CHOOSE_C-ABL_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_c-abl)
)
:effect
(and
(chosen_c-abl)
(num-subs_l7)
(not (not-chosen_c-abl))
(not (num-subs_l6))
)
)
(:action CHOOSE_CDC25C_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_cdc25c)
)
:effect
(and
(chosen_cdc25c)
(num-subs_l7)
(not (not-chosen_cdc25c))
(not (num-subs_l6))
)
)
(:action CHOOSE_CDK1P1P2_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_cdk1p1p2)
)
:effect
(and
(chosen_cdk1p1p2)
(num-subs_l7)
(not (not-chosen_cdk1p1p2))
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
(:action CHOOSE_CDK2P2-CYCB_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_cdk2p2-cycb)
)
:effect
(and
(chosen_cdk2p2-cycb)
(num-subs_l7)
(not (not-chosen_cdk2p2-cycb))
(not (num-subs_l6))
)
)
(:action CHOOSE_CDK46P3-CYCDP1_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_cdk46p3-cycdp1)
)
:effect
(and
(chosen_cdk46p3-cycdp1)
(num-subs_l7)
(not (not-chosen_cdk46p3-cycdp1))
(not (num-subs_l6))
)
)
(:action CHOOSE_CDK7_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_cdk7)
)
:effect
(and
(chosen_cdk7)
(num-subs_l7)
(not (not-chosen_cdk7))
(not (num-subs_l6))
)
)
(:action CHOOSE_CHK1_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_chk1)
)
:effect
(and
(chosen_chk1)
(num-subs_l7)
(not (not-chosen_chk1))
(not (num-subs_l6))
)
)
(:action CHOOSE_CKS1_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_cks1)
)
:effect
(and
(chosen_cks1)
(num-subs_l7)
(not (not-chosen_cks1))
(not (num-subs_l6))
)
)
(:action CHOOSE_C-TAK1_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_c-tak1)
)
:effect
(and
(chosen_c-tak1)
(num-subs_l7)
(not (not-chosen_c-tak1))
(not (num-subs_l6))
)
)
(:action CHOOSE_CYCB_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_cycb)
)
:effect
(and
(chosen_cycb)
(num-subs_l7)
(not (not-chosen_cycb))
(not (num-subs_l6))
)
)
(:action CHOOSE_CYCH_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_cych)
)
:effect
(and
(chosen_cych)
(num-subs_l7)
(not (not-chosen_cych))
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
(:action CHOOSE_E2F13-DP12P1_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_e2f13-dp12p1)
)
:effect
(and
(chosen_e2f13-dp12p1)
(num-subs_l7)
(not (not-chosen_e2f13-dp12p1))
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
(:action CHOOSE_E2F13P1-DP12P1_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_e2f13p1-dp12p1)
)
:effect
(and
(chosen_e2f13p1-dp12p1)
(num-subs_l7)
(not (not-chosen_e2f13p1-dp12p1))
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
(:action CHOOSE_GE-C_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_ge-c)
)
:effect
(and
(chosen_ge-c)
(num-subs_l7)
(not (not-chosen_ge-c))
(not (num-subs_l6))
)
)
(:action CHOOSE_GERCC1_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_gercc1)
)
:effect
(and
(chosen_gercc1)
(num-subs_l7)
(not (not-chosen_gercc1))
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
(:action CHOOSE_HDAC1-P107-E2F4P1-DP12_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_hdac1-p107-e2f4p1-dp12)
)
:effect
(and
(chosen_hdac1-p107-e2f4p1-dp12)
(num-subs_l7)
(not (not-chosen_hdac1-p107-e2f4p1-dp12))
(not (num-subs_l6))
)
)
(:action CHOOSE_HDAC1-P130-E2F4P1-DP12_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_hdac1-p130-e2f4p1-dp12)
)
:effect
(and
(chosen_hdac1-p130-e2f4p1-dp12)
(num-subs_l7)
(not (not-chosen_hdac1-p130-e2f4p1-dp12))
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
(:action CHOOSE_M1433_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_m1433)
)
:effect
(and
(chosen_m1433)
(num-subs_l7)
(not (not-chosen_m1433))
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
(:action CHOOSE_P53_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_p53)
)
:effect
(and
(chosen_p53)
(num-subs_l7)
(not (not-chosen_p53))
(not (num-subs_l6))
)
)
(:action CHOOSE_P53P1_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_p53p1)
)
:effect
(and
(chosen_p53p1)
(num-subs_l7)
(not (not-chosen_p53p1))
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
(:action CHOOSE_PRB_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_prb)
)
:effect
(and
(chosen_prb)
(num-subs_l7)
(not (not-chosen_prb))
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
(:action CHOOSE_WEE1_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_wee1)
)
:effect
(and
(chosen_wee1)
(num-subs_l7)
(not (not-chosen_wee1))
(not (num-subs_l6))
)
)
(:action CHOOSE_AP2_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_ap2)
)
:effect
(and
(chosen_ap2)
(num-subs_l6)
(not (not-chosen_ap2))
(not (num-subs_l5))
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
(:action CHOOSE_C-ABL_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_c-abl)
)
:effect
(and
(chosen_c-abl)
(num-subs_l6)
(not (not-chosen_c-abl))
(not (num-subs_l5))
)
)
(:action CHOOSE_CDC25C_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_cdc25c)
)
:effect
(and
(chosen_cdc25c)
(num-subs_l6)
(not (not-chosen_cdc25c))
(not (num-subs_l5))
)
)
(:action CHOOSE_CDK1P1P2_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_cdk1p1p2)
)
:effect
(and
(chosen_cdk1p1p2)
(num-subs_l6)
(not (not-chosen_cdk1p1p2))
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
(:action CHOOSE_CDK2P2-CYCB_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_cdk2p2-cycb)
)
:effect
(and
(chosen_cdk2p2-cycb)
(num-subs_l6)
(not (not-chosen_cdk2p2-cycb))
(not (num-subs_l5))
)
)
(:action CHOOSE_CDK46P3-CYCDP1_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_cdk46p3-cycdp1)
)
:effect
(and
(chosen_cdk46p3-cycdp1)
(num-subs_l6)
(not (not-chosen_cdk46p3-cycdp1))
(not (num-subs_l5))
)
)
(:action CHOOSE_CDK7_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_cdk7)
)
:effect
(and
(chosen_cdk7)
(num-subs_l6)
(not (not-chosen_cdk7))
(not (num-subs_l5))
)
)
(:action CHOOSE_CHK1_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_chk1)
)
:effect
(and
(chosen_chk1)
(num-subs_l6)
(not (not-chosen_chk1))
(not (num-subs_l5))
)
)
(:action CHOOSE_CKS1_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_cks1)
)
:effect
(and
(chosen_cks1)
(num-subs_l6)
(not (not-chosen_cks1))
(not (num-subs_l5))
)
)
(:action CHOOSE_C-TAK1_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_c-tak1)
)
:effect
(and
(chosen_c-tak1)
(num-subs_l6)
(not (not-chosen_c-tak1))
(not (num-subs_l5))
)
)
(:action CHOOSE_CYCB_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_cycb)
)
:effect
(and
(chosen_cycb)
(num-subs_l6)
(not (not-chosen_cycb))
(not (num-subs_l5))
)
)
(:action CHOOSE_CYCH_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_cych)
)
:effect
(and
(chosen_cych)
(num-subs_l6)
(not (not-chosen_cych))
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
(:action CHOOSE_E2F13-DP12P1_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_e2f13-dp12p1)
)
:effect
(and
(chosen_e2f13-dp12p1)
(num-subs_l6)
(not (not-chosen_e2f13-dp12p1))
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
(:action CHOOSE_E2F13P1-DP12P1_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_e2f13p1-dp12p1)
)
:effect
(and
(chosen_e2f13p1-dp12p1)
(num-subs_l6)
(not (not-chosen_e2f13p1-dp12p1))
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
(:action CHOOSE_GE-C_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_ge-c)
)
:effect
(and
(chosen_ge-c)
(num-subs_l6)
(not (not-chosen_ge-c))
(not (num-subs_l5))
)
)
(:action CHOOSE_GERCC1_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_gercc1)
)
:effect
(and
(chosen_gercc1)
(num-subs_l6)
(not (not-chosen_gercc1))
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
(:action CHOOSE_HDAC1-P107-E2F4P1-DP12_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_hdac1-p107-e2f4p1-dp12)
)
:effect
(and
(chosen_hdac1-p107-e2f4p1-dp12)
(num-subs_l6)
(not (not-chosen_hdac1-p107-e2f4p1-dp12))
(not (num-subs_l5))
)
)
(:action CHOOSE_HDAC1-P130-E2F4P1-DP12_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_hdac1-p130-e2f4p1-dp12)
)
:effect
(and
(chosen_hdac1-p130-e2f4p1-dp12)
(num-subs_l6)
(not (not-chosen_hdac1-p130-e2f4p1-dp12))
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
(:action CHOOSE_M1433_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_m1433)
)
:effect
(and
(chosen_m1433)
(num-subs_l6)
(not (not-chosen_m1433))
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
(:action CHOOSE_P53_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_p53)
)
:effect
(and
(chosen_p53)
(num-subs_l6)
(not (not-chosen_p53))
(not (num-subs_l5))
)
)
(:action CHOOSE_P53P1_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_p53p1)
)
:effect
(and
(chosen_p53p1)
(num-subs_l6)
(not (not-chosen_p53p1))
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
(:action CHOOSE_PRB_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_prb)
)
:effect
(and
(chosen_prb)
(num-subs_l6)
(not (not-chosen_prb))
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
(:action CHOOSE_WEE1_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_wee1)
)
:effect
(and
(chosen_wee1)
(num-subs_l6)
(not (not-chosen_wee1))
(not (num-subs_l5))
)
)
(:action CHOOSE_AP2_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_ap2)
)
:effect
(and
(chosen_ap2)
(num-subs_l5)
(not (not-chosen_ap2))
(not (num-subs_l4))
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
(:action CHOOSE_C-ABL_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_c-abl)
)
:effect
(and
(chosen_c-abl)
(num-subs_l5)
(not (not-chosen_c-abl))
(not (num-subs_l4))
)
)
(:action CHOOSE_CDC25C_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_cdc25c)
)
:effect
(and
(chosen_cdc25c)
(num-subs_l5)
(not (not-chosen_cdc25c))
(not (num-subs_l4))
)
)
(:action CHOOSE_CDK1P1P2_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_cdk1p1p2)
)
:effect
(and
(chosen_cdk1p1p2)
(num-subs_l5)
(not (not-chosen_cdk1p1p2))
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
(:action CHOOSE_CDK2P2-CYCB_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_cdk2p2-cycb)
)
:effect
(and
(chosen_cdk2p2-cycb)
(num-subs_l5)
(not (not-chosen_cdk2p2-cycb))
(not (num-subs_l4))
)
)
(:action CHOOSE_CDK46P3-CYCDP1_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_cdk46p3-cycdp1)
)
:effect
(and
(chosen_cdk46p3-cycdp1)
(num-subs_l5)
(not (not-chosen_cdk46p3-cycdp1))
(not (num-subs_l4))
)
)
(:action CHOOSE_CDK7_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_cdk7)
)
:effect
(and
(chosen_cdk7)
(num-subs_l5)
(not (not-chosen_cdk7))
(not (num-subs_l4))
)
)
(:action CHOOSE_CHK1_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_chk1)
)
:effect
(and
(chosen_chk1)
(num-subs_l5)
(not (not-chosen_chk1))
(not (num-subs_l4))
)
)
(:action CHOOSE_CKS1_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_cks1)
)
:effect
(and
(chosen_cks1)
(num-subs_l5)
(not (not-chosen_cks1))
(not (num-subs_l4))
)
)
(:action CHOOSE_C-TAK1_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_c-tak1)
)
:effect
(and
(chosen_c-tak1)
(num-subs_l5)
(not (not-chosen_c-tak1))
(not (num-subs_l4))
)
)
(:action CHOOSE_CYCB_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_cycb)
)
:effect
(and
(chosen_cycb)
(num-subs_l5)
(not (not-chosen_cycb))
(not (num-subs_l4))
)
)
(:action CHOOSE_CYCH_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_cych)
)
:effect
(and
(chosen_cych)
(num-subs_l5)
(not (not-chosen_cych))
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
(:action CHOOSE_E2F13-DP12P1_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_e2f13-dp12p1)
)
:effect
(and
(chosen_e2f13-dp12p1)
(num-subs_l5)
(not (not-chosen_e2f13-dp12p1))
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
(:action CHOOSE_E2F13P1-DP12P1_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_e2f13p1-dp12p1)
)
:effect
(and
(chosen_e2f13p1-dp12p1)
(num-subs_l5)
(not (not-chosen_e2f13p1-dp12p1))
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
(:action CHOOSE_GE-C_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_ge-c)
)
:effect
(and
(chosen_ge-c)
(num-subs_l5)
(not (not-chosen_ge-c))
(not (num-subs_l4))
)
)
(:action CHOOSE_GERCC1_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_gercc1)
)
:effect
(and
(chosen_gercc1)
(num-subs_l5)
(not (not-chosen_gercc1))
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
(:action CHOOSE_HDAC1-P107-E2F4P1-DP12_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_hdac1-p107-e2f4p1-dp12)
)
:effect
(and
(chosen_hdac1-p107-e2f4p1-dp12)
(num-subs_l5)
(not (not-chosen_hdac1-p107-e2f4p1-dp12))
(not (num-subs_l4))
)
)
(:action CHOOSE_HDAC1-P130-E2F4P1-DP12_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_hdac1-p130-e2f4p1-dp12)
)
:effect
(and
(chosen_hdac1-p130-e2f4p1-dp12)
(num-subs_l5)
(not (not-chosen_hdac1-p130-e2f4p1-dp12))
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
(:action CHOOSE_M1433_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_m1433)
)
:effect
(and
(chosen_m1433)
(num-subs_l5)
(not (not-chosen_m1433))
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
(:action CHOOSE_P53_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_p53)
)
:effect
(and
(chosen_p53)
(num-subs_l5)
(not (not-chosen_p53))
(not (num-subs_l4))
)
)
(:action CHOOSE_P53P1_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_p53p1)
)
:effect
(and
(chosen_p53p1)
(num-subs_l5)
(not (not-chosen_p53p1))
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
(:action CHOOSE_PRB_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_prb)
)
:effect
(and
(chosen_prb)
(num-subs_l5)
(not (not-chosen_prb))
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
(:action CHOOSE_WEE1_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_wee1)
)
:effect
(and
(chosen_wee1)
(num-subs_l5)
(not (not-chosen_wee1))
(not (num-subs_l4))
)
)
(:action CHOOSE_AP2_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_ap2)
)
:effect
(and
(chosen_ap2)
(num-subs_l4)
(not (not-chosen_ap2))
(not (num-subs_l3))
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
(:action CHOOSE_C-ABL_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_c-abl)
)
:effect
(and
(chosen_c-abl)
(num-subs_l4)
(not (not-chosen_c-abl))
(not (num-subs_l3))
)
)
(:action CHOOSE_CDC25C_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_cdc25c)
)
:effect
(and
(chosen_cdc25c)
(num-subs_l4)
(not (not-chosen_cdc25c))
(not (num-subs_l3))
)
)
(:action CHOOSE_CDK1P1P2_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_cdk1p1p2)
)
:effect
(and
(chosen_cdk1p1p2)
(num-subs_l4)
(not (not-chosen_cdk1p1p2))
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
(:action CHOOSE_CDK2P2-CYCB_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_cdk2p2-cycb)
)
:effect
(and
(chosen_cdk2p2-cycb)
(num-subs_l4)
(not (not-chosen_cdk2p2-cycb))
(not (num-subs_l3))
)
)
(:action CHOOSE_CDK46P3-CYCDP1_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_cdk46p3-cycdp1)
)
:effect
(and
(chosen_cdk46p3-cycdp1)
(num-subs_l4)
(not (not-chosen_cdk46p3-cycdp1))
(not (num-subs_l3))
)
)
(:action CHOOSE_CDK7_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_cdk7)
)
:effect
(and
(chosen_cdk7)
(num-subs_l4)
(not (not-chosen_cdk7))
(not (num-subs_l3))
)
)
(:action CHOOSE_CHK1_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_chk1)
)
:effect
(and
(chosen_chk1)
(num-subs_l4)
(not (not-chosen_chk1))
(not (num-subs_l3))
)
)
(:action CHOOSE_CKS1_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_cks1)
)
:effect
(and
(chosen_cks1)
(num-subs_l4)
(not (not-chosen_cks1))
(not (num-subs_l3))
)
)
(:action CHOOSE_C-TAK1_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_c-tak1)
)
:effect
(and
(chosen_c-tak1)
(num-subs_l4)
(not (not-chosen_c-tak1))
(not (num-subs_l3))
)
)
(:action CHOOSE_CYCB_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_cycb)
)
:effect
(and
(chosen_cycb)
(num-subs_l4)
(not (not-chosen_cycb))
(not (num-subs_l3))
)
)
(:action CHOOSE_CYCH_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_cych)
)
:effect
(and
(chosen_cych)
(num-subs_l4)
(not (not-chosen_cych))
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
(:action CHOOSE_E2F13-DP12P1_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_e2f13-dp12p1)
)
:effect
(and
(chosen_e2f13-dp12p1)
(num-subs_l4)
(not (not-chosen_e2f13-dp12p1))
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
(:action CHOOSE_E2F13P1-DP12P1_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_e2f13p1-dp12p1)
)
:effect
(and
(chosen_e2f13p1-dp12p1)
(num-subs_l4)
(not (not-chosen_e2f13p1-dp12p1))
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
(:action CHOOSE_GE-C_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_ge-c)
)
:effect
(and
(chosen_ge-c)
(num-subs_l4)
(not (not-chosen_ge-c))
(not (num-subs_l3))
)
)
(:action CHOOSE_GERCC1_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_gercc1)
)
:effect
(and
(chosen_gercc1)
(num-subs_l4)
(not (not-chosen_gercc1))
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
(:action CHOOSE_HDAC1-P107-E2F4P1-DP12_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_hdac1-p107-e2f4p1-dp12)
)
:effect
(and
(chosen_hdac1-p107-e2f4p1-dp12)
(num-subs_l4)
(not (not-chosen_hdac1-p107-e2f4p1-dp12))
(not (num-subs_l3))
)
)
(:action CHOOSE_HDAC1-P130-E2F4P1-DP12_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_hdac1-p130-e2f4p1-dp12)
)
:effect
(and
(chosen_hdac1-p130-e2f4p1-dp12)
(num-subs_l4)
(not (not-chosen_hdac1-p130-e2f4p1-dp12))
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
(:action CHOOSE_M1433_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_m1433)
)
:effect
(and
(chosen_m1433)
(num-subs_l4)
(not (not-chosen_m1433))
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
(:action CHOOSE_P53_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_p53)
)
:effect
(and
(chosen_p53)
(num-subs_l4)
(not (not-chosen_p53))
(not (num-subs_l3))
)
)
(:action CHOOSE_P53P1_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_p53p1)
)
:effect
(and
(chosen_p53p1)
(num-subs_l4)
(not (not-chosen_p53p1))
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
(:action CHOOSE_PRB_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_prb)
)
:effect
(and
(chosen_prb)
(num-subs_l4)
(not (not-chosen_prb))
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
(:action CHOOSE_WEE1_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_wee1)
)
:effect
(and
(chosen_wee1)
(num-subs_l4)
(not (not-chosen_wee1))
(not (num-subs_l3))
)
)
(:action dummy-action-18-1
:parameters ()
:precondition
(and
(available_cdk1p1-cks1)
)
:effect
(and
(goal18_)
)
)
(:action dummy-action-17-1
:parameters ()
:precondition
(and
(available_p57-cdk2p1p2-cyca)
)
:effect
(and
(goal17_)
)
)
(:action dummy-action-16-1
:parameters ()
:precondition
(and
(available_p27-cdk2p1-cyce)
)
:effect
(and
(goal16_)
)
)
(:action dummy-action-16-2
:parameters ()
:precondition
(and
(available_p21-cdk2p1p2-cyca)
)
:effect
(and
(goal16_)
)
)
(:action dummy-action-15-1
:parameters ()
:precondition
(and
(available_p27-cdk2p1p2-cyce)
)
:effect
(and
(goal15_)
)
)
(:action dummy-action-15-2
:parameters ()
:precondition
(and
(available_p27-cdk2p1-cycep1)
)
:effect
(and
(goal15_)
)
)
(:action dummy-action-14-1
:parameters ()
:precondition
(and
(available_skp2-cdk2p1-cyca)
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
(available_p27-cdk2p1p2-cyca)
)
:effect
(and
(goal13_)
)
)
(:action dummy-action-13-2
:parameters ()
:precondition
(and
(available_p21-cdk2p1-cyce)
)
:effect
(and
(goal13_)
)
)
(:action dummy-action-11-1
:parameters ()
:precondition
(and
(available_p57-cdk2p1p2-cyce)
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
(available_p21-cdk2p1p2-cyce)
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
(available_cdk1-cks1)
)
:effect
(and
(goal9_)
)
)
(:action dummy-action-6-1
:parameters ()
:precondition
(and
(available_p27-cdk2p1-cyca)
)
:effect
(and
(goal6_)
)
)
(:action dummy-action-5-1
:parameters ()
:precondition
(and
(available_cdk1p2-cks1)
)
:effect
(and
(goal5_)
)
)
(:action dummy-action-4-1
:parameters ()
:precondition
(and
(available_cdk1p2p3-cks1)
)
:effect
(and
(goal4_)
)
)
(:action dummy-action-4-2
:parameters ()
:precondition
(and
(available_p57-cdk2p1-cyce)
)
:effect
(and
(goal4_)
)
)
(:action dummy-action-3-1
:parameters ()
:precondition
(and
(available_p57-cdk2p1-cycep1)
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
(available_cdk1p3-cycb)
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
(available_cdk1p3-cks1)
)
:effect
(and
(goal2_)
)
)
(:action dummy-action-2-2
:parameters ()
:precondition
(and
(available_cdk1p3-cyca)
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
(available_wee1p1)
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
(available_cdk1p3-gadd45)
)
:effect
(and
(goal1_)
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDC25C_CDK1P3-CYCA_CDC25CP1
:parameters ()
:precondition
(and
(available_cdk1p3-cyca)
(available_cdc25c)
)
:effect
(and
(available_cdc25cp1)
(not (available_cdc25c))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDC25C_CDK1P3-CYCB_CDC25CP1
:parameters ()
:precondition
(and
(available_cdk1p3-cycb)
(available_cdc25c)
)
:effect
(and
(available_cdc25cp1)
(not (available_cdc25c))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDC25CP2_CDK1P3-CYCA_CDC25CP1P2
:parameters ()
:precondition
(and
(available_cdk1p3-cyca)
(available_cdc25cp2)
)
:effect
(and
(available_cdc25cp1p2)
(not (available_cdc25cp2))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDC25CP2_CDK1P3-CYCB_CDC25CP1P2
:parameters ()
:precondition
(and
(available_cdk1p3-cycb)
(available_cdc25cp2)
)
:effect
(and
(available_cdc25cp1p2)
(not (available_cdc25cp2))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDK1P1P3_CDC25CP1_CDK1P3
:parameters ()
:precondition
(and
(available_cdc25cp1)
(available_cdk1p1p3)
)
:effect
(and
(available_cdk1p3)
(not (available_cdk1p1p3))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDK1P1P3_CDC25CP1P2_CDK1P3
:parameters ()
:precondition
(and
(available_cdc25cp1p2)
(available_cdk1p1p3)
)
:effect
(and
(available_cdk1p3)
(not (available_cdk1p1p3))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDK1P1P3-CYCA_CDC25CP1_CDK1P3-CYCA
:parameters ()
:precondition
(and
(available_cdc25cp1)
(available_cdk1p1p3-cyca)
)
:effect
(and
(available_cdk1p3-cyca)
(not (available_cdk1p1p3-cyca))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDK1P1P3-CYCA_CDC25CP1P2_CDK1P3-CYCA
:parameters ()
:precondition
(and
(available_cdc25cp1p2)
(available_cdk1p1p3-cyca)
)
:effect
(and
(available_cdk1p3-cyca)
(not (available_cdk1p1p3-cyca))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDK1P1P3-CYCA_WEE1_CDK1P1P2P3-CYCA
:parameters ()
:precondition
(and
(available_wee1)
(available_cdk1p1p3-cyca)
)
:effect
(and
(available_cdk1p1p2p3-cyca)
(not (available_cdk1p1p3-cyca))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDK1P1P3-CYCB_CDC25CP1_CDK1P3-CYCB
:parameters ()
:precondition
(and
(available_cdc25cp1)
(available_cdk1p1p3-cycb)
)
:effect
(and
(available_cdk1p3-cycb)
(not (available_cdk1p1p3-cycb))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDK1P1P3-CYCB_CDC25CP1P2_CDK1P3-CYCB
:parameters ()
:precondition
(and
(available_cdc25cp1p2)
(available_cdk1p1p3-cycb)
)
:effect
(and
(available_cdk1p3-cycb)
(not (available_cdk1p1p3-cycb))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDK1P1P3-CYCB_WEE1_CDK1P1P2P3-CYCB
:parameters ()
:precondition
(and
(available_wee1)
(available_cdk1p1p3-cycb)
)
:effect
(and
(available_cdk1p1p2p3-cycb)
(not (available_cdk1p1p3-cycb))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDK1P2_CDC25CP1_CDK1
:parameters ()
:precondition
(and
(available_cdc25cp1)
(available_cdk1p2)
)
:effect
(and
(available_cdk1)
(not (available_cdk1p2))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDK1P2_CDC25CP1P2_CDK1
:parameters ()
:precondition
(and
(available_cdc25cp1p2)
(available_cdk1p2)
)
:effect
(and
(available_cdk1)
(not (available_cdk1p2))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDK1P2_CDK7-CYCH_CDK1P2P3
:parameters ()
:precondition
(and
(available_cdk7-cych)
(available_cdk1p2)
)
:effect
(and
(available_cdk1p2p3)
(not (available_cdk1p2))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDK1P2P3_CDC25CP1_CDK1P3
:parameters ()
:precondition
(and
(available_cdc25cp1)
(available_cdk1p2p3)
)
:effect
(and
(available_cdk1p3)
(not (available_cdk1p2p3))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDK1P2P3_CDC25CP1P2_CDK1P3
:parameters ()
:precondition
(and
(available_cdc25cp1p2)
(available_cdk1p2p3)
)
:effect
(and
(available_cdk1p3)
(not (available_cdk1p2p3))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDK1P2P3-CYCA_CDC25CP1_CDK1P3-CYCA
:parameters ()
:precondition
(and
(available_cdc25cp1)
(available_cdk1p2p3-cyca)
)
:effect
(and
(available_cdk1p3-cyca)
(not (available_cdk1p2p3-cyca))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDK1P2P3-CYCA_CDC25CP1P2_CDK1P3-CYCA
:parameters ()
:precondition
(and
(available_cdc25cp1p2)
(available_cdk1p2p3-cyca)
)
:effect
(and
(available_cdk1p3-cyca)
(not (available_cdk1p2p3-cyca))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDK1P2P3-CYCB_CDC25CP1_CDK1P3-CYCB
:parameters ()
:precondition
(and
(available_cdc25cp1)
(available_cdk1p2p3-cycb)
)
:effect
(and
(available_cdk1p3-cycb)
(not (available_cdk1p2p3-cycb))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDK1P2P3-CYCB_CDC25CP1P2_CDK1P3-CYCB
:parameters ()
:precondition
(and
(available_cdc25cp1p2)
(available_cdk1p2p3-cycb)
)
:effect
(and
(available_cdk1p3-cycb)
(not (available_cdk1p2p3-cycb))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDK1P3-CYCA_WEE1_CDK1P2P3-CYCA
:parameters ()
:precondition
(and
(available_wee1)
(available_cdk1p3-cyca)
)
:effect
(and
(available_cdk1p2p3-cyca)
(not (available_cdk1p3-cyca))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDK1P3-CYCB_WEE1_CDK1P2P3-CYCB
:parameters ()
:precondition
(and
(available_wee1)
(available_cdk1p3-cycb)
)
:effect
(and
(available_cdk1p2p3-cycb)
(not (available_cdk1p3-cycb))
)
)
(:action ASSOCIATE-WITH-CATALYZE_WEE1_CDK1P3-CYCA_WEE1P1
:parameters ()
:precondition
(and
(available_cdk1p3-cyca)
(available_wee1)
)
:effect
(and
(available_wee1p1)
(not (available_wee1))
)
)
(:action ASSOCIATE-WITH-CATALYZE_WEE1_CDK1P3-CYCB_WEE1P1
:parameters ()
:precondition
(and
(available_cdk1p3-cycb)
(available_wee1)
)
:effect
(and
(available_wee1p1)
(not (available_wee1))
)
)
(:action ASSOCIATE_CDK1_CKS1_CDK1-CKS1
:parameters ()
:precondition
(and
(available_cks1)
(available_cdk1)
)
:effect
(and
(available_cdk1-cks1)
(not (available_cdk1))
(not (available_cks1))
)
)
(:action ASSOCIATE_CDK1_GADD45_CDK1-GADD45
:parameters ()
:precondition
(and
(available_gadd45)
(available_cdk1)
)
:effect
(and
(available_cdk1-gadd45)
(not (available_cdk1))
(not (available_gadd45))
)
)
(:action ASSOCIATE_CDK1P1_CKS1_CDK1P1-CKS1
:parameters ()
:precondition
(and
(available_cks1)
(available_cdk1p1)
)
:effect
(and
(available_cdk1p1-cks1)
(not (available_cdk1p1))
(not (available_cks1))
)
)
(:action ASSOCIATE_CDK1P1_GADD45_CDK1P1-GADD45
:parameters ()
:precondition
(and
(available_gadd45)
(available_cdk1p1)
)
:effect
(and
(available_cdk1p1-gadd45)
(not (available_cdk1p1))
(not (available_gadd45))
)
)
(:action ASSOCIATE_CDK1P1P3_CKS1_CDK1P1P3-CKS1
:parameters ()
:precondition
(and
(available_cks1)
(available_cdk1p1p3)
)
:effect
(and
(available_cdk1p1p3-cks1)
(not (available_cdk1p1p3))
(not (available_cks1))
)
)
(:action ASSOCIATE_CDK1P1P3_CYCA_CDK1P1P3-CYCA
:parameters ()
:precondition
(and
(available_cyca)
(available_cdk1p1p3)
)
:effect
(and
(available_cdk1p1p3-cyca)
(not (available_cdk1p1p3))
(not (available_cyca))
)
)
(:action ASSOCIATE_CDK1P1P3_CYCB_CDK1P1P3-CYCB
:parameters ()
:precondition
(and
(available_cycb)
(available_cdk1p1p3)
)
:effect
(and
(available_cdk1p1p3-cycb)
(not (available_cdk1p1p3))
(not (available_cycb))
)
)
(:action ASSOCIATE_CDK1P1P3_GADD45_CDK1P1P3-GADD45
:parameters ()
:precondition
(and
(available_gadd45)
(available_cdk1p1p3)
)
:effect
(and
(available_cdk1p1p3-gadd45)
(not (available_cdk1p1p3))
(not (available_gadd45))
)
)
(:action ASSOCIATE_CDK1P2_CKS1_CDK1P2-CKS1
:parameters ()
:precondition
(and
(available_cks1)
(available_cdk1p2)
)
:effect
(and
(available_cdk1p2-cks1)
(not (available_cdk1p2))
(not (available_cks1))
)
)
(:action ASSOCIATE_CDK1P2_GADD45_CDK1P2-GADD45
:parameters ()
:precondition
(and
(available_gadd45)
(available_cdk1p2)
)
:effect
(and
(available_cdk1p2-gadd45)
(not (available_cdk1p2))
(not (available_gadd45))
)
)
(:action ASSOCIATE_CDK1P2P3_CKS1_CDK1P2P3-CKS1
:parameters ()
:precondition
(and
(available_cks1)
(available_cdk1p2p3)
)
:effect
(and
(available_cdk1p2p3-cks1)
(not (available_cdk1p2p3))
(not (available_cks1))
)
)
(:action ASSOCIATE_CDK1P2P3_CYCA_CDK1P2P3-CYCA
:parameters ()
:precondition
(and
(available_cyca)
(available_cdk1p2p3)
)
:effect
(and
(available_cdk1p2p3-cyca)
(not (available_cdk1p2p3))
(not (available_cyca))
)
)
(:action ASSOCIATE_CDK1P2P3_CYCB_CDK1P2P3-CYCB
:parameters ()
:precondition
(and
(available_cycb)
(available_cdk1p2p3)
)
:effect
(and
(available_cdk1p2p3-cycb)
(not (available_cdk1p2p3))
(not (available_cycb))
)
)
(:action ASSOCIATE_CDK1P2P3_GADD45_CDK1P2P3-GADD45
:parameters ()
:precondition
(and
(available_gadd45)
(available_cdk1p2p3)
)
:effect
(and
(available_cdk1p2p3-gadd45)
(not (available_cdk1p2p3))
(not (available_gadd45))
)
)
(:action ASSOCIATE_CDK1P3_CKS1_CDK1P3-CKS1
:parameters ()
:precondition
(and
(available_cks1)
(available_cdk1p3)
)
:effect
(and
(available_cdk1p3-cks1)
(not (available_cdk1p3))
(not (available_cks1))
)
)
(:action ASSOCIATE_CDK1P3_CYCA_CDK1P3-CYCA
:parameters ()
:precondition
(and
(available_cyca)
(available_cdk1p3)
)
:effect
(and
(available_cdk1p3-cyca)
(not (available_cdk1p3))
(not (available_cyca))
)
)
(:action ASSOCIATE_CDK1P3_CYCB_CDK1P3-CYCB
:parameters ()
:precondition
(and
(available_cycb)
(available_cdk1p3)
)
:effect
(and
(available_cdk1p3-cycb)
(not (available_cdk1p3))
(not (available_cycb))
)
)
(:action ASSOCIATE_CDK1P3_GADD45_CDK1P3-GADD45
:parameters ()
:precondition
(and
(available_gadd45)
(available_cdk1p3)
)
:effect
(and
(available_cdk1p3-gadd45)
(not (available_cdk1p3))
(not (available_gadd45))
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
(:action ASSOCIATE_CDK2P1P2-CYCA_E2F13_CDK2P1P2-CYCA-E2F13
:parameters ()
:precondition
(and
(available_e2f13)
(available_cdk2p1p2-cyca)
)
:effect
(and
(available_cdk2p1p2-cyca-e2f13)
(not (available_cdk2p1p2-cyca))
(not (available_e2f13))
)
)
(:action ASSOCIATE_P21_CDK2P1-CYCA_P21-CDK2P1-CYCA
:parameters ()
:precondition
(and
(available_cdk2p1-cyca)
(available_p21)
)
:effect
(and
(available_p21-cdk2p1-cyca)
(not (available_p21))
(not (available_cdk2p1-cyca))
)
)
(:action ASSOCIATE_P21_CDK2P1-CYCEP1_P21-CDK2P1-CYCEP1
:parameters ()
:precondition
(and
(available_cdk2p1-cycep1)
(available_p21)
)
:effect
(and
(available_p21-cdk2p1-cycep1)
(not (available_p21))
(not (available_cdk2p1-cycep1))
)
)
(:action ASSOCIATE_P21_CDK2P1-CYCE_P21-CDK2P1-CYCE
:parameters ()
:precondition
(and
(available_cdk2p1-cyce)
(available_p21)
)
:effect
(and
(available_p21-cdk2p1-cyce)
(not (available_p21))
(not (available_cdk2p1-cyce))
)
)
(:action ASSOCIATE_P21_CDK2P1P2-CYCA_P21-CDK2P1P2-CYCA
:parameters ()
:precondition
(and
(available_cdk2p1p2-cyca)
(available_p21)
)
:effect
(and
(available_p21-cdk2p1p2-cyca)
(not (available_p21))
(not (available_cdk2p1p2-cyca))
)
)
(:action ASSOCIATE_P21_CDK2P1P2-CYCEP1_P21-CDK2P1P2-CYCEP1
:parameters ()
:precondition
(and
(available_cdk2p1p2-cycep1)
(available_p21)
)
:effect
(and
(available_p21-cdk2p1p2-cycep1)
(not (available_p21))
(not (available_cdk2p1p2-cycep1))
)
)
(:action ASSOCIATE_P21_CDK2P1P2-CYCE_P21-CDK2P1P2-CYCE
:parameters ()
:precondition
(and
(available_cdk2p1p2-cyce)
(available_p21)
)
:effect
(and
(available_p21-cdk2p1p2-cyce)
(not (available_p21))
(not (available_cdk2p1p2-cyce))
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
(:action ASSOCIATE_P27_CDK2P1P2-CYCA_P27-CDK2P1P2-CYCA
:parameters ()
:precondition
(and
(available_cdk2p1p2-cyca)
(available_p27)
)
:effect
(and
(available_p27-cdk2p1p2-cyca)
(not (available_p27))
(not (available_cdk2p1p2-cyca))
)
)
(:action ASSOCIATE_P27_CDK2P1P2-CYCEP1_P27-CDK2P1P2-CYCEP1
:parameters ()
:precondition
(and
(available_cdk2p1p2-cycep1)
(available_p27)
)
:effect
(and
(available_p27-cdk2p1p2-cycep1)
(not (available_p27))
(not (available_cdk2p1p2-cycep1))
)
)
(:action ASSOCIATE_P27_CDK2P1P2-CYCE_P27-CDK2P1P2-CYCE
:parameters ()
:precondition
(and
(available_cdk2p1p2-cyce)
(available_p27)
)
:effect
(and
(available_p27-cdk2p1p2-cyce)
(not (available_p27))
(not (available_cdk2p1p2-cyce))
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
(:action ASSOCIATE_P57_CDK2P1P2-CYCA_P57-CDK2P1P2-CYCA
:parameters ()
:precondition
(and
(available_cdk2p1p2-cyca)
(available_p57)
)
:effect
(and
(available_p57-cdk2p1p2-cyca)
(not (available_p57))
(not (available_cdk2p1p2-cyca))
)
)
(:action ASSOCIATE_P57_CDK2P1P2-CYCEP1_P57-CDK2P1P2-CYCEP1
:parameters ()
:precondition
(and
(available_cdk2p1p2-cycep1)
(available_p57)
)
:effect
(and
(available_p57-cdk2p1p2-cycep1)
(not (available_p57))
(not (available_cdk2p1p2-cycep1))
)
)
(:action ASSOCIATE_P57_CDK2P1P2-CYCE_P57-CDK2P1P2-CYCE
:parameters ()
:precondition
(and
(available_cdk2p1p2-cyce)
(available_p57)
)
:effect
(and
(available_p57-cdk2p1p2-cyce)
(not (available_p57))
(not (available_cdk2p1p2-cyce))
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
(:action ASSOCIATE_SKP2_CDK2P1P2-CYCA_SKP2-CDK2P1P2-CYCA
:parameters ()
:precondition
(and
(available_cdk2p1p2-cyca)
(available_skp2)
)
:effect
(and
(available_skp2-cdk2p1p2-cyca)
(not (available_skp2))
(not (available_cdk2p1p2-cyca))
)
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
(:action CHOOSE_CDK46P3-CYCDP1_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_cdk46p3-cycdp1)
)
:effect
(and
(chosen_cdk46p3-cycdp1)
(num-subs_l3)
(not (not-chosen_cdk46p3-cycdp1))
(not (num-subs_l2))
)
)
(:action CHOOSE_CDK7_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_cdk7)
)
:effect
(and
(chosen_cdk7)
(num-subs_l3)
(not (not-chosen_cdk7))
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
(:action CHOOSE_CYCB_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_cycb)
)
:effect
(and
(chosen_cycb)
(num-subs_l3)
(not (not-chosen_cycb))
(not (num-subs_l2))
)
)
(:action CHOOSE_CYCH_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_cych)
)
:effect
(and
(chosen_cych)
(num-subs_l3)
(not (not-chosen_cych))
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
(:action CHOOSE_E2F13-DP12P1_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_e2f13-dp12p1)
)
:effect
(and
(chosen_e2f13-dp12p1)
(num-subs_l3)
(not (not-chosen_e2f13-dp12p1))
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
(:action CHOOSE_E2F13P1-DP12P1_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_e2f13p1-dp12p1)
)
:effect
(and
(chosen_e2f13p1-dp12p1)
(num-subs_l3)
(not (not-chosen_e2f13p1-dp12p1))
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
(:action CHOOSE_GE-C_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_ge-c)
)
:effect
(and
(chosen_ge-c)
(num-subs_l3)
(not (not-chosen_ge-c))
(not (num-subs_l2))
)
)
(:action CHOOSE_GERCC1_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_gercc1)
)
:effect
(and
(chosen_gercc1)
(num-subs_l3)
(not (not-chosen_gercc1))
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
(:action CHOOSE_HDAC1-P107-E2F4P1-DP12_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_hdac1-p107-e2f4p1-dp12)
)
:effect
(and
(chosen_hdac1-p107-e2f4p1-dp12)
(num-subs_l3)
(not (not-chosen_hdac1-p107-e2f4p1-dp12))
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
(:action CHOOSE_P53_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_p53)
)
:effect
(and
(chosen_p53)
(num-subs_l3)
(not (not-chosen_p53))
(not (num-subs_l2))
)
)
(:action CHOOSE_P53P1_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_p53p1)
)
:effect
(and
(chosen_p53p1)
(num-subs_l3)
(not (not-chosen_p53p1))
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
(:action dummy-action-18-2
:parameters ()
:precondition
(and
(available_dmp1p1-cycdp1)
)
:effect
(and
(goal18_)
)
)
(:action dummy-action-14-2
:parameters ()
:precondition
(and
(available_prbp1-ap2-ge-c)
)
:effect
(and
(goal14_)
)
)
(:action dummy-action-12-1
:parameters ()
:precondition
(and
(available_cdk2p1-cyca)
)
:effect
(and
(goal12_)
)
)
(:action dummy-action-12-2
:parameters ()
:precondition
(and
(available_cdk1p2p3-cycb)
)
:effect
(and
(goal12_)
)
)
(:action dummy-action-11-2
:parameters ()
:precondition
(and
(available_cdk1p3)
)
:effect
(and
(goal11_)
)
)
(:action dummy-action-10-2
:parameters ()
:precondition
(and
(available_cdk1p1p2p3-cycb)
)
:effect
(and
(goal10_)
)
)
(:action dummy-action-9-2
:parameters ()
:precondition
(and
(available_cdk2p1p2-cycep1)
)
:effect
(and
(goal9_)
)
)
(:action dummy-action-8-1
:parameters ()
:precondition
(and
(available_prbp1-jun-c-fos-gercc1)
)
:effect
(and
(goal8_)
)
)
(:action dummy-action-8-2
:parameters ()
:precondition
(and
(available_cdk1p1p2p3-gadd45)
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
(available_cdk1p1p3-cycb)
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
(available_cdk2p1-cyce)
)
:effect
(and
(goal7_)
)
)
(:action dummy-action-6-2
:parameters ()
:precondition
(and
(available_cdk1p2p3-cyca)
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
(available_mdm2-e2f13-dp12)
)
:effect
(and
(goal5_)
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
(:action SYNTHESIZE_JUN-C-FOS-GERCC1_ERCC1
:parameters ()
:precondition
(and
(available_jun-c-fos-gercc1)
)
:effect
(and
(available_ercc1)
)
)
(:action SYNTHESIZE_PRB-JUN-C-FOS-GERCC1_ERCC1
:parameters ()
:precondition
(and
(available_prb-jun-c-fos-gercc1)
)
:effect
(and
(available_ercc1)
)
)
(:action SYNTHESIZE_PRBP1-AP2-GE-C_ECADHERIN
:parameters ()
:precondition
(and
(available_prbp1-ap2-ge-c)
)
:effect
(and
(available_ecadherin)
)
)
(:action SYNTHESIZE_PRBP1-JUN-C-FOS-GERCC1_ERCC1
:parameters ()
:precondition
(and
(available_prbp1-jun-c-fos-gercc1)
)
:effect
(and
(available_ercc1)
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDC25CP2_PLK1_CDC25CP1P2
:parameters ()
:precondition
(and
(available_plk1)
(available_cdc25cp2)
)
:effect
(and
(available_cdc25cp1p2)
(not (available_cdc25cp2))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDK1_CDK7-CYCH_CDK1P3
:parameters ()
:precondition
(and
(available_cdk7-cych)
(available_cdk1)
)
:effect
(and
(available_cdk1p3)
(not (available_cdk1))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDK1P1_CDC25CP1_CDK1
:parameters ()
:precondition
(and
(available_cdc25cp1)
(available_cdk1p1)
)
:effect
(and
(available_cdk1)
(not (available_cdk1p1))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDK1P1_CDC25CP1P2_CDK1
:parameters ()
:precondition
(and
(available_cdc25cp1p2)
(available_cdk1p1)
)
:effect
(and
(available_cdk1)
(not (available_cdk1p1))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDK1P1_CDK7-CYCH_CDK1P1P3
:parameters ()
:precondition
(and
(available_cdk7-cych)
(available_cdk1p1)
)
:effect
(and
(available_cdk1p1p3)
(not (available_cdk1p1))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDK1P1P2_CDC25CP1_CDK1P1
:parameters ()
:precondition
(and
(available_cdc25cp1)
(available_cdk1p1p2)
)
:effect
(and
(available_cdk1p1)
(not (available_cdk1p1p2))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDK1P1P2_CDC25CP1_CDK1P2
:parameters ()
:precondition
(and
(available_cdc25cp1)
(available_cdk1p1p2)
)
:effect
(and
(available_cdk1p2)
(not (available_cdk1p1p2))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDK1P1P2_CDC25CP1P2_CDK1P1
:parameters ()
:precondition
(and
(available_cdc25cp1p2)
(available_cdk1p1p2)
)
:effect
(and
(available_cdk1p1)
(not (available_cdk1p1p2))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDK1P1P2_CDC25CP1P2_CDK1P2
:parameters ()
:precondition
(and
(available_cdc25cp1p2)
(available_cdk1p1p2)
)
:effect
(and
(available_cdk1p2)
(not (available_cdk1p1p2))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDK1P1P2P3_CDC25CP1_CDK1P1P3
:parameters ()
:precondition
(and
(available_cdc25cp1)
(available_cdk1p1p2p3)
)
:effect
(and
(available_cdk1p1p3)
(not (available_cdk1p1p2p3))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDK1P1P2P3_CDC25CP1_CDK1P2P3
:parameters ()
:precondition
(and
(available_cdc25cp1)
(available_cdk1p1p2p3)
)
:effect
(and
(available_cdk1p2p3)
(not (available_cdk1p1p2p3))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDK1P1P2P3_CDC25CP1P2_CDK1P1P3
:parameters ()
:precondition
(and
(available_cdc25cp1p2)
(available_cdk1p1p2p3)
)
:effect
(and
(available_cdk1p1p3)
(not (available_cdk1p1p2p3))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDK1P1P2P3_CDC25CP1P2_CDK1P2P3
:parameters ()
:precondition
(and
(available_cdc25cp1p2)
(available_cdk1p1p2p3)
)
:effect
(and
(available_cdk1p2p3)
(not (available_cdk1p1p2p3))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDK1P1P2P3-CYCA_CDC25CP1_CDK1P1P3-CYCA
:parameters ()
:precondition
(and
(available_cdc25cp1)
(available_cdk1p1p2p3-cyca)
)
:effect
(and
(available_cdk1p1p3-cyca)
(not (available_cdk1p1p2p3-cyca))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDK1P1P2P3-CYCA_CDC25CP1_CDK1P2P3-CYCA
:parameters ()
:precondition
(and
(available_cdc25cp1)
(available_cdk1p1p2p3-cyca)
)
:effect
(and
(available_cdk1p2p3-cyca)
(not (available_cdk1p1p2p3-cyca))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDK1P1P2P3-CYCA_CDC25CP1P2_CDK1P1P3-CYCA
:parameters ()
:precondition
(and
(available_cdc25cp1p2)
(available_cdk1p1p2p3-cyca)
)
:effect
(and
(available_cdk1p1p3-cyca)
(not (available_cdk1p1p2p3-cyca))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDK1P1P2P3-CYCA_CDC25CP1P2_CDK1P2P3-CYCA
:parameters ()
:precondition
(and
(available_cdc25cp1p2)
(available_cdk1p1p2p3-cyca)
)
:effect
(and
(available_cdk1p2p3-cyca)
(not (available_cdk1p1p2p3-cyca))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDK1P1P2P3-CYCB_CDC25CP1_CDK1P1P3-CYCB
:parameters ()
:precondition
(and
(available_cdc25cp1)
(available_cdk1p1p2p3-cycb)
)
:effect
(and
(available_cdk1p1p3-cycb)
(not (available_cdk1p1p2p3-cycb))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDK1P1P2P3-CYCB_CDC25CP1_CDK1P2P3-CYCB
:parameters ()
:precondition
(and
(available_cdc25cp1)
(available_cdk1p1p2p3-cycb)
)
:effect
(and
(available_cdk1p2p3-cycb)
(not (available_cdk1p1p2p3-cycb))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDK1P1P2P3-CYCB_CDC25CP1P2_CDK1P1P3-CYCB
:parameters ()
:precondition
(and
(available_cdc25cp1p2)
(available_cdk1p1p2p3-cycb)
)
:effect
(and
(available_cdk1p1p3-cycb)
(not (available_cdk1p1p2p3-cycb))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDK1P1P2P3-CYCB_CDC25CP1P2_CDK1P2P3-CYCB
:parameters ()
:precondition
(and
(available_cdc25cp1p2)
(available_cdk1p1p2p3-cycb)
)
:effect
(and
(available_cdk1p2p3-cycb)
(not (available_cdk1p1p2p3-cycb))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDK2P1-CYCA_CDK7-CYCH_CDK2P1P2-CYCA
:parameters ()
:precondition
(and
(available_cdk7-cych)
(available_cdk2p1-cyca)
)
:effect
(and
(available_cdk2p1p2-cyca)
(not (available_cdk2p1-cyca))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDK2P1-CYCE_CDK7-CYCH_CDK2P1P2-CYCE
:parameters ()
:precondition
(and
(available_cdk7-cych)
(available_cdk2p1-cyce)
)
:effect
(and
(available_cdk2p1p2-cyce)
(not (available_cdk2p1-cyce))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDK2P1-CYCEP1_CDK7-CYCH_CDK2P1P2-CYCEP1
:parameters ()
:precondition
(and
(available_cdk7-cych)
(available_cdk2p1-cycep1)
)
:effect
(and
(available_cdk2p1p2-cycep1)
(not (available_cdk2p1-cycep1))
)
)
(:action ASSOCIATE_C-ABL_PRBP1_C-ABL-PRBP1
:parameters ()
:precondition
(and
(available_prbp1)
(available_c-abl)
)
:effect
(and
(available_c-abl-prbp1)
(not (available_c-abl))
(not (available_prbp1))
)
)
(:action ASSOCIATE_CDK1P1P2_GADD45_CDK1P1P2-GADD45
:parameters ()
:precondition
(and
(available_gadd45)
(available_cdk1p1p2)
)
:effect
(and
(available_cdk1p1p2-gadd45)
(not (available_cdk1p1p2))
(not (available_gadd45))
)
)
(:action ASSOCIATE_CDK1P1P2P3_CKS1_CDK1P1P2P3-CKS1
:parameters ()
:precondition
(and
(available_cks1)
(available_cdk1p1p2p3)
)
:effect
(and
(available_cdk1p1p2p3-cks1)
(not (available_cdk1p1p2p3))
(not (available_cks1))
)
)
(:action ASSOCIATE_CDK1P1P2P3_CYCA_CDK1P1P2P3-CYCA
:parameters ()
:precondition
(and
(available_cyca)
(available_cdk1p1p2p3)
)
:effect
(and
(available_cdk1p1p2p3-cyca)
(not (available_cdk1p1p2p3))
(not (available_cyca))
)
)
(:action ASSOCIATE_CDK1P1P2P3_CYCB_CDK1P1P2P3-CYCB
:parameters ()
:precondition
(and
(available_cycb)
(available_cdk1p1p2p3)
)
:effect
(and
(available_cdk1p1p2p3-cycb)
(not (available_cdk1p1p2p3))
(not (available_cycb))
)
)
(:action ASSOCIATE_CDK1P1P2P3_GADD45_CDK1P1P2P3-GADD45
:parameters ()
:precondition
(and
(available_gadd45)
(available_cdk1p1p2p3)
)
:effect
(and
(available_cdk1p1p2p3-gadd45)
(not (available_cdk1p1p2p3))
(not (available_gadd45))
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
(:action ASSOCIATE_CDK2P1P2_CKS1_CDK2P1P2-CKS1
:parameters ()
:precondition
(and
(available_cks1)
(available_cdk2p1p2)
)
:effect
(and
(available_cdk2p1p2-cks1)
(not (available_cdk2p1p2))
(not (available_cks1))
)
)
(:action ASSOCIATE_CDK2P1P2_CYCA_CDK2P1P2-CYCA
:parameters ()
:precondition
(and
(available_cyca)
(available_cdk2p1p2)
)
:effect
(and
(available_cdk2p1p2-cyca)
(not (available_cdk2p1p2))
(not (available_cyca))
)
)
(:action ASSOCIATE_CDK2P1P2_CYCE_CDK2P1P2-CYCE
:parameters ()
:precondition
(and
(available_cyce)
(available_cdk2p1p2)
)
:effect
(and
(available_cdk2p1p2-cyce)
(not (available_cdk2p1p2))
(not (available_cyce))
)
)
(:action ASSOCIATE_CDK2P1P2_CYCEP1_CDK2P1P2-CYCEP1
:parameters ()
:precondition
(and
(available_cycep1)
(available_cdk2p1p2)
)
:effect
(and
(available_cdk2p1p2-cycep1)
(not (available_cdk2p1p2))
(not (available_cycep1))
)
)
(:action ASSOCIATE_CDK7P1_CYCH_CDK7P1-CYCH
:parameters ()
:precondition
(and
(available_cych)
(available_cdk7p1)
)
:effect
(and
(available_cdk7p1-cych)
(not (available_cdk7p1))
(not (available_cych))
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
(:action ASSOCIATE_JUN-C-FOS_GERCC1_JUN-C-FOS-GERCC1
:parameters ()
:precondition
(and
(available_gercc1)
(available_jun-c-fos)
)
:effect
(and
(available_jun-c-fos-gercc1)
(not (available_jun-c-fos))
(not (available_gercc1))
)
)
(:action ASSOCIATE_JUN_C-FOS_JUN-C-FOS
:parameters ()
:precondition
(and
(available_c-fos)
(available_jun)
)
:effect
(and
(available_jun-c-fos)
(not (available_jun))
(not (available_c-fos))
)
)
(:action ASSOCIATE_M1433_CDC25CP1P2_M1433-CDC25CP1P2
:parameters ()
:precondition
(and
(available_cdc25cp1p2)
(available_m1433)
)
:effect
(and
(available_m1433-cdc25cp1p2)
(not (available_m1433))
(not (available_cdc25cp1p2))
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
(:action ASSOCIATE_MDM2_E2F13-DP12_MDM2-E2F13-DP12
:parameters ()
:precondition
(and
(available_e2f13-dp12)
(available_mdm2)
)
:effect
(and
(available_mdm2-e2f13-dp12)
(not (available_mdm2))
(not (available_e2f13-dp12))
)
)
(:action ASSOCIATE_MDM2_E2F13-DP12P1_MDM2-E2F13-DP12P1
:parameters ()
:precondition
(and
(available_e2f13-dp12p1)
(available_mdm2)
)
:effect
(and
(available_mdm2-e2f13-dp12p1)
(not (available_mdm2))
(not (available_e2f13-dp12p1))
)
)
(:action ASSOCIATE_MDM2_E2F13P1-DP12_MDM2-E2F13P1-DP12
:parameters ()
:precondition
(and
(available_e2f13p1-dp12)
(available_mdm2)
)
:effect
(and
(available_mdm2-e2f13p1-dp12)
(not (available_mdm2))
(not (available_e2f13p1-dp12))
)
)
(:action ASSOCIATE_MDM2_E2F13P1-DP12P1_MDM2-E2F13P1-DP12P1
:parameters ()
:precondition
(and
(available_e2f13p1-dp12p1)
(available_mdm2)
)
:effect
(and
(available_mdm2-e2f13p1-dp12p1)
(not (available_mdm2))
(not (available_e2f13p1-dp12p1))
)
)
(:action ASSOCIATE_MDM2_PRB_MDM2-PRB
:parameters ()
:precondition
(and
(available_prb)
(available_mdm2)
)
:effect
(and
(available_mdm2-prb)
(not (available_mdm2))
(not (available_prb))
)
)
(:action ASSOCIATE_MDM2_PRBP1_MDM2-PRBP1
:parameters ()
:precondition
(and
(available_prbp1)
(available_mdm2)
)
:effect
(and
(available_mdm2-prbp1)
(not (available_mdm2))
(not (available_prbp1))
)
)
(:action ASSOCIATE_P21_GADD45_P21-GADD45
:parameters ()
:precondition
(and
(available_gadd45)
(available_p21)
)
:effect
(and
(available_p21-gadd45)
(not (available_p21))
(not (available_gadd45))
)
)
(:action ASSOCIATE_PRB-JUN-C-FOS_GERCC1_PRB-JUN-C-FOS-GERCC1
:parameters ()
:precondition
(and
(available_gercc1)
(available_prb-jun-c-fos)
)
:effect
(and
(available_prb-jun-c-fos-gercc1)
(not (available_prb-jun-c-fos))
(not (available_gercc1))
)
)
(:action ASSOCIATE_PRB-JUN_C-FOS_PRB-JUN-C-FOS
:parameters ()
:precondition
(and
(available_c-fos)
(available_prb-jun)
)
:effect
(and
(available_prb-jun-c-fos)
(not (available_prb-jun))
(not (available_c-fos))
)
)
(:action ASSOCIATE_PRBP1-AP2_GE-C_PRBP1-AP2-GE-C
:parameters ()
:precondition
(and
(available_ge-c)
(available_prbp1-ap2)
)
:effect
(and
(available_prbp1-ap2-ge-c)
(not (available_prbp1-ap2))
(not (available_ge-c))
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
(:action ASSOCIATE_PRBP1-E2F13-DP12_GE2_PRBP1-E2F13-DP12-GE2
:parameters ()
:precondition
(and
(available_ge2)
(available_prbp1-e2f13-dp12)
)
:effect
(and
(available_prbp1-e2f13-dp12-ge2)
(not (available_prbp1-e2f13-dp12))
(not (available_ge2))
)
)
(:action ASSOCIATE_PRBP1-E2F13-DP12P1_GE2_PRBP1-E2F13-DP12P1-GE2
:parameters ()
:precondition
(and
(available_ge2)
(available_prbp1-e2f13-dp12p1)
)
:effect
(and
(available_prbp1-e2f13-dp12p1-ge2)
(not (available_prbp1-e2f13-dp12p1))
(not (available_ge2))
)
)
(:action ASSOCIATE_PRBP1_E2F13-DP12P1_PRBP1-E2F13-DP12P1
:parameters ()
:precondition
(and
(available_e2f13-dp12p1)
(available_prbp1)
)
:effect
(and
(available_prbp1-e2f13-dp12p1)
(not (available_prbp1))
(not (available_e2f13-dp12p1))
)
)
(:action ASSOCIATE_PRBP1_E2F13-DP12_PRBP1-E2F13-DP12
:parameters ()
:precondition
(and
(available_e2f13-dp12)
(available_prbp1)
)
:effect
(and
(available_prbp1-e2f13-dp12)
(not (available_prbp1))
(not (available_e2f13-dp12))
)
)
(:action ASSOCIATE_PRBP1-E2F13P1-DP12_GE2_PRBP1-E2F13P1-DP12-GE2
:parameters ()
:precondition
(and
(available_ge2)
(available_prbp1-e2f13p1-dp12)
)
:effect
(and
(available_prbp1-e2f13p1-dp12-ge2)
(not (available_prbp1-e2f13p1-dp12))
(not (available_ge2))
)
)
(:action ASSOCIATE_PRBP1-E2F13P1-DP12P1_GE2_PRBP1-E2F13P1-DP12P1-GE2
:parameters ()
:precondition
(and
(available_ge2)
(available_prbp1-e2f13p1-dp12p1)
)
:effect
(and
(available_prbp1-e2f13p1-dp12p1-ge2)
(not (available_prbp1-e2f13p1-dp12p1))
(not (available_ge2))
)
)
(:action ASSOCIATE_PRBP1_E2F13P1-DP12P1_PRBP1-E2F13P1-DP12P1
:parameters ()
:precondition
(and
(available_e2f13p1-dp12p1)
(available_prbp1)
)
:effect
(and
(available_prbp1-e2f13p1-dp12p1)
(not (available_prbp1))
(not (available_e2f13p1-dp12p1))
)
)
(:action ASSOCIATE_PRBP1_E2F13P1-DP12_PRBP1-E2F13P1-DP12
:parameters ()
:precondition
(and
(available_e2f13p1-dp12)
(available_prbp1)
)
:effect
(and
(available_prbp1-e2f13p1-dp12)
(not (available_prbp1))
(not (available_e2f13p1-dp12))
)
)
(:action ASSOCIATE_PRBP1-JUN-C-FOS_GERCC1_PRBP1-JUN-C-FOS-GERCC1
:parameters ()
:precondition
(and
(available_gercc1)
(available_prbp1-jun-c-fos)
)
:effect
(and
(available_prbp1-jun-c-fos-gercc1)
(not (available_prbp1-jun-c-fos))
(not (available_gercc1))
)
)
(:action ASSOCIATE_PRBP1-JUN_C-FOS_PRBP1-JUN-C-FOS
:parameters ()
:precondition
(and
(available_c-fos)
(available_prbp1-jun)
)
:effect
(and
(available_prbp1-jun-c-fos)
(not (available_prbp1-jun))
(not (available_c-fos))
)
)
(:action ASSOCIATE_PRBP1_JUN_PRBP1-JUN
:parameters ()
:precondition
(and
(available_jun)
(available_prbp1)
)
:effect
(and
(available_prbp1-jun)
(not (available_prbp1))
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
(:action CHOOSE_CDK46P3-CYCDP1_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_cdk46p3-cycdp1)
)
:effect
(and
(chosen_cdk46p3-cycdp1)
(num-subs_l2)
(not (not-chosen_cdk46p3-cycdp1))
(not (num-subs_l1))
)
)
(:action CHOOSE_CDK7_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_cdk7)
)
:effect
(and
(chosen_cdk7)
(num-subs_l2)
(not (not-chosen_cdk7))
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
(:action CHOOSE_CYCB_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_cycb)
)
:effect
(and
(chosen_cycb)
(num-subs_l2)
(not (not-chosen_cycb))
(not (num-subs_l1))
)
)
(:action CHOOSE_CYCH_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_cych)
)
:effect
(and
(chosen_cych)
(num-subs_l2)
(not (not-chosen_cych))
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
(:action CHOOSE_E2F13-DP12P1_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_e2f13-dp12p1)
)
:effect
(and
(chosen_e2f13-dp12p1)
(num-subs_l2)
(not (not-chosen_e2f13-dp12p1))
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
(:action CHOOSE_E2F13P1-DP12P1_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_e2f13p1-dp12p1)
)
:effect
(and
(chosen_e2f13p1-dp12p1)
(num-subs_l2)
(not (not-chosen_e2f13p1-dp12p1))
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
(:action CHOOSE_GE-C_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_ge-c)
)
:effect
(and
(chosen_ge-c)
(num-subs_l2)
(not (not-chosen_ge-c))
(not (num-subs_l1))
)
)
(:action CHOOSE_GERCC1_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_gercc1)
)
:effect
(and
(chosen_gercc1)
(num-subs_l2)
(not (not-chosen_gercc1))
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
(:action CHOOSE_HDAC1-P107-E2F4P1-DP12_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_hdac1-p107-e2f4p1-dp12)
)
:effect
(and
(chosen_hdac1-p107-e2f4p1-dp12)
(num-subs_l2)
(not (not-chosen_hdac1-p107-e2f4p1-dp12))
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
(:action CHOOSE_P53_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_p53)
)
:effect
(and
(chosen_p53)
(num-subs_l2)
(not (not-chosen_p53))
(not (num-subs_l1))
)
)
(:action CHOOSE_P53P1_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_p53p1)
)
:effect
(and
(chosen_p53p1)
(num-subs_l2)
(not (not-chosen_p53p1))
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
(:action dummy-action-17-2
:parameters ()
:precondition
(and
(available_hdac1-prb-e2f13p1-dp12-ge2)
)
:effect
(and
(goal17_)
)
)
(:action SYNTHESIZE_AP2-GE-C_ECADHERIN
:parameters ()
:precondition
(and
(available_ap2-ge-c)
)
:effect
(and
(available_ecadherin)
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
(:action SYNTHESIZE_P53_C-FOS
:parameters ()
:precondition
(and
(available_p53)
)
:effect
(and
(available_c-fos)
)
)
(:action SYNTHESIZE_P53_GADD45
:parameters ()
:precondition
(and
(available_p53)
)
:effect
(and
(available_gadd45)
)
)
(:action SYNTHESIZE_P53_MDM2
:parameters ()
:precondition
(and
(available_p53)
)
:effect
(and
(available_mdm2)
)
)
(:action SYNTHESIZE_P53P1_C-FOS
:parameters ()
:precondition
(and
(available_p53p1)
)
:effect
(and
(available_c-fos)
)
)
(:action SYNTHESIZE_P53P1_GADD45
:parameters ()
:precondition
(and
(available_p53p1)
)
:effect
(and
(available_gadd45)
)
)
(:action SYNTHESIZE_P53P1_MDM2
:parameters ()
:precondition
(and
(available_p53p1)
)
:effect
(and
(available_mdm2)
)
)
(:action SYNTHESIZE_P53P1_P21
:parameters ()
:precondition
(and
(available_p53p1)
)
:effect
(and
(available_p21)
)
)
(:action SYNTHESIZE_P53_P21
:parameters ()
:precondition
(and
(available_p53)
)
:effect
(and
(available_p21)
)
)
(:action SYNTHESIZE_PRB-AP2-GE-C_ECADHERIN
:parameters ()
:precondition
(and
(available_prb-ap2-ge-c)
)
:effect
(and
(available_ecadherin)
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
(:action ASSOCIATE-WITH-CATALYZE_CDC25CP1_CHK1_CDC25CP1P2
:parameters ()
:precondition
(and
(available_chk1)
(available_cdc25cp1)
)
:effect
(and
(available_cdc25cp1p2)
(not (available_cdc25cp1))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDC25CP1_C-TAK1_CDC25CP1P2
:parameters ()
:precondition
(and
(available_c-tak1)
(available_cdc25cp1)
)
:effect
(and
(available_cdc25cp1p2)
(not (available_cdc25cp1))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDC25C_PLK1_CDC25CP1
:parameters ()
:precondition
(and
(available_plk1)
(available_cdc25c)
)
:effect
(and
(available_cdc25cp1)
(not (available_cdc25c))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDK1P1P2_CDK7-CYCH_CDK1P1P2P3
:parameters ()
:precondition
(and
(available_cdk7-cych)
(available_cdk1p1p2)
)
:effect
(and
(available_cdk1p1p2p3)
(not (available_cdk1p1p2))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDK2P1_CDK7-CYCH_CDK2P1P2
:parameters ()
:precondition
(and
(available_cdk7-cych)
(available_cdk2p1)
)
:effect
(and
(available_cdk2p1p2)
(not (available_cdk2p1))
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
(:action ASSOCIATE-WITH-CATALYZE_CDK7_CDK7-CYCH_CDK7P1
:parameters ()
:precondition
(and
(available_cdk7-cych)
(available_cdk7)
)
:effect
(and
(available_cdk7p1)
(not (available_cdk7))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CDK7-CYCH_CDK7-CYCH_CDK7P1-CYCH
:parameters ()
:precondition
(and
(available_cdk7-cych)
)
:effect
(and
(available_cdk7p1-cych)
(not (available_cdk7-cych))
)
)
(:action ASSOCIATE-WITH-CATALYZE_CYCB_APCP1_APCP1
:parameters ()
:precondition
(and
(available_apcp1)
(available_cycb)
)
:effect
(and
(available_apcp1)
(not (available_cycb))
)
)
(:action ASSOCIATE-WITH-CATALYZE_DMP1_CDK46P3-CYCDP1_DMP1P1
:parameters ()
:precondition
(and
(available_cdk46p3-cycdp1)
(available_dmp1)
)
:effect
(and
(available_dmp1p1)
(not (available_dmp1))
)
)
(:action ASSOCIATE-WITH-CATALYZE_PRB_CDK46P3-CYCDP1_PRBP1
:parameters ()
:precondition
(and
(available_cdk46p3-cycdp1)
(available_prb)
)
:effect
(and
(available_prbp1)
(not (available_prb))
)
)
(:action ASSOCIATE_AP2_GE-C_AP2-GE-C
:parameters ()
:precondition
(and
(available_ge-c)
(available_ap2)
)
:effect
(and
(available_ap2-ge-c)
(not (available_ap2))
(not (available_ge-c))
)
)
(:action ASSOCIATE_C-ABL_PRB_C-ABL-PRB
:parameters ()
:precondition
(and
(available_prb)
(available_c-abl)
)
:effect
(and
(available_c-abl-prb)
(not (available_c-abl))
(not (available_prb))
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
(:action ASSOCIATE_CDK2P1_CKS1_CDK2P1-CKS1
:parameters ()
:precondition
(and
(available_cks1)
(available_cdk2p1)
)
:effect
(and
(available_cdk2p1-cks1)
(not (available_cdk2p1))
(not (available_cks1))
)
)
(:action ASSOCIATE_CDK7_CYCH_CDK7-CYCH
:parameters ()
:precondition
(and
(available_cych)
(available_cdk7)
)
:effect
(and
(available_cdk7-cych)
(not (available_cdk7))
(not (available_cych))
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
(:action ASSOCIATE_HDAC1-P107-E2F4P1-DP12_GE2_HDAC1-P107-E2F4P1-DP12-GE2
:parameters ()
:precondition
(and
(available_ge2)
(available_hdac1-p107-e2f4p1-dp12)
)
:effect
(and
(available_hdac1-p107-e2f4p1-dp12-ge2)
(not (available_hdac1-p107-e2f4p1-dp12))
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
(:action ASSOCIATE_HDAC1-PRB-E2F13-DP12_GE2_HDAC1-PRB-E2F13-DP12-GE2
:parameters ()
:precondition
(and
(available_ge2)
(available_hdac1-prb-e2f13-dp12)
)
:effect
(and
(available_hdac1-prb-e2f13-dp12-ge2)
(not (available_hdac1-prb-e2f13-dp12))
(not (available_ge2))
)
)
(:action ASSOCIATE_HDAC1_PRB-E2F13-DP12_HDAC1-PRB-E2F13-DP12
:parameters ()
:precondition
(and
(available_prb-e2f13-dp12)
(available_hdac1)
)
:effect
(and
(available_hdac1-prb-e2f13-dp12)
(not (available_hdac1))
(not (available_prb-e2f13-dp12))
)
)
(:action ASSOCIATE_HDAC1_PRB-E2F13-DP12P1_HDAC1-PRB-E2F13-DP12P1
:parameters ()
:precondition
(and
(available_prb-e2f13-dp12p1)
(available_hdac1)
)
:effect
(and
(available_hdac1-prb-e2f13-dp12p1)
(not (available_hdac1))
(not (available_prb-e2f13-dp12p1))
)
)
(:action ASSOCIATE_HDAC1-PRB-E2F13P1-DP12_GE2_HDAC1-PRB-E2F13P1-DP12-GE2
:parameters ()
:precondition
(and
(available_ge2)
(available_hdac1-prb-e2f13p1-dp12)
)
:effect
(and
(available_hdac1-prb-e2f13p1-dp12-ge2)
(not (available_hdac1-prb-e2f13p1-dp12))
(not (available_ge2))
)
)
(:action ASSOCIATE_HDAC1_PRB-E2F13P1-DP12_HDAC1-PRB-E2F13P1-DP12
:parameters ()
:precondition
(and
(available_prb-e2f13p1-dp12)
(available_hdac1)
)
:effect
(and
(available_hdac1-prb-e2f13p1-dp12)
(not (available_hdac1))
(not (available_prb-e2f13p1-dp12))
)
)
(:action ASSOCIATE_HDAC1_PRB-E2F13P1-DP12P1_HDAC1-PRB-E2F13P1-DP12P1
:parameters ()
:precondition
(and
(available_prb-e2f13p1-dp12p1)
(available_hdac1)
)
:effect
(and
(available_hdac1-prb-e2f13p1-dp12p1)
(not (available_hdac1))
(not (available_prb-e2f13p1-dp12p1))
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
(:action ASSOCIATE_PRB-AP2_GE-C_PRB-AP2-GE-C
:parameters ()
:precondition
(and
(available_ge-c)
(available_prb-ap2)
)
:effect
(and
(available_prb-ap2-ge-c)
(not (available_prb-ap2))
(not (available_ge-c))
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
(:action ASSOCIATE_PRB-E2F13-DP12_GE2_PRB-E2F13-DP12-GE2
:parameters ()
:precondition
(and
(available_ge2)
(available_prb-e2f13-dp12)
)
:effect
(and
(available_prb-e2f13-dp12-ge2)
(not (available_prb-e2f13-dp12))
(not (available_ge2))
)
)
(:action ASSOCIATE_PRB-E2F13-DP12P1_GE2_PRB-E2F13-DP12P1-GE2
:parameters ()
:precondition
(and
(available_ge2)
(available_prb-e2f13-dp12p1)
)
:effect
(and
(available_prb-e2f13-dp12p1-ge2)
(not (available_prb-e2f13-dp12p1))
(not (available_ge2))
)
)
(:action ASSOCIATE_PRB_E2F13-DP12P1_PRB-E2F13-DP12P1
:parameters ()
:precondition
(and
(available_e2f13-dp12p1)
(available_prb)
)
:effect
(and
(available_prb-e2f13-dp12p1)
(not (available_prb))
(not (available_e2f13-dp12p1))
)
)
(:action ASSOCIATE_PRB_E2F13-DP12_PRB-E2F13-DP12
:parameters ()
:precondition
(and
(available_e2f13-dp12)
(available_prb)
)
:effect
(and
(available_prb-e2f13-dp12)
(not (available_prb))
(not (available_e2f13-dp12))
)
)
(:action ASSOCIATE_PRB-E2F13P1-DP12_GE2_PRB-E2F13P1-DP12-GE2
:parameters ()
:precondition
(and
(available_ge2)
(available_prb-e2f13p1-dp12)
)
:effect
(and
(available_prb-e2f13p1-dp12-ge2)
(not (available_prb-e2f13p1-dp12))
(not (available_ge2))
)
)
(:action ASSOCIATE_PRB-E2F13P1-DP12P1_GE2_PRB-E2F13P1-DP12P1-GE2
:parameters ()
:precondition
(and
(available_ge2)
(available_prb-e2f13p1-dp12p1)
)
:effect
(and
(available_prb-e2f13p1-dp12p1-ge2)
(not (available_prb-e2f13p1-dp12p1))
(not (available_ge2))
)
)
(:action ASSOCIATE_PRB_E2F13P1-DP12P1_PRB-E2F13P1-DP12P1
:parameters ()
:precondition
(and
(available_e2f13p1-dp12p1)
(available_prb)
)
:effect
(and
(available_prb-e2f13p1-dp12p1)
(not (available_prb))
(not (available_e2f13p1-dp12p1))
)
)
(:action ASSOCIATE_PRB_E2F13P1-DP12_PRB-E2F13P1-DP12
:parameters ()
:precondition
(and
(available_e2f13p1-dp12)
(available_prb)
)
:effect
(and
(available_prb-e2f13p1-dp12)
(not (available_prb))
(not (available_e2f13p1-dp12))
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
(:action ASSOCIATE_PRB_JUN_PRB-JUN
:parameters ()
:precondition
(and
(available_jun)
(available_prb)
)
:effect
(and
(available_prb-jun)
(not (available_prb))
(not (available_jun))
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
(:action INITIALIZE_CDK46P3-CYCDP1
:parameters ()
:precondition
(and
(chosen_cdk46p3-cycdp1)
)
:effect
(and
(available_cdk46p3-cycdp1)
)
)
(:action INITIALIZE_CDK7
:parameters ()
:precondition
(and
(chosen_cdk7)
)
:effect
(and
(available_cdk7)
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
(:action INITIALIZE_CYCB
:parameters ()
:precondition
(and
(chosen_cycb)
)
:effect
(and
(available_cycb)
)
)
(:action INITIALIZE_CYCH
:parameters ()
:precondition
(and
(chosen_cych)
)
:effect
(and
(available_cych)
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
(:action INITIALIZE_E2F13-DP12P1
:parameters ()
:precondition
(and
(chosen_e2f13-dp12p1)
)
:effect
(and
(available_e2f13-dp12p1)
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
(:action INITIALIZE_E2F13P1-DP12P1
:parameters ()
:precondition
(and
(chosen_e2f13p1-dp12p1)
)
:effect
(and
(available_e2f13p1-dp12p1)
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
(:action INITIALIZE_GE-C
:parameters ()
:precondition
(and
(chosen_ge-c)
)
:effect
(and
(available_ge-c)
)
)
(:action INITIALIZE_GERCC1
:parameters ()
:precondition
(and
(chosen_gercc1)
)
:effect
(and
(available_gercc1)
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
(:action INITIALIZE_HDAC1-P107-E2F4P1-DP12
:parameters ()
:precondition
(and
(chosen_hdac1-p107-e2f4p1-dp12)
)
:effect
(and
(available_hdac1-p107-e2f4p1-dp12)
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
(:action INITIALIZE_P53
:parameters ()
:precondition
(and
(chosen_p53)
)
:effect
(and
(available_p53)
)
)
(:action INITIALIZE_P53P1
:parameters ()
:precondition
(and
(chosen_p53p1)
)
:effect
(and
(available_p53p1)
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
(:action CHOOSE_CDK46P3-CYCDP1_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_cdk46p3-cycdp1)
)
:effect
(and
(chosen_cdk46p3-cycdp1)
(num-subs_l1)
(not (not-chosen_cdk46p3-cycdp1))
(not (num-subs_l0))
)
)
(:action CHOOSE_CDK7_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_cdk7)
)
:effect
(and
(chosen_cdk7)
(num-subs_l1)
(not (not-chosen_cdk7))
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
(:action CHOOSE_CYCB_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_cycb)
)
:effect
(and
(chosen_cycb)
(num-subs_l1)
(not (not-chosen_cycb))
(not (num-subs_l0))
)
)
(:action CHOOSE_CYCH_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_cych)
)
:effect
(and
(chosen_cych)
(num-subs_l1)
(not (not-chosen_cych))
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
(:action CHOOSE_E2F13-DP12P1_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_e2f13-dp12p1)
)
:effect
(and
(chosen_e2f13-dp12p1)
(num-subs_l1)
(not (not-chosen_e2f13-dp12p1))
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
(:action CHOOSE_E2F13P1-DP12P1_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_e2f13p1-dp12p1)
)
:effect
(and
(chosen_e2f13p1-dp12p1)
(num-subs_l1)
(not (not-chosen_e2f13p1-dp12p1))
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
(:action CHOOSE_GE-C_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_ge-c)
)
:effect
(and
(chosen_ge-c)
(num-subs_l1)
(not (not-chosen_ge-c))
(not (num-subs_l0))
)
)
(:action CHOOSE_GERCC1_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_gercc1)
)
:effect
(and
(chosen_gercc1)
(num-subs_l1)
(not (not-chosen_gercc1))
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
(:action CHOOSE_HDAC1-P107-E2F4P1-DP12_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_hdac1-p107-e2f4p1-dp12)
)
:effect
(and
(chosen_hdac1-p107-e2f4p1-dp12)
(num-subs_l1)
(not (not-chosen_hdac1-p107-e2f4p1-dp12))
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
(:action CHOOSE_P53_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_p53)
)
:effect
(and
(chosen_p53)
(num-subs_l1)
(not (not-chosen_p53))
(not (num-subs_l0))
)
)
(:action CHOOSE_P53P1_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_p53p1)
)
:effect
(and
(chosen_p53p1)
(num-subs_l1)
(not (not-chosen_p53p1))
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
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
(chosen_raf1)
(chosen_prbp2)
(chosen_prbp1-e2f4p1-dp12)
(chosen_prb-e2f4p1-dp12)
(chosen_prb)
(chosen_pcaf)
(chosen_p57p1)
(chosen_p57)
(chosen_p300)
(chosen_p16)
(chosen_p130-e2f5p1-dp12)
(chosen_p130)
(chosen_jun)
(chosen_hdac1)
(chosen_gp)
(chosen_ge-c)
(chosen_e2f6)
(chosen_e2f5)
(chosen_e2f4)
(chosen_e2f13p1-dp12p1)
(chosen_e2f13p1-dp12)
(chosen_e2f13-dp12p1)
(chosen_e2f13-dp12)
(chosen_dp12)
(chosen_cks1)
(chosen_cdk46p3-cycdp1)
(chosen_cdk46p3-cycd)
(chosen_cdk46p1)
(chosen_cdk2p2-cycb)
(chosen_cdk2p1)
(chosen_ap2)
(available_wee1)
(available_sp1)
(available_skp2)
(available_rpa)
(available_raf1)
(available_prbp2)
(available_prbp1-e2f4p1-dp12)
(available_prb-e2f4p1-dp12)
(available_prb)
(available_pcaf)
(available_p57p1)
(available_p57)
(available_p300)
(available_p16)
(available_p130-e2f5p1-dp12)
(available_p130)
(available_jun)
(available_hdac1)
(available_gp)
(available_ge-c)
(available_e2f6)
(available_e2f5)
(available_e2f4)
(available_e2f13p1-dp12p1)
(available_e2f13p1-dp12)
(available_e2f13-dp12p1)
(available_e2f13-dp12)
(available_dp12)
(available_cks1)
(available_cdk46p3-cycdp1)
(available_cdk46p3-cycd)
(available_cdk46p1)
(available_cdk2p2-cycb)
(available_cdk2p1)
(available_ap2)
(available_sp1-gp)
(available_raf1-prbp1-e2f4p1-dp12)
(available_raf1-prb-e2f4p1-dp12)
(available_raf1-p130-e2f5p1-dp12)
(available_prbp2-jun)
(available_prbp2-ap2)
(available_prbp2-ap2-ge-c)
(available_prb-jun)
(available_prb-e2f13p1-dp12)
(available_prb-e2f13p1-dp12p1)
(available_prb-e2f13-dp12)
(available_prb-e2f13-dp12p1)
(available_prb-ap2)
(available_prb-ap2-ge-c)
(available_pcaf-p300)
(available_p16-cdk46p1)
(available_hdac1-prb-e2f4p1-dp12)
(available_hdac1-prb-e2f13p1-dp12p1)
(available_hdac1-prb-e2f13p1-dp12)
(available_hdac1-prb-e2f13-dp12p1)
(available_hdac1-prb-e2f13-dp12)
(available_e2f6-dp12)
(available_e2f5-dp12)
(available_e2f4-dp12)
(available_cdk2p1-cks1)
(available_ap2-ge-c)
(available_prbp1p2)
(available_prbp1)
(available_cdk2p1p2-cycb)
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
(available_ecadherin)
(num-subs_l2)
(available_sp1-p107)
(available_sp1-p107p1)
(available_sp1-p107p1-gp)
(available_sp1-p107-gp)
(available_rpa-cyca)
(available_raf1-prb-e2f13p1-dp12)
(available_raf1-prb-e2f13p1-dp12p1)
(available_raf1-prb-e2f13-dp12)
(available_raf1-prb-e2f13-dp12p1)
(available_prbp1p2-jun)
(available_prbp1p2-ap2)
(available_prbp1p2-ap2-ge-c)
(available_prbp1-jun)
(available_prbp1-e2f4-dp12)
(available_prbp1-e2f13p1-dp12)
(available_prbp1-e2f13p1-dp12p1)
(available_prbp1-e2f13-dp12)
(available_prbp1-e2f13-dp12p1)
(available_prbp1-ap2)
(available_prbp1-ap2-ge-c)
(available_prb-e2f4-dp12)
(available_p130-e2f5-dp12)
(available_p130-e2f4-dp12)
(available_p107-e2f4-dp12)
(available_hdac1-prb-e2f4-dp12)
(available_hdac1-p130-e2f5-dp12)
(available_hdac1-p130-e2f4-dp12)
(available_hdac1-p107-e2f4-dp12)
(available_c-myc-ap2)
(available_cdk46p1-cycdp1)
(available_cdk46p1-cycd)
(available_cdk2p1-cycep1)
(available_cdk2p1-cyce)
(available_cdk2p1-cyca)
(goal2_)
(goal4_)
(goal6_)
(goal7_)
(goal8_)
(num-subs_l3)
(available_skp2-cdk2p1-cyca)
(available_raf1-prbp1-e2f4-dp12)
(available_raf1-prbp1-e2f13p1-dp12)
(available_raf1-prbp1-e2f13p1-dp12p1)
(available_raf1-prbp1-e2f13-dp12)
(available_raf1-prbp1-e2f13-dp12p1)
(available_raf1-prb-e2f4-dp12)
(available_raf1-p130-e2f5-dp12)
(available_raf1-p130-e2f4-dp12)
(available_p57p1-cdk46p1-cycd)
(available_p57p1-cdk46p1-cycdp1)
(available_p57-cdk46p1-cycd)
(available_p57-cdk46p1-cycdp1)
(available_p57-cdk2p1-cyce)
(available_p57-cdk2p1-cycep1)
(available_p57-cdk2p1-cyca)
(goal1_)
(goal3_)
(goal5_)
(num-subs_l4)
(num-subs_l5)
(num-subs_l6)
(num-subs_l7)
(num-subs_l8)
(num-subs_l9)
(num-subs_l10)
(not-chosen_ap2)
(not-chosen_cdk2p1)
(not-chosen_cdk2p2-cycb)
(not-chosen_cdk46p1)
(not-chosen_cdk46p3-cycd)
(not-chosen_cdk46p3-cycdp1)
(not-chosen_cks1)
(not-chosen_dp12)
(not-chosen_e2f13-dp12)
(not-chosen_e2f13-dp12p1)
(not-chosen_e2f13p1-dp12)
(not-chosen_e2f13p1-dp12p1)
(not-chosen_e2f4)
(not-chosen_e2f5)
(not-chosen_e2f6)
(not-chosen_ge-c)
(not-chosen_gp)
(not-chosen_hdac1)
(not-chosen_jun)
(not-chosen_p130)
(not-chosen_p130-e2f5p1-dp12)
(not-chosen_p16)
(not-chosen_p300)
(not-chosen_p57)
(not-chosen_p57p1)
(not-chosen_pcaf)
(not-chosen_prb)
(not-chosen_prb-e2f4p1-dp12)
(not-chosen_prbp1-e2f4p1-dp12)
(not-chosen_prbp2)
(not-chosen_raf1)
(not-chosen_rpa)
(not-chosen_skp2)
(not-chosen_sp1)
(not-chosen_wee1)
(num-subs_l0)
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
(:action CHOOSE_E2F6_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_e2f6)
)
:effect
(and
(chosen_e2f6)
(num-subs_l10)
(not (not-chosen_e2f6))
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
(:action CHOOSE_GP_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_gp)
)
:effect
(and
(chosen_gp)
(num-subs_l10)
(not (not-chosen_gp))
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
(:action CHOOSE_P16_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_p16)
)
:effect
(and
(chosen_p16)
(num-subs_l10)
(not (not-chosen_p16))
(not (num-subs_l9))
)
)
(:action CHOOSE_P300_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_p300)
)
:effect
(and
(chosen_p300)
(num-subs_l10)
(not (not-chosen_p300))
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
(:action CHOOSE_PCAF_L10_L9
:parameters ()
:precondition
(and
(num-subs_l9)
(not-chosen_pcaf)
)
:effect
(and
(chosen_pcaf)
(num-subs_l10)
(not (not-chosen_pcaf))
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
(:action CHOOSE_E2F6_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_e2f6)
)
:effect
(and
(chosen_e2f6)
(num-subs_l9)
(not (not-chosen_e2f6))
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
(:action CHOOSE_GP_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_gp)
)
:effect
(and
(chosen_gp)
(num-subs_l9)
(not (not-chosen_gp))
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
(:action CHOOSE_P16_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_p16)
)
:effect
(and
(chosen_p16)
(num-subs_l9)
(not (not-chosen_p16))
(not (num-subs_l8))
)
)
(:action CHOOSE_P300_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_p300)
)
:effect
(and
(chosen_p300)
(num-subs_l9)
(not (not-chosen_p300))
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
(:action CHOOSE_PCAF_L9_L8
:parameters ()
:precondition
(and
(num-subs_l8)
(not-chosen_pcaf)
)
:effect
(and
(chosen_pcaf)
(num-subs_l9)
(not (not-chosen_pcaf))
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
(:action CHOOSE_E2F6_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_e2f6)
)
:effect
(and
(chosen_e2f6)
(num-subs_l8)
(not (not-chosen_e2f6))
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
(:action CHOOSE_GP_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_gp)
)
:effect
(and
(chosen_gp)
(num-subs_l8)
(not (not-chosen_gp))
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
(:action CHOOSE_P16_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_p16)
)
:effect
(and
(chosen_p16)
(num-subs_l8)
(not (not-chosen_p16))
(not (num-subs_l7))
)
)
(:action CHOOSE_P300_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_p300)
)
:effect
(and
(chosen_p300)
(num-subs_l8)
(not (not-chosen_p300))
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
(:action CHOOSE_PCAF_L8_L7
:parameters ()
:precondition
(and
(num-subs_l7)
(not-chosen_pcaf)
)
:effect
(and
(chosen_pcaf)
(num-subs_l8)
(not (not-chosen_pcaf))
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
(:action CHOOSE_E2F6_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_e2f6)
)
:effect
(and
(chosen_e2f6)
(num-subs_l7)
(not (not-chosen_e2f6))
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
(:action CHOOSE_GP_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_gp)
)
:effect
(and
(chosen_gp)
(num-subs_l7)
(not (not-chosen_gp))
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
(:action CHOOSE_P16_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_p16)
)
:effect
(and
(chosen_p16)
(num-subs_l7)
(not (not-chosen_p16))
(not (num-subs_l6))
)
)
(:action CHOOSE_P300_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_p300)
)
:effect
(and
(chosen_p300)
(num-subs_l7)
(not (not-chosen_p300))
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
(:action CHOOSE_PCAF_L7_L6
:parameters ()
:precondition
(and
(num-subs_l6)
(not-chosen_pcaf)
)
:effect
(and
(chosen_pcaf)
(num-subs_l7)
(not (not-chosen_pcaf))
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
(:action CHOOSE_E2F6_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_e2f6)
)
:effect
(and
(chosen_e2f6)
(num-subs_l6)
(not (not-chosen_e2f6))
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
(:action CHOOSE_GP_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_gp)
)
:effect
(and
(chosen_gp)
(num-subs_l6)
(not (not-chosen_gp))
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
(:action CHOOSE_P16_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_p16)
)
:effect
(and
(chosen_p16)
(num-subs_l6)
(not (not-chosen_p16))
(not (num-subs_l5))
)
)
(:action CHOOSE_P300_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_p300)
)
:effect
(and
(chosen_p300)
(num-subs_l6)
(not (not-chosen_p300))
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
(:action CHOOSE_PCAF_L6_L5
:parameters ()
:precondition
(and
(num-subs_l5)
(not-chosen_pcaf)
)
:effect
(and
(chosen_pcaf)
(num-subs_l6)
(not (not-chosen_pcaf))
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
(:action CHOOSE_E2F6_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_e2f6)
)
:effect
(and
(chosen_e2f6)
(num-subs_l5)
(not (not-chosen_e2f6))
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
(:action CHOOSE_GP_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_gp)
)
:effect
(and
(chosen_gp)
(num-subs_l5)
(not (not-chosen_gp))
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
(:action CHOOSE_P16_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_p16)
)
:effect
(and
(chosen_p16)
(num-subs_l5)
(not (not-chosen_p16))
(not (num-subs_l4))
)
)
(:action CHOOSE_P300_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_p300)
)
:effect
(and
(chosen_p300)
(num-subs_l5)
(not (not-chosen_p300))
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
(:action CHOOSE_PCAF_L5_L4
:parameters ()
:precondition
(and
(num-subs_l4)
(not-chosen_pcaf)
)
:effect
(and
(chosen_pcaf)
(num-subs_l5)
(not (not-chosen_pcaf))
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
(:action CHOOSE_E2F6_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_e2f6)
)
:effect
(and
(chosen_e2f6)
(num-subs_l4)
(not (not-chosen_e2f6))
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
(:action CHOOSE_GP_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_gp)
)
:effect
(and
(chosen_gp)
(num-subs_l4)
(not (not-chosen_gp))
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
(:action CHOOSE_P16_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_p16)
)
:effect
(and
(chosen_p16)
(num-subs_l4)
(not (not-chosen_p16))
(not (num-subs_l3))
)
)
(:action CHOOSE_P300_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_p300)
)
:effect
(and
(chosen_p300)
(num-subs_l4)
(not (not-chosen_p300))
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
(:action CHOOSE_PCAF_L4_L3
:parameters ()
:precondition
(and
(num-subs_l3)
(not-chosen_pcaf)
)
:effect
(and
(chosen_pcaf)
(num-subs_l4)
(not (not-chosen_pcaf))
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
(:action dummy-action-8-1
:parameters ()
:precondition
(and
(available_p57-cdk2p1-cycep1)
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
(available_p57-cdk46p1-cycdp1)
)
:effect
(and
(goal7_)
)
)
(:action dummy-action-5-1
:parameters ()
:precondition
(and
(available_p57p1-cdk46p1-cycd)
)
:effect
(and
(goal5_)
)
)
(:action dummy-action-5-2
:parameters ()
:precondition
(and
(available_p57-cdk46p1-cycd)
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
(available_raf1-prbp1-e2f4-dp12)
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
(available_raf1-prbp1-e2f13-dp12p1)
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
(available_p57-cdk2p1-cyca)
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
(available_p57p1-cdk46p1-cycdp1)
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
(available_p57-cdk2p1-cyce)
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
(available_skp2-cdk2p1-cyca)
)
:effect
(and
(goal1_)
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
(:action ASSOCIATE_RAF1_PRB-E2F4-DP12_RAF1-PRB-E2F4-DP12
:parameters ()
:precondition
(and
(available_prb-e2f4-dp12)
(available_raf1)
)
:effect
(and
(available_raf1-prb-e2f4-dp12)
(not (available_raf1))
(not (available_prb-e2f4-dp12))
)
)
(:action ASSOCIATE_RAF1_PRBP1-E2F13-DP12P1_RAF1-PRBP1-E2F13-DP12P1
:parameters ()
:precondition
(and
(available_prbp1-e2f13-dp12p1)
(available_raf1)
)
:effect
(and
(available_raf1-prbp1-e2f13-dp12p1)
(not (available_raf1))
(not (available_prbp1-e2f13-dp12p1))
)
)
(:action ASSOCIATE_RAF1_PRBP1-E2F13-DP12_RAF1-PRBP1-E2F13-DP12
:parameters ()
:precondition
(and
(available_prbp1-e2f13-dp12)
(available_raf1)
)
:effect
(and
(available_raf1-prbp1-e2f13-dp12)
(not (available_raf1))
(not (available_prbp1-e2f13-dp12))
)
)
(:action ASSOCIATE_RAF1_PRBP1-E2F13P1-DP12P1_RAF1-PRBP1-E2F13P1-DP12P1
:parameters ()
:precondition
(and
(available_prbp1-e2f13p1-dp12p1)
(available_raf1)
)
:effect
(and
(available_raf1-prbp1-e2f13p1-dp12p1)
(not (available_raf1))
(not (available_prbp1-e2f13p1-dp12p1))
)
)
(:action ASSOCIATE_RAF1_PRBP1-E2F13P1-DP12_RAF1-PRBP1-E2F13P1-DP12
:parameters ()
:precondition
(and
(available_prbp1-e2f13p1-dp12)
(available_raf1)
)
:effect
(and
(available_raf1-prbp1-e2f13p1-dp12)
(not (available_raf1))
(not (available_prbp1-e2f13p1-dp12))
)
)
(:action ASSOCIATE_RAF1_PRBP1-E2F4-DP12_RAF1-PRBP1-E2F4-DP12
:parameters ()
:precondition
(and
(available_prbp1-e2f4-dp12)
(available_raf1)
)
:effect
(and
(available_raf1-prbp1-e2f4-dp12)
(not (available_raf1))
(not (available_prbp1-e2f4-dp12))
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
(:action CHOOSE_E2F6_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_e2f6)
)
:effect
(and
(chosen_e2f6)
(num-subs_l3)
(not (not-chosen_e2f6))
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
(:action CHOOSE_P300_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_p300)
)
:effect
(and
(chosen_p300)
(num-subs_l3)
(not (not-chosen_p300))
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
(:action CHOOSE_PCAF_L3_L2
:parameters ()
:precondition
(and
(num-subs_l2)
(not-chosen_pcaf)
)
:effect
(and
(chosen_pcaf)
(num-subs_l3)
(not (not-chosen_pcaf))
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
(:action dummy-action-8-2
:parameters ()
:precondition
(and
(available_rpa-cyca)
)
:effect
(and
(goal8_)
)
)
(:action dummy-action-7-2
:parameters ()
:precondition
(and
(available_sp1-p107p1-gp)
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
(available_cdk2p1-cyca)
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
(available_cdk2p1-cyce)
)
:effect
(and
(goal6_)
)
)
(:action dummy-action-4-2
:parameters ()
:precondition
(and
(available_hdac1-p107-e2f4-dp12)
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
(available_sp1-p107-gp)
)
:effect
(and
(goal2_)
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
(:action SYNTHESIZE_PRBP1P2-AP2-GE-C_ECADHERIN
:parameters ()
:precondition
(and
(available_prbp1p2-ap2-ge-c)
)
:effect
(and
(available_ecadherin)
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
(:action ASSOCIATE_HDAC1_PRB-E2F4-DP12_HDAC1-PRB-E2F4-DP12
:parameters ()
:precondition
(and
(available_prb-e2f4-dp12)
(available_hdac1)
)
:effect
(and
(available_hdac1-prb-e2f4-dp12)
(not (available_hdac1))
(not (available_prb-e2f4-dp12))
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
(:action ASSOCIATE_PRB_E2F4-DP12_PRB-E2F4-DP12
:parameters ()
:precondition
(and
(available_e2f4-dp12)
(available_prb)
)
:effect
(and
(available_prb-e2f4-dp12)
(not (available_prb))
(not (available_e2f4-dp12))
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
(:action ASSOCIATE_PRBP1_E2F4-DP12_PRBP1-E2F4-DP12
:parameters ()
:precondition
(and
(available_e2f4-dp12)
(available_prbp1)
)
:effect
(and
(available_prbp1-e2f4-dp12)
(not (available_prbp1))
(not (available_e2f4-dp12))
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
(:action ASSOCIATE_PRBP1P2-AP2_GE-C_PRBP1P2-AP2-GE-C
:parameters ()
:precondition
(and
(available_ge-c)
(available_prbp1p2-ap2)
)
:effect
(and
(available_prbp1p2-ap2-ge-c)
(not (available_prbp1p2-ap2))
(not (available_ge-c))
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
(:action ASSOCIATE_RAF1_PRB-E2F13-DP12P1_RAF1-PRB-E2F13-DP12P1
:parameters ()
:precondition
(and
(available_prb-e2f13-dp12p1)
(available_raf1)
)
:effect
(and
(available_raf1-prb-e2f13-dp12p1)
(not (available_raf1))
(not (available_prb-e2f13-dp12p1))
)
)
(:action ASSOCIATE_RAF1_PRB-E2F13-DP12_RAF1-PRB-E2F13-DP12
:parameters ()
:precondition
(and
(available_prb-e2f13-dp12)
(available_raf1)
)
:effect
(and
(available_raf1-prb-e2f13-dp12)
(not (available_raf1))
(not (available_prb-e2f13-dp12))
)
)
(:action ASSOCIATE_RAF1_PRB-E2F13P1-DP12P1_RAF1-PRB-E2F13P1-DP12P1
:parameters ()
:precondition
(and
(available_prb-e2f13p1-dp12p1)
(available_raf1)
)
:effect
(and
(available_raf1-prb-e2f13p1-dp12p1)
(not (available_raf1))
(not (available_prb-e2f13p1-dp12p1))
)
)
(:action ASSOCIATE_RAF1_PRB-E2F13P1-DP12_RAF1-PRB-E2F13P1-DP12
:parameters ()
:precondition
(and
(available_prb-e2f13p1-dp12)
(available_raf1)
)
:effect
(and
(available_raf1-prb-e2f13p1-dp12)
(not (available_raf1))
(not (available_prb-e2f13p1-dp12))
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
(:action CHOOSE_E2F6_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_e2f6)
)
:effect
(and
(chosen_e2f6)
(num-subs_l2)
(not (not-chosen_e2f6))
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
(:action CHOOSE_P300_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_p300)
)
:effect
(and
(chosen_p300)
(num-subs_l2)
(not (not-chosen_p300))
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
(:action CHOOSE_PCAF_L2_L1
:parameters ()
:precondition
(and
(num-subs_l1)
(not-chosen_pcaf)
)
:effect
(and
(chosen_pcaf)
(num-subs_l2)
(not (not-chosen_pcaf))
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
(:action SYNTHESIZE_PRBP2-AP2-GE-C_ECADHERIN
:parameters ()
:precondition
(and
(available_prbp2-ap2-ge-c)
)
:effect
(and
(available_ecadherin)
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
(:action ASSOCIATE-WITH-CATALYZE_PRBP2_CDK46P3-CYCDP1_PRBP1P2
:parameters ()
:precondition
(and
(available_cdk46p3-cycdp1)
(available_prbp2)
)
:effect
(and
(available_prbp1p2)
(not (available_prbp2))
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
(:action ASSOCIATE_E2F6_DP12_E2F6-DP12
:parameters ()
:precondition
(and
(available_dp12)
(available_e2f6)
)
:effect
(and
(available_e2f6-dp12)
(not (available_e2f6))
(not (available_dp12))
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
(:action ASSOCIATE_PCAF_P300_PCAF-P300
:parameters ()
:precondition
(and
(available_p300)
(available_pcaf)
)
:effect
(and
(available_pcaf-p300)
(not (available_pcaf))
(not (available_p300))
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
(:action ASSOCIATE_PRBP2-AP2_GE-C_PRBP2-AP2-GE-C
:parameters ()
:precondition
(and
(available_ge-c)
(available_prbp2-ap2)
)
:effect
(and
(available_prbp2-ap2-ge-c)
(not (available_prbp2-ap2))
(not (available_ge-c))
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
(:action INITIALIZE_E2F6
:parameters ()
:precondition
(and
(chosen_e2f6)
)
:effect
(and
(available_e2f6)
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
(:action INITIALIZE_P300
:parameters ()
:precondition
(and
(chosen_p300)
)
:effect
(and
(available_p300)
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
(:action INITIALIZE_PCAF
:parameters ()
:precondition
(and
(chosen_pcaf)
)
:effect
(and
(available_pcaf)
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
(:action CHOOSE_E2F6_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_e2f6)
)
:effect
(and
(chosen_e2f6)
(num-subs_l1)
(not (not-chosen_e2f6))
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
(:action CHOOSE_P300_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_p300)
)
:effect
(and
(chosen_p300)
(num-subs_l1)
(not (not-chosen_p300))
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
(:action CHOOSE_PCAF_L1_L0
:parameters ()
:precondition
(and
(num-subs_l0)
(not-chosen_pcaf)
)
:effect
(and
(chosen_pcaf)
(num-subs_l1)
(not (not-chosen_pcaf))
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
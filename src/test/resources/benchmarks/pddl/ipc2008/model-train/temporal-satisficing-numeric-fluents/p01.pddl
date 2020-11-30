;; [VIZ] segment_cells['seg-goal'] = [(20,0), (19,0), (18,0), (17,0), (16,0), (15,0), (14,0), (13,0), (12,0), (11,0), (10,0), (9,0), (8,0), (7,0), (6,0), (5,0), (4,0), (3,0), (2,0), (1,0), (0,0), (0,1), (0,2), (0,3), (0,4), (0,5), (0,6), (0,7), (0,8), (0,9), (0,10), (0,11), (0,12), (0,13), (0,14), (0,15), (0,16), (0,17), (0,18), (0,19), (0,20), (0,21), (1,21), (2,21), (3,21), (4,21), (5,21), (6,21), (7,21), (8,21), (9,21), (10,21), (11,21), (12,21), (13,21), (14,21), (15,21), (16,21), (17,21), (18,21), (19,21), (20,21)]
;; [VIZ] segment_cells['seg-hor1'] = [(121,0), (120,0), (119,0), (118,0), (117,0), (116,0), (115,0), (114,0), (113,0), (112,0), (111,0), (110,0), (109,0), (108,0), (107,0), (106,0), (105,0), (104,0), (103,0), (102,0), (101,0), (100,0), (99,0), (98,0), (97,0), (96,0), (95,0), (94,0), (93,0), (92,0), (91,0), (90,0), (89,0), (88,0), (87,0), (86,0), (85,0), (84,0), (83,0), (82,0), (81,0), (80,0), (79,0), (78,0), (77,0), (76,0), (75,0), (74,0), (73,0), (72,0), (71,0), (70,0), (69,0), (68,0), (67,0), (66,0), (65,0), (64,0), (63,0), (62,0), (61,0), (60,0), (59,0), (58,0), (57,0), (56,0), (55,0), (54,0), (53,0), (52,0), (51,0), (50,0), (49,0), (48,0), (47,0), (46,0), (45,0), (44,0), (43,0), (42,0), (41,0), (40,0), (39,0), (38,0), (37,0), (36,0), (35,0), (34,0), (33,0), (32,0), (31,0), (30,0), (29,0), (28,0), (27,0), (26,0), (25,0), (24,0), (23,0), (22,0)]
;; [VIZ] segment_cells['seg-hor2'] = [(22,21), (23,21), (24,21), (25,21), (26,21), (27,21), (28,21), (29,21), (30,21), (31,21), (32,21), (33,21), (34,21), (35,21), (36,21), (37,21), (38,21), (39,21), (40,21), (41,21), (42,21), (43,21), (44,21), (45,21), (46,21), (47,21), (48,21), (49,21), (50,21), (51,21), (52,21), (53,21), (54,21), (55,21), (56,21), (57,21), (58,21), (59,21), (60,21), (61,21), (62,21), (63,21), (64,21), (65,21), (66,21), (67,21), (68,21), (69,21), (70,21), (71,21), (72,21), (73,21), (74,21), (75,21), (76,21), (77,21), (78,21), (79,21), (80,21), (81,21), (82,21), (83,21), (84,21), (85,21), (86,21), (87,21), (88,21), (89,21), (90,21), (91,21), (92,21), (93,21), (94,21), (95,21), (96,21), (97,21), (98,21), (99,21), (100,21), (101,21), (102,21), (103,21), (104,21), (105,21), (106,21), (107,21), (108,21), (109,21), (110,21), (111,21), (112,21), (113,21), (114,21), (115,21), (116,21), (117,21), (118,21), (119,21), (120,21), (121,21)]
;; [VIZ] segment_cells['seg-left1'] = [(21,1), (21,2), (21,3), (21,4), (21,5), (21,6), (21,7), (21,8), (21,9), (21,10), (21,11), (21,12), (21,13), (21,14), (21,15), (21,16), (21,17), (21,18), (21,19), (21,20)]
;; [VIZ] segment_cells['seg-right1'] = [(122,20), (122,19), (122,18), (122,17), (122,16), (122,15), (122,14), (122,13), (122,12), (122,11), (122,10), (122,9), (122,8), (122,7), (122,6), (122,5), (122,4), (122,3), (122,2), (122,1)]
;; [VIZ] switch['sw-left1'] = (21,0)
;; [VIZ] switch['sw-left2'] = (21,21)
;; [VIZ] switch['sw-right1'] = (122,0)
;; [VIZ] switch['sw-right2'] = (122,21)
;; [VIZ] switch_entrance['sw-left1'] = 'seg-hor1'
;; [VIZ] switch_entrance['sw-left2'] = 'seg-left1'
;; [VIZ] switch_entrance['sw-right1'] = 'seg-right1'
;; [VIZ] switch_entrance['sw-right2'] = 'seg-hor2'
;; [VIZ] switch_exit['sw-left1'] = 'seg-left1'
;; [VIZ] switch_exit['sw-left2'] = 'seg-hor2'
;; [VIZ] switch_exit['sw-right1'] = 'seg-hor1'
;; [VIZ] switch_exit['sw-right2'] = 'seg-right1'
;; [VIZ] train_length['train1'] = 12
;; [VIZ] train_length['train2'] = 68
;; [VIZ] train_position['train1'] = ('seg-hor1', 100)
;; [VIZ] train_position['train2'] = ('seg-hor2', 100)
(define (problem model-train-time-metric-1)
  (:domain model-train-time-metric)
  (:objects
    seg-goal - segment
    seg-hor1 - segment
    seg-hor2 - segment
    seg-left1 - segment
    seg-right1 - segment
    sw-left1 - switch
    sw-left2 - switch
    sw-right1 - switch
    sw-right2 - switch
    train1 - train
    train2 - train
  )
  (:init
    (= (SEGMENT-LENGTH seg-goal) 62)
    (= (SEGMENT-LENGTH seg-hor1) 100)
    (= (SEGMENT-LENGTH seg-hor2) 100)
    (= (SEGMENT-LENGTH seg-left1) 20)
    (= (SEGMENT-LENGTH seg-right1) 20)
    (= (TRAIN-LENGTH train1) 12)
    (= (TRAIN-LENGTH train2) 68)
    (= (head-segment-position train1) 100)
    (= (head-segment-position train2) 100)
    (= (tail-segment-position train1) 88)
    (= (tail-segment-position train2) 32)
    (SWITCH-HAS-ENTRANCE sw-left1 seg-hor1)
    (SWITCH-HAS-ENTRANCE sw-left2 seg-goal)
    (SWITCH-HAS-ENTRANCE sw-left2 seg-left1)
    (SWITCH-HAS-ENTRANCE sw-right1 seg-right1)
    (SWITCH-HAS-ENTRANCE sw-right2 seg-hor2)
    (SWITCH-HAS-EXIT sw-left1 seg-goal)
    (SWITCH-HAS-EXIT sw-left1 seg-left1)
    (SWITCH-HAS-EXIT sw-left2 seg-hor2)
    (SWITCH-HAS-EXIT sw-right1 seg-hor1)
    (SWITCH-HAS-EXIT sw-right2 seg-right1)
    (first-train-in-head-segment train1)
    (first-train-in-head-segment train2)
    (head-segment train1 seg-hor1)
    (head-segment train2 seg-hor2)
    (idle train1)
    (idle train2)
    (last-train-in-tail-segment train1)
    (last-train-in-tail-segment train2)
    (segment-empty seg-goal)
    (segment-empty seg-left1)
    (segment-empty seg-right1)
    (switch-available sw-left1)
    (switch-available sw-left2)
    (switch-available sw-right1)
    (switch-available sw-right2)
    (switch-entrance sw-left1 seg-hor1)
    (switch-entrance sw-left2 seg-left1)
    (switch-entrance sw-right1 seg-right1)
    (switch-entrance sw-right2 seg-hor2)
    (switch-exit sw-left1 seg-left1)
    (switch-exit sw-left2 seg-hor2)
    (switch-exit sw-right1 seg-hor1)
    (switch-exit sw-right2 seg-right1)
    (tail-segment train1 seg-hor1)
    (tail-segment train2 seg-hor2)
  )
  (:goal (and
    (head-segment train1 seg-hor1)
    (head-segment train2 seg-hor2)
    (tail-segment train1 seg-hor1)
    (tail-segment train2 seg-hor2)
    (visited-segment train1 seg-goal)
    (visited-segment train2 seg-goal)
  ))
  (:metric minimize (total-time))
)

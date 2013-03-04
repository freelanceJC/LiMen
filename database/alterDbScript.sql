-- an new view 'user_fan_view'
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `user_fan_view` AS select `uf`.`user_id` AS `user_id`,`ud`.`real_name` AS `user_name`,`uf`.`fan_user_id` AS `fan_user_id`,`udfan`.`real_name` AS `fan_name`,`udfan`.`address` AS `fan_address`,`udfan`.`date_of_birth` AS `fan_date_of_birth`,`udfan`.`photo` AS `fan_photo`,`uf`.`status` AS `status` from ((`user_fan` `uf` join `user_detail` `ud` on((`uf`.`user_id` = `ud`.`id`))) join `user_detail` `udfan` on((`uf`.`fan_user_id` = `udfan`.`id`)))

-- an new table 'user_fan'
CREATE TABLE `user_fan` (
  `id` int(10) unsigned NOT NULL,
  `user_id` int(10) unsigned NOT NULL,
  `fan_user_id` int(10) unsigned NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT 'ignore\n1=ignore\n0=active fan',
  PRIMARY KEY (`id`),
  KEY `fk_user_fan_user_id` (`user_id`),
  KEY `fk_user_fan_fan_user_id` (`fan_user_id`),
  CONSTRAINT `fk_user_fan_user_id` FOREIGN KEY (`user_id`) REFERENCES `user_detail` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_fan_fan_user_id` FOREIGN KEY (`fan_user_id`) REFERENCES `user_detail` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin$$


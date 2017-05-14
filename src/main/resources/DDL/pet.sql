CREATE TABLE `pets` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`name` varchar(255) DEFAULT NULL,
	`animal` varchar(255) DEFAULT NULL,
	`age` int(11) DEFAULT NULL,
	`sex` varchar(255) DEFAULT NULL,
	`description` varchar(255) DEFAULT NULL,
	`status` varchar(255) DEFAULT NULL,
	`organization` varchar(255) DEFAULT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8
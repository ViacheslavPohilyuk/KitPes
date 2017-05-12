CREATE TABLE `pets` (
	`id` IDENTITY AUTO_INCREMENT,
	`name` varchar(255) DEFAULT NULL,
	`animal` varchar(255) DEFAULT NULL,
	`age` int(11) DEFAULT NULL,
	`sex` varchar(255) DEFAULT NULL,
	`description` varchar(255) DEFAULT NULL,
	`status` varchar(255) DEFAULT NULL,
	`organization` varchar(255) DEFAULT NULL
);

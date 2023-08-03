CREATE TABLE `filters` (
  `filter_id` int(11) NOT NULL AUTO_INCREMENT,
  `search_string` varchar(45) NOT NULL,
  `telegram_user_id` int(64) NOT NULL,
  PRIMARY KEY (`filter_id`)
);

CREATE TABLE `results` (
  `result_id` int(11) NOT NULL AUTO_INCREMENT,
  `model` varchar(45) NOT NULL,
  `year` varchar(45) NOT NULL,
  `price` varchar(45) NOT NULL,
  `url` varchar(45) NOT NULL,
  `telegram_user_id` int(64) NOT NULL,
  PRIMARY KEY (`result_id`)
);

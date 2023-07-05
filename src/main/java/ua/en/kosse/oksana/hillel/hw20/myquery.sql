CREATE TABLE IF NOT EXISTS `homework` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(25) NOT NULL,
  `description` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
)

CREATE TABLE IF NOT EXISTS `lesson` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(25) NOT NULL,
  `updatedAt` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `homework_id` INT UNSIGNED,
  `schedule_id` INT UNSIGNED,
 PRIMARY KEY (`id`),
 FOREIGN KEY (`homework_id`) REFERENCES `homework` (`id`),
 FOREIGN KEY (`schedule_id`) REFERENCES `schedule` (`id`)
)

CREATE TABLE IF NOT EXISTS `schedule` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(25) NOT NULL,
  `updatedAt` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
 PRIMARY KEY (`id`)
)


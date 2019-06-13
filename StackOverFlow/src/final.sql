CREATE TABLE `Questions` (
  `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(600) NOT NULL,
  `details` varchar(800) NOT NULL
);


INSERT INTO `Questions` (`name`, `details`)
VALUES ('Which version of Tomcat should I choose?', 'Is  version 6 or 8 compatible ?');


CREATE TABLE `Details` (
  `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(900) NOT NULL,
  `q_id` int NOT NULL
);

ALTER TABLE `Details`
ADD FOREIGN KEY (`q_id`) REFERENCES `Details` (`id`)

INSERT INTO `Details` (`name`, `q_id`)
VALUES ('The first answer is incorrect. It should be $(this).closest(\"tr\")', '2');
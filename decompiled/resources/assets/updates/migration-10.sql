DROP INDEX IF EXISTS `bgf_message`.`_idx`;
DROP TABLE `bgf_message`;
CREATE TABLE `bgf_message` (`message_id` VARCHAR , `conversation` VARCHAR , `dataSent` VARCHAR , `image` VARCHAR , `friend_id` VARCHAR NOT NULL , `id` VARCHAR , `message` VARCHAR , `message_type` INTEGER , `receiver` VARCHAR , `sender` VARCHAR , `serverDate` VARCHAR , `status` INTEGER , PRIMARY KEY (`id`) );
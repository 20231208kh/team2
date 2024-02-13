DROP DATABASE IF EXISTS TEAM_2_BOARD;
CREATE DATABASE IF NOT EXISTS TEAM_2_BOARD;

USE TEAM_2_BOARD;

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
	`mb_id`	varchar(20)	PRIMARY KEY,
	`mb_pw`	varchar(20)	NOT NULL,
	`mb_email`	varchar(30)	NOT NULL,
	`mb_age`	int	NULL,
	`mb_localnum`	varchar(15)	NOT NULL,
	`mb_right`	varchar(10)	DEFAULT "USER"
);

DROP TABLE IF EXISTS `reply`;

CREATE TABLE `reply` (
	`re_num`	int	PRIMARY KEY AUTO_INCREMENT,
	`re_content`	text	NOT NULL,
	`re_date`	date not null,
	`re_mb_id`	varchar(20)	NOT NULL,
	`re_po_num`	int	
);

DROP TABLE IF EXISTS `post`;

CREATE TABLE `post` (
	`po_num`	int	PRIMARY KEY AUTO_INCREMENT,
	`po_viewcount`	int	DEFAULT 0,
	`po_title`	varchar(20)	NOT NULL,
	`po_content`	text	NOT NULL,
	`po_date`	date not null,
	`po_notice`	int	DEFAULT 0,
	`po_mb_id`	varchar(20)	NOT NULL,
	`po_bo_num`	int	not null,
	`po_pc_num`	int	
);

DROP TABLE IF EXISTS `board`;

CREATE TABLE `board` (
	`bo_num`	int	PRIMARY KEY AUTO_INCREMENT,
	`bo_title`	varchar(20)	NOT NULL,
	`bo_detail`	text,
	`bo_bc_num`	int	
);

DROP TABLE IF EXISTS `board_category`;

CREATE TABLE `board_category` (
	`bc_num`	int	PRIMARY KEY AUTO_INCREMENT,
	`bc_title`	varchar(30) NOT NULL
);

DROP TABLE IF EXISTS `post_category`;

CREATE TABLE `post_category` (
	`pc_num`	int	PRIMARY KEY AUTO_INCREMENT,
	`pc_title`	varchar(30)	NOT NULL,
	`pc_bo_num`	int
);

ALTER TABLE `reply` ADD CONSTRAINT `FK_member_TO_reply_1` FOREIGN KEY (
	`re_mb_id`
)
REFERENCES `member` (
	`mb_id`
);

ALTER TABLE `reply` ADD CONSTRAINT `FK_post_TO_reply_1` FOREIGN KEY (
	`re_po_num`
)
REFERENCES `post` (
	`po_num`
);

ALTER TABLE `post` ADD CONSTRAINT `FK_member_TO_post_1` FOREIGN KEY (
	`po_mb_id`
)
REFERENCES `member` (
	`mb_id`
);

ALTER TABLE `post` ADD CONSTRAINT `FK_board_TO_post_1` FOREIGN KEY (
	`po_bo_num`
)
REFERENCES `board` (
	`bo_num`
);

ALTER TABLE `post` ADD CONSTRAINT `FK_post_category_TO_post_1` FOREIGN KEY (
	`po_pc_num`
)
REFERENCES `post_category` (
	`pc_num`
);

ALTER TABLE `board` ADD CONSTRAINT `FK_board_category_TO_board_1` FOREIGN KEY (
	`bo_bc_num`
)
REFERENCES `board_category` (
	`bc_num`
);

ALTER TABLE `post_category` ADD CONSTRAINT `FK_board_TO_post_category_1` FOREIGN KEY (
	`pc_bo_num`
)
REFERENCES `board` (
	`bo_num`
);

DROP DATABASE IF EXISTS `BOOK_SYSTEM`;

-- ����DATABASE
CREATE DATABASE BOOK_SYSTEM;
-- ʹ��BOOK_SYSTEM
USE BOOK_SYSTEM;

-- �û���
CREATE TABLE IF NOT EXISTS `T_USER` (
    `ID` INT AUTO_INCREMENT NOT NULL,
    `USER_NAME` VARCHAR(20),
    `USER_PASSWORD` VARCHAR(20),
    PRIMARY KEY (`ID`)
);

INSERT INTO `T_USER` VALUES ('1', 'hym', '123123');

-- ������
CREATE TABLE IF NOT EXISTS `T_BOOK_TYPE` (
    `ID` INT AUTO_INCREMENT NOT NULL, -- �������ɲ���Ϊ�Զ�����
    `TYPE_NAME` VARCHAR(50), -- ��������
    `TYPE_INTRO` VARCHAR(200), -- ������
    PRIMARY KEY (`ID`)
);

-- ������
CREATE TABLE IF NOT EXISTS `T_PUBLISHER` (
    `ID` INT AUTO_INCREMENT NOT NULL, -- �������ɲ���Ϊ�Զ�����
    `PUB_NAME` VARCHAR(50), -- ����������
    `PUB_TEL` VARCHAR(50), -- ��ϵ�绰
    `PUB_LINK_MAN` VARCHAR(50), -- ��ϵ��
    `PUB_INTRO` VARCHAR(200), -- ���
    PRIMARY KEY (`ID`) -- ��������
);

-- ��
CREATE TABLE IF NOT EXISTS `T_BOOK` (
    `ID` INT AUTO_INCREMENT NOT NULL, -- ID�ֶΣ�����
    `BOOK_NAME` VARCHAR(50), -- ������
    `BOOK_INTRO` VARCHAR(200), -- ����
	`BOOK_PRICE` DOUBLE, -- ��ĵ���
    `TYPE_ID_FK` INT NOT NULL, -- �������
    `PUB_ID_FK` INT NOT NULL, -- ���������
	`IMAGE_URL` VARCHAR(200), -- ����ͼURL
	`AUTHOR` VARCHAR(200), -- ����
    `REPERTORY_SIZE` BIGINT(10), -- �������
    FOREIGN KEY (`TYPE_ID_FK`) REFERENCES `T_BOOK_TYPE` (`ID`), -- ������������
    FOREIGN KEY (`PUB_ID_FK`) REFERENCES `T_PUBLISHER` (`ID`), -- �������������
    PRIMARY KEY (`ID`)
);

-- ���׼�¼��, һ�����׼�¼�������������ۼ�¼, һ�ν��׿����ж౾��
CREATE TABLE IF NOT EXISTS `T_SALE_RECORD` (
    `ID` INT AUTO_INCREMENT NOT NULL,
    `RECORD_DATE` DATETIME,-- ��������
    `BOOK_NAME` VARCHAR(20),
    PRIMARY KEY (`ID`)
);

-- ������ۼ�¼, һ����¼��Ӧһ����
CREATE TABLE IF NOT EXISTS `T_BOOK_SALE_RECORD` (
    `ID` INT AUTO_INCREMENT NOT NULL,
    `BOOK_ID_FK` INT, -- ���۵���
    `T_SALE_RECORD_ID_FK` INT, -- ��������ۼ�¼����Ӧ�Ľ��׼�¼
    `TRADE_SUM` INT(10), -- ��������
    FOREIGN KEY (`BOOK_ID_FK`) REFERENCES `T_BOOK` (`ID`) ON DELETE CASCADE,
    FOREIGN KEY (`T_SALE_RECORD_ID_FK`) REFERENCES `T_SALE_RECORD` (`ID`),
    PRIMARY KEY (`ID`)
);

-- ����¼��, һ��������౾��
CREATE TABLE IF NOT EXISTS `T_IN_RECORD` (
    `ID` INT AUTO_INCREMENT NOT NULL,
    `RECORD_DATE` DATETIME, -- �������
     `BOO_NAME` VARCHAR(20),
    PRIMARY KEY (`ID`)
);

-- �������¼
CREATE TABLE IF NOT EXISTS `T_BOOK_IN_RECORD` (
    `ID` INT AUTO_INCREMENT NOT NULL, -- ID����
    `BOOK_ID_FK` INT, -- ������
    `T_IN_RECORD_ID_FK` INT, -- ��Ӧ������¼
    `IN_SUM` INT(10), -- �������
    FOREIGN KEY (`BOOK_ID_FK`) REFERENCES `T_BOOK` (`ID`) ON DELETE CASCADE, -- ����������
    FOREIGN KEY (`T_IN_RECORD_ID_FK`) REFERENCES `T_IN_RECORD` (`ID`), -- ��������¼���
    PRIMARY KEY (`ID`)
);
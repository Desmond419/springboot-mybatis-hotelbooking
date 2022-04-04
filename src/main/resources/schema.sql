DROP DATABASE IF EXISTS hotel_booking_db;
CREATE DATABASE IF NOT EXISTS hotel_booking_db DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

use hotel_booking_db;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS user;
CREATE TABLE user
(
    id           VARCHAR(255) NOT NULL PRIMARY KEY COMMENT '用户id',
    username     VARCHAR(255) NOT NULL COMMENT '昵称',
    email        VARCHAR(255) NOT NULL COMMENT '邮箱',
    password     VARCHAR(255) NOT NULL COMMENT '密码',
    dob          VARCHAR(255) COMMENT '生日',
    mobile_no    VARCHAR(255) COMMENT '电话',
    gender       VARCHAR(255) COMMENT '性别',
    role         VARCHAR(255) COMMENT '角色/权限',
    image        VARCHAR(255) COMMENT '用户头像',
    created_time TIMESTAMP                             DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time TIMESTAMP ON UPDATE CURRENT_TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间'
);
-- -----------
-- Records of user
-- -----------
INSERT INTO user(id, username, email, password, dob, mobile_no, gender, role)
values ('1', 'admin', 'admin@email.com', "admin", '040400', "0123456789", 'male', 'Admin');

-- ----------------------------
-- Table structure for hotel
-- ----------------------------
DROP TABLE IF EXISTS hotel;
CREATE TABLE hotel
(
    id           VARCHAR(255) PRIMARY KEY NOT NULL COMMENT '酒店id',
    name         VARCHAR(255) NOT NULL COMMENT '酒店名',
    contact_no   VARCHAR(255) NULL COMMENT '联系号码',
    email        VARCHAR(255) COMMENT '电子邮箱',
    address      VARCHAR(255) COMMENT '地址',
    description  VARCHAR(255) COMMENT '酒店信息',
    image        VARCHAR(255) COMMENT '图片文件夹名,图片名字(用于主页展示)',
    created_time TIMESTAMP                             DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time TIMESTAMP ON UPDATE CURRENT_TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间'
);

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS room;
CREATE TABLE room
(
    id           VARCHAR(255) NOT NULL PRIMARY KEY COMMENT '房间id',
    number       VARCHAR(255) NOT NULL COMMENT '房间编号',
    price        VARCHAR(255) COMMENT '房间价格',
    type         VARCHAR(255) COMMENT '房间类型(单双人房等)',
    bed          int COMMENT '床位数',
    wifi         VARCHAR(255) COMMENT 'wifi(有无)',
    air_conditioner  VARCHAR(255) COMMENT '冷气（有无）',
    balcony      VARCHAR(255) COMMENT '阳台（有无）',
    details      VARCHAR(255) COMMENT '房间特别信息',
    image        VARCHAR(255) COMMENT '图片文件夹名,图片名字(用于主页展示)',
    created_time TIMESTAMP                             DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time TIMESTAMP ON UPDATE CURRENT_TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间'
);

-- ----------------------------
-- Table structure for booking_info
-- 预定表
-- ----------------------------
DROP TABLE IF EXISTS booking_info;
CREATE TABLE booking_info
(
    id              VARCHAR(255) NOT NULL PRIMARY KEY COMMENT '预订id',
    user_id         VARCHAR(255) COMMENT '用户id',
    fullname        VARCHAR(255) COMMENT '用户实名',
    room_id         VARCHAR(255) COMMENT '酒店名',
    room_no         VARCHAR(255) COMMENT '房间编号',
    room_type       VARCHAR(255) COMMENT '房型(单双人房等)',
    booking_time    TIMESTAMP COMMENT '预订日期',
    cost            DOUBLE COMMENT '订单费用',
    status          VARCHAR(255) COMMENT '订单状态:0-已下单，1-已付款，2-已消费，-1-已取消，-2-被删除',
    created_time     TIMESTAMP                             DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time     TIMESTAMP ON UPDATE CURRENT_TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',

    FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (room_id) REFERENCES room (id) ON DELETE CASCADE ON UPDATE CASCADE
);

SET FOREIGN_KEY_CHECKS = 1;
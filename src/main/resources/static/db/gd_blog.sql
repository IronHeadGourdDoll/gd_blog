/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50727
Source Host           : localhost:3306
Source Database       : gd_blog

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2020-04-09 21:41:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `blog_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `author` varchar(11) NOT NULL,
  `summary` varchar(45) NOT NULL COMMENT '博客简介',
  `content` text NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `commend` int(2) NOT NULL DEFAULT '0' COMMENT '是否推荐，0不推荐，1推荐',
  `status` int(2) NOT NULL DEFAULT '1' COMMENT '博文状态，1表示已经发表，2表示在草稿箱，3表示在垃圾箱',
  `header_img` varchar(255) NOT NULL DEFAULT '1',
  `category_name` varchar(255) NOT NULL,
  `read_times` int(11) NOT NULL DEFAULT '0',
  `liked_times` int(11) NOT NULL DEFAULT '0',
  `disliked_times` int(11) NOT NULL DEFAULT '0',
  `comment_times` int(11) NOT NULL DEFAULT '0',
  `grade` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`blog_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='博客表';

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES ('1', '深入理解SpringBoot多数据源', 'wuliang', '本文主要说明SpringBoot2配置Druid多数据源。', '本文主要说明SpringBoot2配置Druid多数据源。在Springboot2中引入了AbstractRoutingDataSource这个类，这个类的作用是充当DataSource的路由中介，能够在运行时，根据key来动态切换DataSource。使用多数据源能够对多个数据库实例进行管理，这样可以有效的提升系统的水平伸缩性。而这样的方案就不同于传统的单一数据源，需要在运行时，根据请求上下文来动态的决定使用哪个数据源。在Springboot2中引入了AbstractRoutingDataSource这个类，这个类的作用是充当DataSource的路由中介，能够在运行时，根据key来动态切换DataSource。使用多数据源能够对多个数据库实例进行管理，这样可以有效的提升系统的水平伸缩性。而这样的方案就不同于传统的单一数据源，需要在运行时，根据请求上下文来动态的决定使用哪个数据源。在Springboot2中引入了AbstractRoutingDataSource这个类，这个类的作用是充当DataSource的路由中介，能够在运行时，根据key来动态切换DataSource。使用多数据源能够对多个数据库实例进行管理，这样可以有效的提升系统的水平伸缩性。而这样的方案就不同于传统的单一数据源，需要在运行时，根据请求上下文来动态的决定使用哪个数据源。在Springboot2中引入了AbstractRoutingDataSource这个类，这个类的作用是充当DataSource的路由中介，能够在运行时，根据key来动态切换DataSource。使用多数据源能够对多个数据库实例进行管理，这样可以有效的提升系统的水平伸缩性。而这样的方案就不同于传统的单一数据源，需要在运行时，根据请求上下文来动态的决定使用哪个数据源。该方法的作用的通过determineCurrentLookupKey方法是用于获取当前指定的数据源的key，根据这个key获取到指定的数据源，如果数据源为空那么使用默认的。那么可以想到通过重写此方法就可以改变数据源。该方法的作用的通过determineCurrentLookupKey方法是用于获取当前指定的数据源的key，根据这个key获取到指定的数据源，如果数据源为空那么使用默认的。那么可以想到通过重写此方法就可以改变数据源。该方法的作用的通过determineCurrentLookupKey方法是用于获取当前指定的数据源的key，根据这个key获取到指定的数据源，如果数据源为空那么使用默认的。那么可以想到通过重写此方法就可以改变数据源。', '2020-04-08 16:30:13', '2020-04-09 16:49:59', '1', '1', '1', 'Java', '54', '64', '12', '54', '21');
INSERT INTO `blog` VALUES ('3', '深入理解SpringBoot多数据源', 'wuliang', '本文主要说明SpringBoot2配置Druid多数据源。', '本文主要说明SpringBoot2配置Druid多数据源。在Springboot2中引入了AbstractRoutingDataSource这个类，这个类的作用是充当DataSource的路由中介，能够在运行时，根据key来动态切换DataSource。使用多数据源能够对多个数据库实例进行管理，这样可以有效的提升系统的水平伸缩性。而这样的方案就不同于传统的单一数据源，需要在运行时，根据请求上下文来动态的决定使用哪个数据源。在Springboot2中引入了AbstractRoutingDataSource这个类，这个类的作用是充当DataSource的路由中介，能够在运行时，根据key来动态切换DataSource。使用多数据源能够对多个数据库实例进行管理，这样可以有效的提升系统的水平伸缩性。而这样的方案就不同于传统的单一数据源，需要在运行时，根据请求上下文来动态的决定使用哪个数据源。在Springboot2中引入了AbstractRoutingDataSource这个类，这个类的作用是充当DataSource的路由中介，能够在运行时，根据key来动态切换DataSource。使用多数据源能够对多个数据库实例进行管理，这样可以有效的提升系统的水平伸缩性。而这样的方案就不同于传统的单一数据源，需要在运行时，根据请求上下文来动态的决定使用哪个数据源。在Springboot2中引入了AbstractRoutingDataSource这个类，这个类的作用是充当DataSource的路由中介，能够在运行时，根据key来动态切换DataSource。使用多数据源能够对多个数据库实例进行管理，这样可以有效的提升系统的水平伸缩性。而这样的方案就不同于传统的单一数据源，需要在运行时，根据请求上下文来动态的决定使用哪个数据源。该方法的作用的通过determineCurrentLookupKey方法是用于获取当前指定的数据源的key，根据这个key获取到指定的数据源，如果数据源为空那么使用默认的。那么可以想到通过重写此方法就可以改变数据源。该方法的作用的通过determineCurrentLookupKey方法是用于获取当前指定的数据源的key，根据这个key获取到指定的数据源，如果数据源为空那么使用默认的。那么可以想到通过重写此方法就可以改变数据源。该方法的作用的通过determineCurrentLookupKey方法是用于获取当前指定的数据源的key，根据这个key获取到指定的数据源，如果数据源为空那么使用默认的。那么可以想到通过重写此方法就可以改变数据源。', '2020-04-09 16:30:14', '2020-04-09 16:30:14', '1', '1', '1', 'Java', '54', '64', '12', '54', '21');
INSERT INTO `blog` VALUES ('4', '深入理解SpringBoot多数据源', 'zhangsan', '本文主要说明SpringBoot2配置Druid多数据源。', '本文主要说明SpringBoot2配置Druid多数据源。在Springboot2中引入了AbstractRoutingDataSource这个类，这个类的作用是充当DataSource的路由中介，能够在运行时，根据key来动态切换DataSource。使用多数据源能够对多个数据库实例进行管理，这样可以有效的提升系统的水平伸缩性。而这样的方案就不同于传统的单一数据源，需要在运行时，根据请求上下文来动态的决定使用哪个数据源。在Springboot2中引入了AbstractRoutingDataSource这个类，这个类的作用是充当DataSource的路由中介，能够在运行时，根据key来动态切换DataSource。使用多数据源能够对多个数据库实例进行管理，这样可以有效的提升系统的水平伸缩性。而这样的方案就不同于传统的单一数据源，需要在运行时，根据请求上下文来动态的决定使用哪个数据源。在Springboot2中引入了AbstractRoutingDataSource这个类，这个类的作用是充当DataSource的路由中介，能够在运行时，根据key来动态切换DataSource。使用多数据源能够对多个数据库实例进行管理，这样可以有效的提升系统的水平伸缩性。而这样的方案就不同于传统的单一数据源，需要在运行时，根据请求上下文来动态的决定使用哪个数据源。在Springboot2中引入了AbstractRoutingDataSource这个类，这个类的作用是充当DataSource的路由中介，能够在运行时，根据key来动态切换DataSource。使用多数据源能够对多个数据库实例进行管理，这样可以有效的提升系统的水平伸缩性。而这样的方案就不同于传统的单一数据源，需要在运行时，根据请求上下文来动态的决定使用哪个数据源。该方法的作用的通过determineCurrentLookupKey方法是用于获取当前指定的数据源的key，根据这个key获取到指定的数据源，如果数据源为空那么使用默认的。那么可以想到通过重写此方法就可以改变数据源。该方法的作用的通过determineCurrentLookupKey方法是用于获取当前指定的数据源的key，根据这个key获取到指定的数据源，如果数据源为空那么使用默认的。那么可以想到通过重写此方法就可以改变数据源。该方法的作用的通过determineCurrentLookupKey方法是用于获取当前指定的数据源的key，根据这个key获取到指定的数据源，如果数据源为空那么使用默认的。那么可以想到通过重写此方法就可以改变数据源。', '2020-04-09 21:16:10', '2020-04-09 21:16:10', '1', '1', '1', 'Java', '54', '3', '111', '54', '21');
INSERT INTO `blog` VALUES ('5', '深入理解SpringBoot多数据源', 'wuliang', '本文主要说明SpringBoot2配置Druid多数据源。', '本文主要说明SpringBoot2配置Druid多数据源。在Springboot2中引入了AbstractRoutingDataSource这个类，这个类的作用是充当DataSource的路由中介，能够在运行时，根据key来动态切换DataSource。使用多数据源能够对多个数据库实例进行管理，这样可以有效的提升系统的水平伸缩性。而这样的方案就不同于传统的单一数据源，需要在运行时，根据请求上下文来动态的决定使用哪个数据源。在Springboot2中引入了AbstractRoutingDataSource这个类，这个类的作用是充当DataSource的路由中介，能够在运行时，根据key来动态切换DataSource。使用多数据源能够对多个数据库实例进行管理，这样可以有效的提升系统的水平伸缩性。而这样的方案就不同于传统的单一数据源，需要在运行时，根据请求上下文来动态的决定使用哪个数据源。在Springboot2中引入了AbstractRoutingDataSource这个类，这个类的作用是充当DataSource的路由中介，能够在运行时，根据key来动态切换DataSource。使用多数据源能够对多个数据库实例进行管理，这样可以有效的提升系统的水平伸缩性。而这样的方案就不同于传统的单一数据源，需要在运行时，根据请求上下文来动态的决定使用哪个数据源。在Springboot2中引入了AbstractRoutingDataSource这个类，这个类的作用是充当DataSource的路由中介，能够在运行时，根据key来动态切换DataSource。使用多数据源能够对多个数据库实例进行管理，这样可以有效的提升系统的水平伸缩性。而这样的方案就不同于传统的单一数据源，需要在运行时，根据请求上下文来动态的决定使用哪个数据源。该方法的作用的通过determineCurrentLookupKey方法是用于获取当前指定的数据源的key，根据这个key获取到指定的数据源，如果数据源为空那么使用默认的。那么可以想到通过重写此方法就可以改变数据源。该方法的作用的通过determineCurrentLookupKey方法是用于获取当前指定的数据源的key，根据这个key获取到指定的数据源，如果数据源为空那么使用默认的。那么可以想到通过重写此方法就可以改变数据源。该方法的作用的通过determineCurrentLookupKey方法是用于获取当前指定的数据源的key，根据这个key获取到指定的数据源，如果数据源为空那么使用默认的。那么可以想到通过重写此方法就可以改变数据源。', '2020-04-09 16:30:16', '2020-04-09 16:30:16', '1', '1', '1', '深度学习', '54', '64', '12', '54', '21');
INSERT INTO `blog` VALUES ('6', '深入理解SpringBoot多数据源', 'wuliang', '本文主要说明SpringBoot2配置Druid多数据源。', '本文主要说明SpringBoot2配置Druid多数据源。在Springboot2中引入了AbstractRoutingDataSource这个类，这个类的作用是充当DataSource的路由中介，能够在运行时，根据key来动态切换DataSource。使用多数据源能够对多个数据库实例进行管理，这样可以有效的提升系统的水平伸缩性。而这样的方案就不同于传统的单一数据源，需要在运行时，根据请求上下文来动态的决定使用哪个数据源。在Springboot2中引入了AbstractRoutingDataSource这个类，这个类的作用是充当DataSource的路由中介，能够在运行时，根据key来动态切换DataSource。使用多数据源能够对多个数据库实例进行管理，这样可以有效的提升系统的水平伸缩性。而这样的方案就不同于传统的单一数据源，需要在运行时，根据请求上下文来动态的决定使用哪个数据源。在Springboot2中引入了AbstractRoutingDataSource这个类，这个类的作用是充当DataSource的路由中介，能够在运行时，根据key来动态切换DataSource。使用多数据源能够对多个数据库实例进行管理，这样可以有效的提升系统的水平伸缩性。而这样的方案就不同于传统的单一数据源，需要在运行时，根据请求上下文来动态的决定使用哪个数据源。在Springboot2中引入了AbstractRoutingDataSource这个类，这个类的作用是充当DataSource的路由中介，能够在运行时，根据key来动态切换DataSource。使用多数据源能够对多个数据库实例进行管理，这样可以有效的提升系统的水平伸缩性。而这样的方案就不同于传统的单一数据源，需要在运行时，根据请求上下文来动态的决定使用哪个数据源。该方法的作用的通过determineCurrentLookupKey方法是用于获取当前指定的数据源的key，根据这个key获取到指定的数据源，如果数据源为空那么使用默认的。那么可以想到通过重写此方法就可以改变数据源。该方法的作用的通过determineCurrentLookupKey方法是用于获取当前指定的数据源的key，根据这个key获取到指定的数据源，如果数据源为空那么使用默认的。那么可以想到通过重写此方法就可以改变数据源。该方法的作用的通过determineCurrentLookupKey方法是用于获取当前指定的数据源的key，根据这个key获取到指定的数据源，如果数据源为空那么使用默认的。那么可以想到通过重写此方法就可以改变数据源。', '2020-04-09 21:16:04', '2020-04-09 21:16:04', '1', '1', '1', 'Java', '12', '64', '78', '54', '21');
INSERT INTO `blog` VALUES ('7', '深入理解SpringBoot多数据源', 'wuliang', '本文主要说明SpringBoot2配置Druid多数据源。', '本文主要说明SpringBoot2配置Druid多数据源。在Springboot2中引入了AbstractRoutingDataSource这个类，这个类的作用是充当DataSource的路由中介，能够在运行时，根据key来动态切换DataSource。使用多数据源能够对多个数据库实例进行管理，这样可以有效的提升系统的水平伸缩性。而这样的方案就不同于传统的单一数据源，需要在运行时，根据请求上下文来动态的决定使用哪个数据源。在Springboot2中引入了AbstractRoutingDataSource这个类，这个类的作用是充当DataSource的路由中介，能够在运行时，根据key来动态切换DataSource。使用多数据源能够对多个数据库实例进行管理，这样可以有效的提升系统的水平伸缩性。而这样的方案就不同于传统的单一数据源，需要在运行时，根据请求上下文来动态的决定使用哪个数据源。在Springboot2中引入了AbstractRoutingDataSource这个类，这个类的作用是充当DataSource的路由中介，能够在运行时，根据key来动态切换DataSource。使用多数据源能够对多个数据库实例进行管理，这样可以有效的提升系统的水平伸缩性。而这样的方案就不同于传统的单一数据源，需要在运行时，根据请求上下文来动态的决定使用哪个数据源。在Springboot2中引入了AbstractRoutingDataSource这个类，这个类的作用是充当DataSource的路由中介，能够在运行时，根据key来动态切换DataSource。使用多数据源能够对多个数据库实例进行管理，这样可以有效的提升系统的水平伸缩性。而这样的方案就不同于传统的单一数据源，需要在运行时，根据请求上下文来动态的决定使用哪个数据源。该方法的作用的通过determineCurrentLookupKey方法是用于获取当前指定的数据源的key，根据这个key获取到指定的数据源，如果数据源为空那么使用默认的。那么可以想到通过重写此方法就可以改变数据源。该方法的作用的通过determineCurrentLookupKey方法是用于获取当前指定的数据源的key，根据这个key获取到指定的数据源，如果数据源为空那么使用默认的。那么可以想到通过重写此方法就可以改变数据源。该方法的作用的通过determineCurrentLookupKey方法是用于获取当前指定的数据源的key，根据这个key获取到指定的数据源，如果数据源为空那么使用默认的。那么可以想到通过重写此方法就可以改变数据源。', '2020-04-09 16:30:18', '2020-04-09 16:30:18', '1', '1', '1', 'Python', '54', '64', '12', '54', '21');
INSERT INTO `blog` VALUES ('8', '深入理解SpringBoot多数据源', 'wuliang', '本文主要说明SpringBoot2配置Druid多数据源。', '本文主要说明SpringBoot2配置Druid多数据源。在Springboot2中引入了AbstractRoutingDataSource这个类，这个类的作用是充当DataSource的路由中介，能够在运行时，根据key来动态切换DataSource。使用多数据源能够对多个数据库实例进行管理，这样可以有效的提升系统的水平伸缩性。而这样的方案就不同于传统的单一数据源，需要在运行时，根据请求上下文来动态的决定使用哪个数据源。在Springboot2中引入了AbstractRoutingDataSource这个类，这个类的作用是充当DataSource的路由中介，能够在运行时，根据key来动态切换DataSource。使用多数据源能够对多个数据库实例进行管理，这样可以有效的提升系统的水平伸缩性。而这样的方案就不同于传统的单一数据源，需要在运行时，根据请求上下文来动态的决定使用哪个数据源。在Springboot2中引入了AbstractRoutingDataSource这个类，这个类的作用是充当DataSource的路由中介，能够在运行时，根据key来动态切换DataSource。使用多数据源能够对多个数据库实例进行管理，这样可以有效的提升系统的水平伸缩性。而这样的方案就不同于传统的单一数据源，需要在运行时，根据请求上下文来动态的决定使用哪个数据源。在Springboot2中引入了AbstractRoutingDataSource这个类，这个类的作用是充当DataSource的路由中介，能够在运行时，根据key来动态切换DataSource。使用多数据源能够对多个数据库实例进行管理，这样可以有效的提升系统的水平伸缩性。而这样的方案就不同于传统的单一数据源，需要在运行时，根据请求上下文来动态的决定使用哪个数据源。该方法的作用的通过determineCurrentLookupKey方法是用于获取当前指定的数据源的key，根据这个key获取到指定的数据源，如果数据源为空那么使用默认的。那么可以想到通过重写此方法就可以改变数据源。该方法的作用的通过determineCurrentLookupKey方法是用于获取当前指定的数据源的key，根据这个key获取到指定的数据源，如果数据源为空那么使用默认的。那么可以想到通过重写此方法就可以改变数据源。该方法的作用的通过determineCurrentLookupKey方法是用于获取当前指定的数据源的key，根据这个key获取到指定的数据源，如果数据源为空那么使用默认的。那么可以想到通过重写此方法就可以改变数据源。', '2020-04-09 21:15:52', '2020-04-09 21:15:52', '1', '1', '1', 'Java', '54', '32', '12', '54', '21');
INSERT INTO `blog` VALUES ('9', '深入理解SpringBoot多数据源', 'zhangsan', '本文主要说明SpringBoot2配置Druid多数据源。', '本文主要说明SpringBoot2配置Druid多数据源。在Springboot2中引入了AbstractRoutingDataSource这个类，这个类的作用是充当DataSource的路由中介，能够在运行时，根据key来动态切换DataSource。使用多数据源能够对多个数据库实例进行管理，这样可以有效的提升系统的水平伸缩性。而这样的方案就不同于传统的单一数据源，需要在运行时，根据请求上下文来动态的决定使用哪个数据源。在Springboot2中引入了AbstractRoutingDataSource这个类，这个类的作用是充当DataSource的路由中介，能够在运行时，根据key来动态切换DataSource。使用多数据源能够对多个数据库实例进行管理，这样可以有效的提升系统的水平伸缩性。而这样的方案就不同于传统的单一数据源，需要在运行时，根据请求上下文来动态的决定使用哪个数据源。在Springboot2中引入了AbstractRoutingDataSource这个类，这个类的作用是充当DataSource的路由中介，能够在运行时，根据key来动态切换DataSource。使用多数据源能够对多个数据库实例进行管理，这样可以有效的提升系统的水平伸缩性。而这样的方案就不同于传统的单一数据源，需要在运行时，根据请求上下文来动态的决定使用哪个数据源。在Springboot2中引入了AbstractRoutingDataSource这个类，这个类的作用是充当DataSource的路由中介，能够在运行时，根据key来动态切换DataSource。使用多数据源能够对多个数据库实例进行管理，这样可以有效的提升系统的水平伸缩性。而这样的方案就不同于传统的单一数据源，需要在运行时，根据请求上下文来动态的决定使用哪个数据源。该方法的作用的通过determineCurrentLookupKey方法是用于获取当前指定的数据源的key，根据这个key获取到指定的数据源，如果数据源为空那么使用默认的。那么可以想到通过重写此方法就可以改变数据源。该方法的作用的通过determineCurrentLookupKey方法是用于获取当前指定的数据源的key，根据这个key获取到指定的数据源，如果数据源为空那么使用默认的。那么可以想到通过重写此方法就可以改变数据源。该方法的作用的通过determineCurrentLookupKey方法是用于获取当前指定的数据源的key，根据这个key获取到指定的数据源，如果数据源为空那么使用默认的。那么可以想到通过重写此方法就可以改变数据源。', '2020-04-09 21:15:54', '2020-04-09 21:15:54', '1', '1', '1', 'C/C++', '54', '5', '12', '54', '21');
INSERT INTO `blog` VALUES ('10', '深入理解SpringBoot多数据源', 'zhangsan', '本文主要说明SpringBoot2配置Druid多数据源。', '本文主要说明SpringBoot2配置Druid多数据源。在Springboot2中引入了AbstractRoutingDataSource这个类，这个类的作用是充当DataSource的路由中介，能够在运行时，根据key来动态切换DataSource。使用多数据源能够对多个数据库实例进行管理，这样可以有效的提升系统的水平伸缩性。而这样的方案就不同于传统的单一数据源，需要在运行时，根据请求上下文来动态的决定使用哪个数据源。在Springboot2中引入了AbstractRoutingDataSource这个类，这个类的作用是充当DataSource的路由中介，能够在运行时，根据key来动态切换DataSource。使用多数据源能够对多个数据库实例进行管理，这样可以有效的提升系统的水平伸缩性。而这样的方案就不同于传统的单一数据源，需要在运行时，根据请求上下文来动态的决定使用哪个数据源。在Springboot2中引入了AbstractRoutingDataSource这个类，这个类的作用是充当DataSource的路由中介，能够在运行时，根据key来动态切换DataSource。使用多数据源能够对多个数据库实例进行管理，这样可以有效的提升系统的水平伸缩性。而这样的方案就不同于传统的单一数据源，需要在运行时，根据请求上下文来动态的决定使用哪个数据源。在Springboot2中引入了AbstractRoutingDataSource这个类，这个类的作用是充当DataSource的路由中介，能够在运行时，根据key来动态切换DataSource。使用多数据源能够对多个数据库实例进行管理，这样可以有效的提升系统的水平伸缩性。而这样的方案就不同于传统的单一数据源，需要在运行时，根据请求上下文来动态的决定使用哪个数据源。该方法的作用的通过determineCurrentLookupKey方法是用于获取当前指定的数据源的key，根据这个key获取到指定的数据源，如果数据源为空那么使用默认的。那么可以想到通过重写此方法就可以改变数据源。该方法的作用的通过determineCurrentLookupKey方法是用于获取当前指定的数据源的key，根据这个key获取到指定的数据源，如果数据源为空那么使用默认的。那么可以想到通过重写此方法就可以改变数据源。该方法的作用的通过determineCurrentLookupKey方法是用于获取当前指定的数据源的key，根据这个key获取到指定的数据源，如果数据源为空那么使用默认的。那么可以想到通过重写此方法就可以改变数据源。', '2020-04-09 21:15:57', '2020-04-09 21:15:57', '1', '1', '1', '深度学习', '7', '64', '12', '54', '21');
INSERT INTO `blog` VALUES ('11', '深入理解SpringBoot多数据源', 'test1', '本文主要说明SpringBoot2配置Druid多数据源。', '本文主要说明SpringBoot2配置Druid多数据源。在Springboot2中引入了AbstractRoutingDataSource这个类，这个类的作用是充当DataSource的路由中介，能够在运行时，根据key来动态切换DataSource。使用多数据源能够对多个数据库实例进行管理，这样可以有效的提升系统的水平伸缩性。而这样的方案就不同于传统的单一数据源，需要在运行时，根据请求上下文来动态的决定使用哪个数据源。在Springboot2中引入了AbstractRoutingDataSource这个类，这个类的作用是充当DataSource的路由中介，能够在运行时，根据key来动态切换DataSource。使用多数据源能够对多个数据库实例进行管理，这样可以有效的提升系统的水平伸缩性。而这样的方案就不同于传统的单一数据源，需要在运行时，根据请求上下文来动态的决定使用哪个数据源。在Springboot2中引入了AbstractRoutingDataSource这个类，这个类的作用是充当DataSource的路由中介，能够在运行时，根据key来动态切换DataSource。使用多数据源能够对多个数据库实例进行管理，这样可以有效的提升系统的水平伸缩性。而这样的方案就不同于传统的单一数据源，需要在运行时，根据请求上下文来动态的决定使用哪个数据源。在Springboot2中引入了AbstractRoutingDataSource这个类，这个类的作用是充当DataSource的路由中介，能够在运行时，根据key来动态切换DataSource。使用多数据源能够对多个数据库实例进行管理，这样可以有效的提升系统的水平伸缩性。而这样的方案就不同于传统的单一数据源，需要在运行时，根据请求上下文来动态的决定使用哪个数据源。该方法的作用的通过determineCurrentLookupKey方法是用于获取当前指定的数据源的key，根据这个key获取到指定的数据源，如果数据源为空那么使用默认的。那么可以想到通过重写此方法就可以改变数据源。该方法的作用的通过determineCurrentLookupKey方法是用于获取当前指定的数据源的key，根据这个key获取到指定的数据源，如果数据源为空那么使用默认的。那么可以想到通过重写此方法就可以改变数据源。该方法的作用的通过determineCurrentLookupKey方法是用于获取当前指定的数据源的key，根据这个key获取到指定的数据源，如果数据源为空那么使用默认的。那么可以想到通过重写此方法就可以改变数据源。', '2020-04-09 16:30:17', '2020-04-09 16:30:17', '1', '1', '1', 'Java', '54', '64', '12', '54', '21');
INSERT INTO `blog` VALUES ('12', '深入理解SpringBoot多数据源', 'zhangsan', '本文主要说明SpringBoot2配置Druid多数据源。', '本文主要说明SpringBoot2配置Druid多数据源。在Springboot2中引入了AbstractRoutingDataSource这个类，这个类的作用是充当DataSource的路由中介，能够在运行时，根据key来动态切换DataSource。使用多数据源能够对多个数据库实例进行管理，这样可以有效的提升系统的水平伸缩性。而这样的方案就不同于传统的单一数据源，需要在运行时，根据请求上下文来动态的决定使用哪个数据源。在Springboot2中引入了AbstractRoutingDataSource这个类，这个类的作用是充当DataSource的路由中介，能够在运行时，根据key来动态切换DataSource。使用多数据源能够对多个数据库实例进行管理，这样可以有效的提升系统的水平伸缩性。而这样的方案就不同于传统的单一数据源，需要在运行时，根据请求上下文来动态的决定使用哪个数据源。在Springboot2中引入了AbstractRoutingDataSource这个类，这个类的作用是充当DataSource的路由中介，能够在运行时，根据key来动态切换DataSource。使用多数据源能够对多个数据库实例进行管理，这样可以有效的提升系统的水平伸缩性。而这样的方案就不同于传统的单一数据源，需要在运行时，根据请求上下文来动态的决定使用哪个数据源。在Springboot2中引入了AbstractRoutingDataSource这个类，这个类的作用是充当DataSource的路由中介，能够在运行时，根据key来动态切换DataSource。使用多数据源能够对多个数据库实例进行管理，这样可以有效的提升系统的水平伸缩性。而这样的方案就不同于传统的单一数据源，需要在运行时，根据请求上下文来动态的决定使用哪个数据源。该方法的作用的通过determineCurrentLookupKey方法是用于获取当前指定的数据源的key，根据这个key获取到指定的数据源，如果数据源为空那么使用默认的。那么可以想到通过重写此方法就可以改变数据源。该方法的作用的通过determineCurrentLookupKey方法是用于获取当前指定的数据源的key，根据这个key获取到指定的数据源，如果数据源为空那么使用默认的。那么可以想到通过重写此方法就可以改变数据源。该方法的作用的通过determineCurrentLookupKey方法是用于获取当前指定的数据源的key，根据这个key获取到指定的数据源，如果数据源为空那么使用默认的。那么可以想到通过重写此方法就可以改变数据源。', '2020-04-09 21:15:59', '2020-04-09 21:15:59', '1', '1', '1', '闲言碎语', '54', '64', '8', '54', '21');

-- ----------------------------
-- Table structure for blog_catagory
-- ----------------------------
DROP TABLE IF EXISTS `blog_catagory`;
CREATE TABLE `blog_catagory` (
  `blog_id` int(11) NOT NULL,
  `catagory_id` int(11) NOT NULL,
  PRIMARY KEY (`blog_id`,`catagory_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='博客分类表';

-- ----------------------------
-- Records of blog_catagory
-- ----------------------------
INSERT INTO `blog_catagory` VALUES ('1', '5');

-- ----------------------------
-- Table structure for blog_comment
-- ----------------------------
DROP TABLE IF EXISTS `blog_comment`;
CREATE TABLE `blog_comment` (
  `comment_id` int(11) NOT NULL COMMENT '每一条评论都有一个id，其他都是回复blog_comment_id',
  `blog_id` int(11) NOT NULL COMMENT '评论的博客',
  `comment_content` text NOT NULL,
  `comment_parent` varchar(11) NOT NULL COMMENT '0直接评论blog_id的，其他都是',
  `comment_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
  `commentator` varchar(45) NOT NULL COMMENT '是谁评论的',
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='博客评论表';

-- ----------------------------
-- Records of blog_comment
-- ----------------------------
INSERT INTO `blog_comment` VALUES ('1', '1', '说的好啊', '0', '2019-11-10 13:36:25.793654', '2');
INSERT INTO `blog_comment` VALUES ('2', '1', '你就只会水评论', '1', '2019-11-10 00:00:00.000000', '3');

-- ----------------------------
-- Table structure for blog_comment_liked
-- ----------------------------
DROP TABLE IF EXISTS `blog_comment_liked`;
CREATE TABLE `blog_comment_liked` (
  `comment_id` int(11) NOT NULL,
  `username` varchar(45) NOT NULL COMMENT '对评论 点赞或点踩 的人',
  `status` int(2) NOT NULL COMMENT '0代表踩，1代表赞',
  `liked_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='博客评论点赞表';

-- ----------------------------
-- Records of blog_comment_liked
-- ----------------------------
INSERT INTO `blog_comment_liked` VALUES ('2', 'zhangsan', '1', '2019-11-10 00:00:00.000000');

-- ----------------------------
-- Table structure for blog_liked
-- ----------------------------
DROP TABLE IF EXISTS `blog_liked`;
CREATE TABLE `blog_liked` (
  `blog_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL COMMENT '对博客点踩或点赞 的人',
  `status` int(2) NOT NULL COMMENT '0代表踩，1代表赞',
  PRIMARY KEY (`blog_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='博客点赞表';

-- ----------------------------
-- Records of blog_liked
-- ----------------------------
INSERT INTO `blog_liked` VALUES ('1', 'test1', '1');

-- ----------------------------
-- Table structure for blog_tag
-- ----------------------------
DROP TABLE IF EXISTS `blog_tag`;
CREATE TABLE `blog_tag` (
  `tag_id` int(11) NOT NULL,
  `blog_id` int(11) NOT NULL,
  KEY `FKd0y9mfvb4wsvn1yi3a9jhsase` (`blog_id`),
  KEY `FKt7qwebglmm62nfymnl5xwpbws` (`tag_id`),
  CONSTRAINT `FKd0y9mfvb4wsvn1yi3a9jhsase` FOREIGN KEY (`blog_id`) REFERENCES `blog` (`blog_id`),
  CONSTRAINT `FKsks3xn5jn9csbt4km3kqaa83m` FOREIGN KEY (`blog_id`) REFERENCES `tag` (`tag_id`),
  CONSTRAINT `FKt7qwebglmm62nfymnl5xwpbws` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='博客标签表';

-- ----------------------------
-- Records of blog_tag
-- ----------------------------
INSERT INTO `blog_tag` VALUES ('1', '1');
INSERT INTO `blog_tag` VALUES ('3', '1');
INSERT INTO `blog_tag` VALUES ('3', '6');
INSERT INTO `blog_tag` VALUES ('4', '1');
INSERT INTO `blog_tag` VALUES ('4', '5');
INSERT INTO `blog_tag` VALUES ('5', '1');
INSERT INTO `blog_tag` VALUES ('6', '7');
INSERT INTO `blog_tag` VALUES ('8', '5');

-- ----------------------------
-- Table structure for blog_visit_log
-- ----------------------------
DROP TABLE IF EXISTS `blog_visit_log`;
CREATE TABLE `blog_visit_log` (
  `visit_id` int(11) NOT NULL,
  `ip_addr` int(11) DEFAULT NULL,
  `location` varchar(45) DEFAULT NULL,
  `browser` varchar(11) NOT NULL,
  `os` varchar(11) NOT NULL,
  `request_url` varchar(45) NOT NULL,
  `title` varchar(11) NOT NULL COMMENT '访问标题',
  `visit_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
  `visitor` varchar(45) DEFAULT NULL COMMENT '访客',
  PRIMARY KEY (`visit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='博客浏览记录表';

-- ----------------------------
-- Records of blog_visit_log
-- ----------------------------

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(45) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='分类表';

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', 'Java', null);
INSERT INTO `category` VALUES ('2', 'C/C++', null);
INSERT INTO `category` VALUES ('3', 'Python', null);
INSERT INTO `category` VALUES ('4', 'Spring Boot', null);
INSERT INTO `category` VALUES ('5', '大数据', null);
INSERT INTO `category` VALUES ('6', '深度学习', null);
INSERT INTO `category` VALUES ('7', '闲言碎语', null);

-- ----------------------------
-- Table structure for followee
-- ----------------------------
DROP TABLE IF EXISTS `followee`;
CREATE TABLE `followee` (
  `followee_id` int(11) NOT NULL COMMENT '我关注的人的id',
  `fan_id` int(11) DEFAULT NULL COMMENT '我的id(我是粉丝)',
  PRIMARY KEY (`followee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='关注博主表';

-- ----------------------------
-- Records of followee
-- ----------------------------
INSERT INTO `followee` VALUES ('1', '2');
INSERT INTO `followee` VALUES ('3', '1');

-- ----------------------------
-- Table structure for medal
-- ----------------------------
DROP TABLE IF EXISTS `medal`;
CREATE TABLE `medal` (
  `medal_id` int(11) NOT NULL,
  `medal_name` varchar(45) NOT NULL,
  `medal_img` varchar(45) NOT NULL COMMENT '勋章图片',
  `description` varchar(65) NOT NULL COMMENT '勋章描述',
  PRIMARY KEY (`medal_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='徽章表';

-- ----------------------------
-- Records of medal
-- ----------------------------
INSERT INTO `medal` VALUES ('1', '博览群文', 'img', '阅读总文章超过30篇');
INSERT INTO `medal` VALUES ('2', '勤写标兵', 'img', '每个星期至少发表一篇文章，持续四周以上，之后两个星期未发文取消勋章');
INSERT INTO `medal` VALUES ('3', '推荐红人', 'img', '超过1篇文章被推荐到博客社区');
INSERT INTO `medal` VALUES ('4', 'GitHub', 'img', '绑定GitHub即可获得');
INSERT INTO `medal` VALUES ('5', '博客专家', 'img', '博客等级达到6级以上即可获得');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限菜单表';

-- ----------------------------
-- Records of menu
-- ----------------------------

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `message_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL COMMENT '博主',
  `message_parent` varchar(45) NOT NULL COMMENT '0代表留的言，1代表留言的 留言，按时间降序',
  `message_people` varchar(45) NOT NULL COMMENT '留言者的用户名',
  `content` text NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`message_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('1', 'wuliang', '0', 'test1', '我最近导入你的一个项目报错404，你可以帮我解决下吗', '2020-04-09 18:37:36');
INSERT INTO `message` VALUES ('2', 'wuliang', '0', 'zhangsan', '好的，加我qq1726436515，我帮你解决', '2020-04-09 18:31:02');
INSERT INTO `message` VALUES ('3', 'zhangsan', '0', 'wuliang', '看看', '2020-04-09 18:31:00');
INSERT INTO `message` VALUES ('4', 'wuliang', '0', 'test1', '哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈', '2020-04-09 18:30:57');
INSERT INTO `message` VALUES ('5', 'zhangsan', '0', 'wuliang', '是的快捷方式的空间', '2020-04-09 18:37:54');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL,
  `is_enable` int(1) DEFAULT NULL,
  `role_name` varchar(45) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '1', 'ROLE_USER', null);
INSERT INTO `role` VALUES ('2', '1', 'ROLE_USER_no_recommend', null);
INSERT INTO `role` VALUES ('3', '1', 'ROLE_USER_no_message', null);
INSERT INTO `role` VALUES ('4', '1', 'ROLE_USER_no_dislike', null);
INSERT INTO `role` VALUES ('5', '1', 'ROLE_ADMIN', null);
INSERT INTO `role` VALUES ('6', '1', 'ROLE_SUPERADMIN', null);

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `role_id` int(11) NOT NULL,
  `menu_id` int(11) NOT NULL,
  KEY `FKfg4e2mb2318tph615gh44ll3` (`menu_id`),
  KEY `FKqyvxw2gg2qk0wld3bqfcb58vq` (`role_id`),
  CONSTRAINT `FKfg4e2mb2318tph615gh44ll3` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`menu_id`),
  CONSTRAINT `FKqyvxw2gg2qk0wld3bqfcb58vq` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色菜单表';

-- ----------------------------
-- Records of role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag` (
  `tag_id` int(11) NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`tag_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tag
-- ----------------------------
INSERT INTO `tag` VALUES ('1', 'Java');
INSERT INTO `tag` VALUES ('2', 'C');
INSERT INTO `tag` VALUES ('3', 'C++');
INSERT INTO `tag` VALUES ('4', 'Python');
INSERT INTO `tag` VALUES ('5', 'Spring Boot');
INSERT INTO `tag` VALUES ('6', 'Linux');
INSERT INTO `tag` VALUES ('7', 'MySQL');
INSERT INTO `tag` VALUES ('8', '算法');
INSERT INTO `tag` VALUES ('9', '深度学习');
INSERT INTO `tag` VALUES ('10', '机器学习');
INSERT INTO `tag` VALUES ('11', 'SSM');
INSERT INTO `tag` VALUES ('12', 'Spring');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(11) NOT NULL COMMENT '登录用户名',
  `nickname` varchar(45) NOT NULL COMMENT '昵称',
  `pwd` varchar(45) NOT NULL,
  `sex` varchar(1) NOT NULL COMMENT '1=''男''，0=''女''',
  `birth` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
  `address` varchar(45) DEFAULT NULL,
  `education` varchar(3) DEFAULT NULL,
  `career` varchar(11) DEFAULT NULL,
  `self_introduction` varchar(255) DEFAULT NULL,
  `dream` varchar(255) DEFAULT NULL,
  `technology` varchar(255) DEFAULT NULL,
  `project` varchar(255) DEFAULT NULL,
  `hobby` varchar(255) DEFAULT NULL,
  `join_date` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
  `blog_num` int(11) NOT NULL,
  `commend_times` int(11) NOT NULL,
  `disliked_times` int(11) NOT NULL,
  `fans` int(11) NOT NULL,
  `followers` int(11) NOT NULL,
  `grade` int(11) NOT NULL,
  `liked_times` int(11) NOT NULL,
  `pageviews` int(11) NOT NULL,
  `visitors` int(11) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户的一些基本信息';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'wuliang', 'hypocrisy', '123456', '1', '1997-10-15 00:00:00.000000', '成都市双流区', '本科', '学生', '我是一个人', '快乐', '全能', 'AI', 'entertainment', '2019-11-10 00:00:00.000000', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `user` VALUES ('2', 'test1', '测试', '123456', '0', '1997-10-15 00:00:00.000000', '成都市双流区', '硕士', 'Java开发工程', null, null, null, null, null, '2019-11-10 00:00:00.000000', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `user` VALUES ('3', 'zhangsan', '张三', '123456', '1', '1998-11-20 00:00:00.000000', '成都市高新区', '博士', '深度学习算法工程师', '我是一个大佬', null, null, null, null, '2018-09-05 00:00:00.000000', '0', '0', '0', '0', '0', '0', '0', '0', '0');

-- ----------------------------
-- Table structure for user_medal
-- ----------------------------
DROP TABLE IF EXISTS `user_medal`;
CREATE TABLE `user_medal` (
  `username` varchar(11) NOT NULL,
  `medal_id` int(11) NOT NULL,
  PRIMARY KEY (`username`,`medal_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_medal
-- ----------------------------
INSERT INTO `user_medal` VALUES ('1', '1');
INSERT INTO `user_medal` VALUES ('1', '2');
INSERT INTO `user_medal` VALUES ('1', '3');
INSERT INTO `user_medal` VALUES ('1', '4');
INSERT INTO `user_medal` VALUES ('1', '5');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `role_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `username` bigint(20) NOT NULL,
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  KEY `FK859n2jvi8ivhui0rl0esws6o` (`user_id`),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '0');
INSERT INTO `user_role` VALUES ('5', '3', '0');
INSERT INTO `user_role` VALUES ('6', '2', '0');

-- ----------------------------
-- Table structure for website_config
-- ----------------------------
DROP TABLE IF EXISTS `website_config`;
CREATE TABLE `website_config` (
  `config_id` int(11) NOT NULL AUTO_INCREMENT,
  `author_name` varchar(11) NOT NULL,
  `blog_name` varchar(45) NOT NULL,
  `domain_name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `record_number` varchar(45) NOT NULL COMMENT '备案号',
  `theme` varchar(11) NOT NULL DEFAULT 'delicate' COMMENT '网站风格',
  PRIMARY KEY (`config_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of website_config
-- ----------------------------
INSERT INTO `website_config` VALUES ('1', 'wuliang', '吴小亮的博客', 'gourddoll.cn', '1726436515@qq.com', '蜀ICP备 19004343', 'delicate');

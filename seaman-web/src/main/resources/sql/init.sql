/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1 pg
 Source Server Type    : PostgreSQL
 Source Server Version : 90609
 Source Host           : 127.0.0.1:5432
 Source Catalog        : seaman
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 90609
 File Encoding         : 65001

 Date: 30/06/2018 21:17:29
*/


-- ----------------------------
-- Table structure for tb_upm_log
-- ----------------------------
DROP TABLE IF EXISTS "tb_upm_log";
CREATE TABLE "tb_upm_log" (
  "log_id" varchar(128) COLLATE "pg_catalog"."default" NOT NULL DEFAULT uuid_generate_v4(),
  "description" varchar(100) COLLATE "pg_catalog"."default",
  "username" varchar(20) COLLATE "pg_catalog"."default",
  "start_time" int8,
  "spend_time" int4 NOT NULL,
  "base_path" varchar(500) COLLATE "pg_catalog"."default",
  "uri" varchar(500) COLLATE "pg_catalog"."default",
  "url" varchar(500) COLLATE "pg_catalog"."default",
  "method" varchar(10) COLLATE "pg_catalog"."default",
  "parameter" text COLLATE "pg_catalog"."default",
  "user_agent" varchar(500) COLLATE "pg_catalog"."default",
  "ip" varchar(30) COLLATE "pg_catalog"."default",
  "result" text COLLATE "pg_catalog"."default",
  "permissions" varchar(100) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "tb_upm_log"."log_id" IS '编号';
COMMENT ON COLUMN "tb_upm_log"."description" IS '操作描述';
COMMENT ON COLUMN "tb_upm_log"."username" IS '操作用户';
COMMENT ON COLUMN "tb_upm_log"."start_time" IS '操作时间';
COMMENT ON COLUMN "tb_upm_log"."spend_time" IS '消耗时间';
COMMENT ON COLUMN "tb_upm_log"."base_path" IS '根路径';
COMMENT ON COLUMN "tb_upm_log"."uri" IS 'URI';
COMMENT ON COLUMN "tb_upm_log"."url" IS 'URL';
COMMENT ON COLUMN "tb_upm_log"."method" IS '请求类型';
COMMENT ON COLUMN "tb_upm_log"."parameter" IS '请求参数';
COMMENT ON COLUMN "tb_upm_log"."user_agent" IS '用户标识';
COMMENT ON COLUMN "tb_upm_log"."ip" IS 'IP地址';
COMMENT ON COLUMN "tb_upm_log"."result" IS '请求的结果';
COMMENT ON COLUMN "tb_upm_log"."permissions" IS '权限值';
COMMENT ON TABLE "tb_upm_log" IS 'upm模块的日志表';

-- ----------------------------
-- Table structure for tb_upm_organization
-- ----------------------------
DROP TABLE IF EXISTS "tb_upm_organization";
CREATE TABLE "tb_upm_organization" (
  "organization_id" varchar(128) COLLATE "pg_catalog"."default" NOT NULL DEFAULT uuid_generate_v4(),
  "parent_id" varchar(128) COLLATE "pg_catalog"."default",
  "name" varchar(20) COLLATE "pg_catalog"."default",
  "description" text COLLATE "pg_catalog"."default",
  "create_time" timestamptz(6)
)
;
COMMENT ON COLUMN "tb_upm_organization"."organization_id" IS '组织编号';
COMMENT ON COLUMN "tb_upm_organization"."parent_id" IS '所属上级编号';
COMMENT ON COLUMN "tb_upm_organization"."name" IS '组织名称';
COMMENT ON COLUMN "tb_upm_organization"."description" IS '组织描述';
COMMENT ON COLUMN "tb_upm_organization"."create_time" IS '创建时间';
COMMENT ON TABLE "tb_upm_organization" IS 'upm模块的组织表';

-- ----------------------------
-- Table structure for tb_upm_permission
-- ----------------------------
DROP TABLE IF EXISTS "tb_upm_permission";
CREATE TABLE "tb_upm_permission" (
  "permission_id" varchar(128) COLLATE "pg_catalog"."default" NOT NULL DEFAULT uuid_generate_v4(),
  "system_id" varchar(128) COLLATE "pg_catalog"."default" NOT NULL,
  "parent_id" varchar(128) COLLATE "pg_catalog"."default",
  "name" varchar(20) COLLATE "pg_catalog"."default",
  "type" int2,
  "permission_value" varchar(50) COLLATE "pg_catalog"."default",
  "uri" varchar(100) COLLATE "pg_catalog"."default",
  "icon" varchar(50) COLLATE "pg_catalog"."default",
  "status" int2,
  "create_time" timestamptz(6),
  "order" int4
)
;
COMMENT ON COLUMN "tb_upm_permission"."permission_id" IS '权限编号';
COMMENT ON COLUMN "tb_upm_permission"."system_id" IS '所属系统编号';
COMMENT ON COLUMN "tb_upm_permission"."parent_id" IS '所属上级编号';
COMMENT ON COLUMN "tb_upm_permission"."name" IS '名称';
COMMENT ON COLUMN "tb_upm_permission"."type" IS '类型(1:目录,2:菜单,3:按钮)';
COMMENT ON COLUMN "tb_upm_permission"."permission_value" IS '权限值';
COMMENT ON COLUMN "tb_upm_permission"."uri" IS '路径';
COMMENT ON COLUMN "tb_upm_permission"."icon" IS '图标';
COMMENT ON COLUMN "tb_upm_permission"."status" IS '状态(0:禁止,1:正常)';
COMMENT ON COLUMN "tb_upm_permission"."create_time" IS '创建时间';
COMMENT ON COLUMN "tb_upm_permission"."order" IS '排序';
COMMENT ON TABLE "tb_upm_permission" IS 'upm模块的权限表';

-- ----------------------------
-- Table structure for tb_upm_role
-- ----------------------------
DROP TABLE IF EXISTS "tb_upm_role";
CREATE TABLE "tb_upm_role" (
  "role_id" varchar(128) COLLATE "pg_catalog"."default" NOT NULL DEFAULT uuid_generate_v4(),
  "name" varchar(20) COLLATE "pg_catalog"."default",
  "title" varchar(20) COLLATE "pg_catalog"."default",
  "description" text COLLATE "pg_catalog"."default",
  "create_time" timestamptz(6),
  "order" int4
)
;
COMMENT ON COLUMN "tb_upm_role"."role_id" IS '角色编号';
COMMENT ON COLUMN "tb_upm_role"."name" IS '角色名称';
COMMENT ON COLUMN "tb_upm_role"."title" IS '角色标题';
COMMENT ON COLUMN "tb_upm_role"."description" IS '角色描述';
COMMENT ON COLUMN "tb_upm_role"."create_time" IS '创建时间';
COMMENT ON COLUMN "tb_upm_role"."order" IS '排序';
COMMENT ON TABLE "tb_upm_role" IS 'upm的角色表';

-- ----------------------------
-- Table structure for tb_upm_role_permission
-- ----------------------------
DROP TABLE IF EXISTS "tb_upm_role_permission";
CREATE TABLE "tb_upm_role_permission" (
  "role_permission_id" varchar(128) COLLATE "pg_catalog"."default" NOT NULL DEFAULT uuid_generate_v4(),
  "role_id" varchar(128) COLLATE "pg_catalog"."default",
  "permission_id" varchar(128) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "tb_upm_role_permission"."role_permission_id" IS '编号';
COMMENT ON COLUMN "tb_upm_role_permission"."role_id" IS '角色编号';
COMMENT ON COLUMN "tb_upm_role_permission"."permission_id" IS '权限编号';
COMMENT ON TABLE "tb_upm_role_permission" IS 'upm的角色权限关联表';

-- ----------------------------
-- Table structure for tb_upm_system
-- ----------------------------
DROP TABLE IF EXISTS "tb_upm_system";
CREATE TABLE "tb_upm_system" (
  "system_id" varchar(128) COLLATE "pg_catalog"."default" NOT NULL DEFAULT uuid_generate_v4(),
  "icon" varchar(50) COLLATE "pg_catalog"."default",
  "banner" varchar(150) COLLATE "pg_catalog"."default",
  "theme" varchar(50) COLLATE "pg_catalog"."default",
  "base_path" varchar(100) COLLATE "pg_catalog"."default",
  "status" int2,
  "name" varchar(20) COLLATE "pg_catalog"."default",
  "title" varchar(20) COLLATE "pg_catalog"."default",
  "description" text COLLATE "pg_catalog"."default",
  "create_time" timestamptz(6),
  "order" int4
)
;
COMMENT ON COLUMN "tb_upm_system"."system_id" IS '系统编号';
COMMENT ON COLUMN "tb_upm_system"."icon" IS '图标';
COMMENT ON COLUMN "tb_upm_system"."banner" IS '背景';
COMMENT ON COLUMN "tb_upm_system"."theme" IS '主题';
COMMENT ON COLUMN "tb_upm_system"."base_path" IS '根目录';
COMMENT ON COLUMN "tb_upm_system"."status" IS '状态(-1:黑名单,1:正常)';
COMMENT ON COLUMN "tb_upm_system"."name" IS '系统名称';
COMMENT ON COLUMN "tb_upm_system"."title" IS '系统标题';
COMMENT ON COLUMN "tb_upm_system"."description" IS '系统描述';
COMMENT ON COLUMN "tb_upm_system"."create_time" IS '创建时间';
COMMENT ON COLUMN "tb_upm_system"."order" IS '排序';
COMMENT ON TABLE "tb_upm_system" IS 'upm的系统表';

-- ----------------------------
-- Table structure for tb_upm_user
-- ----------------------------
DROP TABLE IF EXISTS "tb_upm_user";
CREATE TABLE "tb_upm_user" (
  "user_id" varchar(128) COLLATE "pg_catalog"."default" NOT NULL DEFAULT uuid_generate_v4(),
  "username" varchar(20) COLLATE "pg_catalog"."default",
  "password" varchar(32) COLLATE "pg_catalog"."default",
  "salt" varchar(32) COLLATE "pg_catalog"."default",
  "realname" varchar(20) COLLATE "pg_catalog"."default",
  "avatar" varchar(150) COLLATE "pg_catalog"."default",
  "phone" varchar(20) COLLATE "pg_catalog"."default",
  "email" varchar(50) COLLATE "pg_catalog"."default",
  "sex" int2,
  "status" int2,
  "create_time" timestamptz(6)
)
;
COMMENT ON COLUMN "tb_upm_user"."user_id" IS '用户编号';
COMMENT ON COLUMN "tb_upm_user"."username" IS '账号';
COMMENT ON COLUMN "tb_upm_user"."password" IS '密码';
COMMENT ON COLUMN "tb_upm_user"."salt" IS '盐';
COMMENT ON COLUMN "tb_upm_user"."realname" IS '姓名';
COMMENT ON COLUMN "tb_upm_user"."avatar" IS '头像';
COMMENT ON COLUMN "tb_upm_user"."phone" IS '电话';
COMMENT ON COLUMN "tb_upm_user"."email" IS '邮箱';
COMMENT ON COLUMN "tb_upm_user"."sex" IS '性别';
COMMENT ON COLUMN "tb_upm_user"."status" IS '状态(0:正常,1:锁定)';
COMMENT ON COLUMN "tb_upm_user"."create_time" IS '创建时间';
COMMENT ON TABLE "tb_upm_user" IS 'upm的用户表';

-- ----------------------------
-- Table structure for tb_upm_user_organization
-- ----------------------------
DROP TABLE IF EXISTS "tb_upm_user_organization";
CREATE TABLE "tb_upm_user_organization" (
  "user_organization_id" varchar(128) COLLATE "pg_catalog"."default" NOT NULL DEFAULT uuid_generate_v4(),
  "user_id" varchar(128) COLLATE "pg_catalog"."default",
  "organization_id" varchar(128) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "tb_upm_user_organization"."user_organization_id" IS '编号';
COMMENT ON COLUMN "tb_upm_user_organization"."user_id" IS ' 用户编号';
COMMENT ON COLUMN "tb_upm_user_organization"."organization_id" IS '组织编号';
COMMENT ON TABLE "tb_upm_user_organization" IS 'upm的用户组织关联表';

-- ----------------------------
-- Table structure for tb_upm_user_permission
-- ----------------------------
DROP TABLE IF EXISTS "tb_upm_user_permission";
CREATE TABLE "tb_upm_user_permission" (
  "user_permission_id" varchar(128) COLLATE "pg_catalog"."default" NOT NULL DEFAULT uuid_generate_v4(),
  "user_id" varchar(128) COLLATE "pg_catalog"."default",
  "permission_id" varchar(128) COLLATE "pg_catalog"."default",
  "type" int2
)
;
COMMENT ON COLUMN "tb_upm_user_permission"."user_permission_id" IS '编号';
COMMENT ON COLUMN "tb_upm_user_permission"."user_id" IS '用户编号';
COMMENT ON COLUMN "tb_upm_user_permission"."permission_id" IS '权限编号';
COMMENT ON COLUMN "tb_upm_user_permission"."type" IS '权限类型(-1:减权限,1:增权限)';
COMMENT ON TABLE "tb_upm_user_permission" IS 'upm的用户权限关联表';

-- ----------------------------
-- Table structure for tb_upm_user_role
-- ----------------------------
DROP TABLE IF EXISTS "tb_upm_user_role";
CREATE TABLE "tb_upm_user_role" (
  "user_role_id" varchar(128) COLLATE "pg_catalog"."default" NOT NULL DEFAULT uuid_generate_v4(),
  "user_id" varchar(128) COLLATE "pg_catalog"."default",
  "role_id" varchar(128) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "tb_upm_user_role"."user_role_id" IS '编号';
COMMENT ON COLUMN "tb_upm_user_role"."user_id" IS '用户编号';
COMMENT ON COLUMN "tb_upm_user_role"."role_id" IS '角色编号';
COMMENT ON TABLE "tb_upm_user_role" IS 'upm的用户角色关联表';

-- ----------------------------
-- Primary Key structure for table tb_upm_log
-- ----------------------------
ALTER TABLE "tb_upm_log" ADD CONSTRAINT "tb_upm_log_pkey" PRIMARY KEY ("log_id");

-- ----------------------------
-- Primary Key structure for table tb_upm_organization
-- ----------------------------
ALTER TABLE "tb_upm_organization" ADD CONSTRAINT "tb_upm_organization_pkey" PRIMARY KEY ("organization_id");

-- ----------------------------
-- Primary Key structure for table tb_upm_permission
-- ----------------------------
ALTER TABLE "tb_upm_permission" ADD CONSTRAINT "tb_upm_permission_pkey" PRIMARY KEY ("permission_id");

-- ----------------------------
-- Primary Key structure for table tb_upm_role
-- ----------------------------
ALTER TABLE "tb_upm_role" ADD CONSTRAINT "tb_upm_role_pkey" PRIMARY KEY ("role_id");

-- ----------------------------
-- Primary Key structure for table tb_upm_role_permission
-- ----------------------------
ALTER TABLE "tb_upm_role_permission" ADD CONSTRAINT "tb_upm_role_permission_pkey" PRIMARY KEY ("role_permission_id");

-- ----------------------------
-- Primary Key structure for table tb_upm_system
-- ----------------------------
ALTER TABLE "tb_upm_system" ADD CONSTRAINT "tb_upm_system_pkey" PRIMARY KEY ("system_id");

-- ----------------------------
-- Primary Key structure for table tb_upm_user
-- ----------------------------
ALTER TABLE "tb_upm_user" ADD CONSTRAINT "tb_upm_user_pkey" PRIMARY KEY ("user_id");

-- ----------------------------
-- Primary Key structure for table tb_upm_user_organization
-- ----------------------------
ALTER TABLE "tb_upm_user_organization" ADD CONSTRAINT "tb_upm_user_organization_pkey" PRIMARY KEY ("user_organization_id");

-- ----------------------------
-- Primary Key structure for table tb_upm_user_permission
-- ----------------------------
ALTER TABLE "tb_upm_user_permission" ADD CONSTRAINT "tb_upm_user_permission_pkey" PRIMARY KEY ("user_permission_id");

-- ----------------------------
-- Primary Key structure for table tb_upm_user_role
-- ----------------------------
ALTER TABLE "tb_upm_user_role" ADD CONSTRAINT "tb_upm_user_role_pkey" PRIMARY KEY ("user_role_id");

-- ----------------------------
-- Foreign Keys structure for table tb_upm_role_permission
-- ----------------------------
ALTER TABLE "tb_upm_role_permission" ADD CONSTRAINT "fk_reference_1" FOREIGN KEY ("role_id") REFERENCES "tb_upm_role" ("role_id") ON DELETE CASCADE ON UPDATE CASCADE;
COMMENT ON CONSTRAINT "fk_reference_1" ON "tb_upm_role_permission" IS 'role_id外键';

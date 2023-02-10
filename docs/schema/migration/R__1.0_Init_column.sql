delimiter $$
drop procedure if exists modify_column $$
create procedure modify_column()
begin

   -- 建立数据表
    create table if not exists `xx` (
      `id` bigint(20) not null auto_increment,
      `member_id` bigint(20) not null        comment '',
      primary key (`id`)
    ) engine=innodb default charset=utf8mb4 comment='xx';

    -- 删除数据表
    if exists ( select column_name from information_schema.columns where table_name ='xxx')
      then drop table xx;
    end if;

    -- 修改字段
    if exists (select column_name from information_schema.columns where table_name ='xx' and column_name='from' )
        then alter table `xxx` change column `from` `from` bigint(20) null comment '推荐者';
    end if;

    -- 修改字段类型
    if (select data_type from information_schema.columns where table_name ='xxx' and column_name='retry_count') = 'tinyint'
        then alter table xxx modify retry_count int default 0 not null comment 'xx';
    end if;

    -- 添加字段
    if not exists ( select column_name from information_schema.columns where table_name ='xxx' and column_name='xxx')
      then alter table `xxx` add column xxx char null comment 'xx' after xx;
    end if;

    -- 删除字段
    if exists ( select column_name from information_schema.columns where table_name ='xx' and column_name='xx')
        then alter table `xx` drop column `xx`;
    end if;

end $$
delimiter ;
call modify_column;
drop procedure modify_column;

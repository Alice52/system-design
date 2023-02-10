delimiter $$
drop procedure if exists modify_data $$
create procedure modify_data()
begin

  if not exists (select index_name from information_schema.statistics where table_name = 'xx' and index_name = 'xx')
      then alter table `xx` add index xx(x, x);
  end if;

end $$
delimiter ;
call modify_data;
drop procedure modify_data;

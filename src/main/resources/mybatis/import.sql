--
--    Copyright 2015-2016 the original author or authors.
--
--    Licensed under the Apache License, Version 2.0 (the "License");
--    you may not use this file except in compliance with the License.
--    You may obtain a copy of the License at
--
--       http://www.apache.org/licenses/LICENSE-2.0
--
--    Unless required by applicable law or agreed to in writing, software
--    distributed under the License is distributed on an "AS IS" BASIS,
--    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
--    See the License for the specific language governing permissions and
--    limitations under the License.
--

use blog;

drop table if exists fest;

create table fest (id int primary key auto_increment, timing varchar(64), cal DATE);

insert into fest (timing, cal) values ('work', '2018-12-29');
insert into fest (timing, cal) values ('rest', '2018-12-30');
insert into fest (timing, cal) values ('rest', '2018-12-31');
insert into fest (timing, cal) values ('rest', '2019-01-01');
insert into fest (timing, cal) values ('work', '2019-02-02');
insert into fest (timing, cal) values ('work', '2019-02-03');
insert into fest (timing, cal) values ('rest', '2019-02-04');
insert into fest (timing, cal) values ('rest', '2019-02-05');
insert into fest (timing, cal) values ('rest', '2019-02-06');
insert into fest (timing, cal) values ('rest', '2019-02-07');
insert into fest (timing, cal) values ('rest', '2019-02-08');
insert into fest (timing, cal) values ('rest', '2019-02-09');
insert into fest (timing, cal) values ('rest', '2019-02-10');
insert into fest (timing, cal) values ('rest', '2019-04-05');
insert into fest (timing, cal) values ('rest', '2019-04-06');
insert into fest (timing, cal) values ('rest', '2019-04-07');
insert into fest (timing, cal) values ('work', '2019-04-28');
insert into fest (timing, cal) values ('rest', '2019-05-01');
insert into fest (timing, cal) values ('rest', '2019-05-02');
insert into fest (timing, cal) values ('rest', '2019-05-03');
insert into fest (timing, cal) values ('rest', '2019-05-04');
insert into fest (timing, cal) values ('work', '2019-05-05');
insert into fest (timing, cal) values ('rest', '2019-06-07');
insert into fest (timing, cal) values ('rest', '2019-06-08');
insert into fest (timing, cal) values ('rest', '2019-06-09');
insert into fest (timing, cal) values ('rest', '2019-09-13');
insert into fest (timing, cal) values ('rest', '2019-09-14');
insert into fest (timing, cal) values ('rest', '2019-09-15');
insert into fest (timing, cal) values ('work', '2019-09-29');
insert into fest (timing, cal) values ('rest', '2019-10-01');
insert into fest (timing, cal) values ('rest', '2019-10-02');
insert into fest (timing, cal) values ('rest', '2019-10-03');
insert into fest (timing, cal) values ('rest', '2019-10-04');
insert into fest (timing, cal) values ('rest', '2019-10-05');
insert into fest (timing, cal) values ('rest', '2019-10-06');
insert into fest (timing, cal) values ('rest', '2019-10-07');
insert into fest (timing, cal) values ('work', '2019-10-12');
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

-- use blog;

drop table if exists fest;
drop table if exists foreveryear;

create table fest (id int primary key auto_increment, timing varchar(64), cal DATE);

create table foreveryear (id int primary key auto_increment, month int, day int,timing varchar(64),solar boolean);
insert into foreveryear (timing,month,day,solar) values ("sql农历生日",4,24,false);
insert into foreveryear (timing,month,day,solar) values ("sql国历生日",6,25,true);
insert into foreveryear (timing,month,day,solar) values ("sql造物节~",9,15,true);

insert into fest (timing, cal) values ('元旦节休', '2017-12-30');
insert into fest (timing, cal) values ('元旦节休', '2017-12-31');
insert into fest (timing, cal) values ('元旦节', '2018-01-01');
insert into fest (timing, cal) values ('春节班', '2018-02-11');
insert into fest (timing, cal) values ('春节休', '2018-02-15');
insert into fest (timing, cal) values ('春节', '2018-02-16');
insert into fest (timing, cal) values ('春节休', '2018-02-17');
insert into fest (timing, cal) values ('春节休', '2018-02-18');
insert into fest (timing, cal) values ('春节休', '2018-02-19');
insert into fest (timing, cal) values ('春节休', '2018-02-20');
insert into fest (timing, cal) values ('春节休', '2018-02-21');
insert into fest (timing, cal) values ('春节班', '2018-02-24');
insert into fest (timing, cal) values ('清明节', '2018-04-05');
insert into fest (timing, cal) values ('清明节休', '2018-04-06');
insert into fest (timing, cal) values ('清明节休', '2018-04-07');
insert into fest (timing, cal) values ('清明节班', '2018-04-08');
insert into fest (timing, cal) values ('劳动节班', '2018-04-28');
insert into fest (timing, cal) values ('劳动节休', '2018-04-29');
insert into fest (timing, cal) values ('劳动节休', '2018-04-30');
insert into fest (timing, cal) values ('劳动节', '2018-05-01');
insert into fest (timing, cal) values ('端午节休', '2018-06-16');
insert into fest (timing, cal) values ('端午节休', '2018-06-17');
insert into fest (timing, cal) values ('端午节', '2018-06-18');
insert into fest (timing, cal) values ('中秋节休', '2018-09-22');
insert into fest (timing, cal) values ('中秋节休', '2018-09-23');
insert into fest (timing, cal) values ('中秋节', '2018-09-24');
insert into fest (timing, cal) values ('国庆节班', '2018-09-29');
insert into fest (timing, cal) values ('国庆节班', '2018-09-30');
insert into fest (timing, cal) values ('国庆节', '2018-10-01');
insert into fest (timing, cal) values ('国庆节休', '2018-10-02');
insert into fest (timing, cal) values ('国庆节休', '2018-10-03');
insert into fest (timing, cal) values ('国庆节休', '2018-10-04');
insert into fest (timing, cal) values ('国庆节休', '2018-10-05');
insert into fest (timing, cal) values ('国庆节休', '2018-10-06');
insert into fest (timing, cal) values ('国庆节休', '2018-10-07');


insert into fest (timing, cal) values ('元旦节班', '2018-12-29');
insert into fest (timing, cal) values ('元旦节休', '2018-12-30');
insert into fest (timing, cal) values ('元旦节休', '2018-12-31');
insert into fest (timing, cal) values ('元旦节', '2019-01-01');
insert into fest (timing, cal) values ('春节班', '2019-02-02');
insert into fest (timing, cal) values ('春节班', '2019-02-03');
insert into fest (timing, cal) values ('春节休', '2019-02-04');
insert into fest (timing, cal) values ('春节', '2019-02-05');
insert into fest (timing, cal) values ('春节休', '2019-02-06');
insert into fest (timing, cal) values ('春节休', '2019-02-07');
insert into fest (timing, cal) values ('春节休', '2019-02-08');
insert into fest (timing, cal) values ('春节休', '2019-02-09');
insert into fest (timing, cal) values ('春节休', '2019-02-10');
insert into fest (timing, cal) values ('清明节', '2019-04-05');
insert into fest (timing, cal) values ('清明节休', '2019-04-06');
insert into fest (timing, cal) values ('清明节休', '2019-04-07');
insert into fest (timing, cal) values ('劳动节班', '2019-04-28');
insert into fest (timing, cal) values ('劳动节', '2019-05-01');
insert into fest (timing, cal) values ('劳动节休', '2019-05-02');
insert into fest (timing, cal) values ('劳动节休', '2019-05-03');
insert into fest (timing, cal) values ('劳动节休', '2019-05-04');
insert into fest (timing, cal) values ('劳动节班', '2019-05-05');
insert into fest (timing, cal) values ('端午节', '2019-06-07');
insert into fest (timing, cal) values ('端午节休', '2019-06-08');
insert into fest (timing, cal) values ('端午节休', '2019-06-09');
insert into fest (timing, cal) values ('中秋节', '2019-09-13');
insert into fest (timing, cal) values ('中秋节休', '2019-09-14');
insert into fest (timing, cal) values ('中秋节休', '2019-09-15');
insert into fest (timing, cal) values ('国庆节班', '2019-09-29');
insert into fest (timing, cal) values ('国庆节', '2019-10-01');
insert into fest (timing, cal) values ('国庆节休', '2019-10-02');
insert into fest (timing, cal) values ('国庆节休', '2019-10-03');
insert into fest (timing, cal) values ('国庆节休', '2019-10-04');
insert into fest (timing, cal) values ('国庆节休', '2019-10-05');
insert into fest (timing, cal) values ('国庆节休', '2019-10-06');
insert into fest (timing, cal) values ('国庆节休', '2019-10-07');
insert into fest (timing, cal) values ('国庆节班', '2019-10-12');
insert into fest (timing, cal) values ('元旦节', '2020-01-01');
-- liquibase formatted sql

--changeset ramzi:1
alter table jobs add column avgsalary NUMERIC (8, 2);
update jobs set avgsalary = 0.5*(min_salary+max_salary);
--changeset ramzi:2
INSERT INTO public.jobs(job_title, min_salary, max_salary, avgsalary) VALUES ('test liquibase', 100, 150, 200);
--changeset ramzi:3
ALTER TABLE jobs RENAME COLUMN avgSalary TO avg_salary;
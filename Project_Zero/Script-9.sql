create table  User_Account (
-- col_name	 datatype	Constraints
firstname	VARCHAR(40)	not null,
lastname	VARCHAR(40)	not null,
Account_id	Serial		primary key,
username	VARCHAR(40) unique,
password	VARCHAR(40) not null
);

create table User_Bank(
--col_name	datatype	Contraints
service		VARCHAR(20),
Deposit		Decimal,		
Withdraw	Decimal,		
Balance		Decimal,
Accountid 	SERIAL references user_account(account_id), 
AccountNum	SERIAL	primary key
);

--join tables Everything 
select 
user_account.account_id, user_account.username,
user_bank.AccountNum, user_bank.Balance
from user_account
join user_bank
on
user_account.Account_id = User_bank.Accountid;

--Revision for join table showing only balance
select user_bank.Balance from user_account join user_bank on user_account.Account_id = user_bank.Accountid where account_id = 1; 

--Update Example for deposit and withdraw and transfer
update update user_bank set balance = balance + 25 where accountnum = 1;

---Drops Everything have to re-stablish connection issues
drop table user_account cascade;
drop table user_bank cascade;

---Fix my connection issues---
create role jdbc login password 'p4sw0rd';
grant usage, select on all sequences in schema public to jdbc
grant select, update, insert on table user_account to jdbc
grant select, update, insert on table user_bank to jdbc


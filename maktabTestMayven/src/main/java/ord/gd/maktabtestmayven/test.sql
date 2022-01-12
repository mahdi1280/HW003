drop table account;


select a.amount from customer inner join account a on a.id = customer.account_id where customer.national_code = ?

update account set  amount = ?  where id = ?;

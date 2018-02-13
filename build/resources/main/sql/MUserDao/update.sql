update m_user
   set password = :password
      ,mail = :mail
      ,update_date = :updateDate
where user_id = :userId
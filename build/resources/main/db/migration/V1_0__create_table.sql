CREATE TABLE m_user(
  user_id BIGINT NOT NULL
 ,password VARCHAR(64) NOT NULL
 ,name VARCHAR(40) NOT NULL
 ,mail VARCHAR(60) NOT NULL
 ,auth_cd CHAR(2)
 ,org_cd CHAR(2)
 ,manager_id BIGINT
 ,line_id VARCHAR(255)
 ,regist_date DATE DEFAULT now() NOT NULL
 ,regist_user_id BIGINT DEFAULT 0 NOT NULL
 ,regist_func_cd VARCHAR(20) DEFAULT '0' NOT NULL
 ,update_date DATE DEFAULT now() NOT NULL
 ,update_user_id BIGINT DEFAULT 0 NOT NULL
 ,update_func_cd VARCHAR(20) DEFAULT '0' NOT NULL
 ,del_flg CHAR(1) DEFAULT '0' NOT NULL
 ,PRIMARY KEY(user_id)
);

COMMENT ON TABLE m_user IS 'ユーザマスタ';

UPDATE m_user
   SET update_date = :updateDate
    <#if password??>
      ,password = :password
    </#if>
    <#if mail??>
      ,mail = :mail
    </#if>
    <#if authCd??>
      ,auth_cd = :authCd
    </#if>
    <#if managerId??>
      ,manager_id = :managerId
    </#if>
    <#if lineId??>
      ,line_id = :lineId
    </#if>
      ,update_date = CURRENT_TIMESTAMP
      ,update_user_id = :updateUserId
      ,update_func_cd = :updateFuncCd
 WHERE user_id = :userId
   AND update_date = :updateDate
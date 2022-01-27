# spring-security-jwt

What is JWT.
Spring Security and JWT filters.
Few APIs

To Generate a new Token, execute the below API:

POST: http://localhost:8082/api/login
x-www-form-encoded --> check
Headers : Content-Type , application/json
Body: Username = eabiatallah / Password = 1234

To validate this token, call an API:

http://localhost:8082/api/users
Headers :Authorization / Bearer tokenvalue

Add a user:

http://localhost:8082/api/user/save
Headers :Authorization / Bearer tokenvalue

{
    "name" : "Smriti",
    "username" : "sm",
    "password" : "1234",
    "roles" : [
        
    ]
}

Add Role To User

http://localhost:8082/api/role/addToUser
Headers :Authorization / Bearer tokenvalue
{
    "username" : "sm",
    "roleName" : "ROLE_USER"
}

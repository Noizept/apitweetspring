## Anime news Tweet API

Spring boot rest api
Crawler to get tweets

Needs to be worked better exception messages.

Added JWT Auth with Spring security since i was curious about it, might be messy for now.

Needs to be reviewed the JWT auth.


at /register

{
	"userName":"test1@example.com","password":"password"
}

at /login

{
	"userName":"test1@example.com","password":"password"
}

You will get a JWT for using on the other requests
<b> where X=Integer </b>
 
- /tweets
- /tweets?limit=X
- /tweets/X
- /tweets/latest
- /tweets/latest?limit=X


`docker build -t noizept/restapi-gamesys .`    

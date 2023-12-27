# CompassUOL-SP-Challenge-03-Squad-2-Jose-Roberto

{
	"log": {
		"version": "1.2",
		"creator": {
			"name": "Insomnia REST Client",
			"version": "insomnia.desktop.app:v2023.5.8"
		},
		"entries": [
			{
				"startedDateTime": "2023-12-27T15:05:15.181Z",
				"time": 891.5659999999999,
				"request": {
					"method": "POST",
					"url": "http://localhost:8080/oauth/token",
					"httpVersion": "HTTP/1.1",
					"cookies": [],
					"headers": [
						{
							"name": "Content-Type",
							"value": "application/json"
						},
						{
							"name": "User-Agent",
							"value": "insomnia/2023.5.8"
						}
					],
					"queryString": [],
					"postData": {
						"mimeType": "application/json",
						"text": "{\n\t\"email\" : \"admin@ifpb.com\",\n\t\"password\" : \"123\"\n}",
						"params": []
					},
					"headersSize": -1,
					"bodySize": -1,
					"settingEncodeUrl": true
				},
				"response": {
					"status": 200,
					"statusText": "OK",
					"httpVersion": "HTTP/1.1",
					"cookies": [],
					"headers": [
						{
							"name": "transfer-encoding",
							"value": "chunked"
						},
						{
							"name": "Vary",
							"value": "Origin"
						},
						{
							"name": "Vary",
							"value": "Access-Control-Request-Method"
						},
						{
							"name": "Vary",
							"value": "Access-Control-Request-Headers"
						},
						{
							"name": "X-Content-Type-Options",
							"value": "nosniff"
						},
						{
							"name": "X-XSS-Protection",
							"value": "0"
						},
						{
							"name": "Cache-Control",
							"value": "no-cache, no-store, max-age=0, must-revalidate"
						},
						{
							"name": "Pragma",
							"value": "no-cache"
						},
						{
							"name": "Expires",
							"value": "0"
						},
						{
							"name": "X-Frame-Options",
							"value": "DENY"
						},
						{
							"name": "Content-Type",
							"value": "application/json"
						},
						{
							"name": "Date",
							"value": "Wed, 27 Dec 2023 14:31:54 GMT"
						}
					],
					"content": {
						"size": 177,
						"mimeType": "application/json",
						"text": "{\"token\":\"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJBdXRob3JpemF0aW9uIiwic3ViIjoiYWRtaW5AaWZwYi5jb20iLCJleHAiOjE3MDM2OTQ3MTR9.KNrAvPOskJQdLc7vPldorF--U3YB5ASv_E8HMSUNrkc\"}"
					},
					"redirectURL": "",
					"headersSize": -1,
					"bodySize": -1
				},
				"cache": {},
				"timings": {
					"blocked": -1,
					"dns": -1,
					"connect": -1,
					"send": 0,
					"wait": 891.5659999999999,
					"receive": 0,
					"ssl": -1
				},
				"comment": "Login ADMIN"
			},
			{
				"startedDateTime": "2023-12-27T15:05:15.181Z",
				"time": 2163.557,
				"request": {
					"method": "POST",
					"url": "http://localhost:8080/users",
					"httpVersion": "HTTP/1.1",
					"cookies": [],
					"headers": [
						{
							"name": "Content-Type",
							"value": "application/json"
						},
						{
							"name": "User-Agent",
							"value": "insomnia/2023.5.8"
						},
						{
							"name": "Authorization",
							"value": "Bearer "
						}
					],
					"queryString": [],
					"postData": {
						"mimeType": "application/json",
						"text": "{\n\t\"firstName\": \"José Roberto\",\n\t\"lastName\": \"Júnior\",\n\t\"email\" : \"roberto.farias.oliveira2@gmail.com\",\n\t\"password\" : \"123\"\n}\n",
						"params": []
					},
					"headersSize": -1,
					"bodySize": -1,
					"settingEncodeUrl": true
				},
				"response": {
					"status": 201,
					"statusText": "Created",
					"httpVersion": "HTTP/1.1",
					"cookies": [],
					"headers": [
						{
							"name": "transfer-encoding",
							"value": "chunked"
						},
						{
							"name": "Vary",
							"value": "Origin"
						},
						{
							"name": "Vary",
							"value": "Access-Control-Request-Method"
						},
						{
							"name": "Vary",
							"value": "Access-Control-Request-Headers"
						},
						{
							"name": "X-Content-Type-Options",
							"value": "nosniff"
						},
						{
							"name": "X-XSS-Protection",
							"value": "0"
						},
						{
							"name": "Cache-Control",
							"value": "no-cache, no-store, max-age=0, must-revalidate"
						},
						{
							"name": "Pragma",
							"value": "no-cache"
						},
						{
							"name": "Expires",
							"value": "0"
						},
						{
							"name": "X-Frame-Options",
							"value": "DENY"
						},
						{
							"name": "Content-Type",
							"value": "application/json"
						},
						{
							"name": "Date",
							"value": "Wed, 27 Dec 2023 14:53:05 GMT"
						}
					],
					"content": {
						"size": 201,
						"mimeType": "application/json",
						"text": "{\"id\":2,\"firstName\":\"José Roberto\",\"lastName\":\"Júnior\",\"email\":\"roberto.farias.oliveira2@gmail.com\",\"password\":\"$2a$10$8geQKL1o9hk1wI9zQ.xiDOua1gIJ2qgHnMS11JHtWzL5UDbNTtE06\",\"userRole\":[],\"roles\":[]}"
					},
					"redirectURL": "",
					"headersSize": -1,
					"bodySize": -1
				},
				"cache": {},
				"timings": {
					"blocked": -1,
					"dns": -1,
					"connect": -1,
					"send": 0,
					"wait": 2163.557,
					"receive": 0,
					"ssl": -1
				},
				"comment": "Create User"
			},
			{
				"startedDateTime": "2023-12-27T15:05:15.181Z",
				"time": 95.546,
				"request": {
					"method": "POST",
					"url": "http://localhost:8080/oauth/token",
					"httpVersion": "HTTP/1.1",
					"cookies": [],
					"headers": [
						{
							"name": "Content-Type",
							"value": "application/json"
						},
						{
							"name": "User-Agent",
							"value": "insomnia/2023.5.8"
						}
					],
					"queryString": [],
					"postData": {
						"mimeType": "application/json",
						"text": "{\n\t\"email\" : \"roberto.farias.oliveira2@gmail.com\",\n\t\"password\" : \"123\"\n}",
						"params": []
					},
					"headersSize": -1,
					"bodySize": -1,
					"settingEncodeUrl": true
				},
				"response": {
					"status": 200,
					"statusText": "OK",
					"httpVersion": "HTTP/1.1",
					"cookies": [],
					"headers": [
						{
							"name": "transfer-encoding",
							"value": "chunked"
						},
						{
							"name": "Vary",
							"value": "Origin"
						},
						{
							"name": "Vary",
							"value": "Access-Control-Request-Method"
						},
						{
							"name": "Vary",
							"value": "Access-Control-Request-Headers"
						},
						{
							"name": "X-Content-Type-Options",
							"value": "nosniff"
						},
						{
							"name": "X-XSS-Protection",
							"value": "0"
						},
						{
							"name": "Cache-Control",
							"value": "no-cache, no-store, max-age=0, must-revalidate"
						},
						{
							"name": "Pragma",
							"value": "no-cache"
						},
						{
							"name": "Expires",
							"value": "0"
						},
						{
							"name": "X-Frame-Options",
							"value": "DENY"
						},
						{
							"name": "Content-Type",
							"value": "application/json"
						},
						{
							"name": "Date",
							"value": "Wed, 27 Dec 2023 14:53:09 GMT"
						}
					],
					"content": {
						"size": 204,
						"mimeType": "application/json",
						"text": "{\"token\":\"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJBdXRob3JpemF0aW9uIiwic3ViIjoicm9iZXJ0by5mYXJpYXMub2xpdmVpcmEyQGdtYWlsLmNvbSIsImV4cCI6MTcwMzY5NTk4OX0.XOuX7gHl44LlWfd-NrN7IKGAMuCaSMoBCfbxsIaFMKI\"}"
					},
					"redirectURL": "",
					"headersSize": -1,
					"bodySize": -1
				},
				"cache": {},
				"timings": {
					"blocked": -1,
					"dns": -1,
					"connect": -1,
					"send": 0,
					"wait": 95.546,
					"receive": 0,
					"ssl": -1
				},
				"comment": "Login OPERATOR"
			},
			{
				"startedDateTime": "2023-12-27T15:05:15.181Z",
				"time": 16.991,
				"request": {
					"method": "PUT",
					"url": "http://localhost:8080/users/5",
					"httpVersion": "HTTP/1.1",
					"cookies": [],
					"headers": [
						{
							"name": "Content-Type",
							"value": "application/json"
						},
						{
							"name": "User-Agent",
							"value": "insomnia/2023.5.8"
						},
						{
							"name": "Authorization",
							"value": "Bearer "
						}
					],
					"queryString": [],
					"postData": {
						"mimeType": "application/json",
						"text": "{\n\t\"firstName\": \"José Roberto Farias\",\n\t\"lastName\": \"Júnior\",\n\t\"email\" : \"roberto.farias.oliveira2@gmail.com\",\n\t\"password\" : \"123\"\n}",
						"params": []
					},
					"headersSize": -1,
					"bodySize": -1,
					"settingEncodeUrl": true
				},
				"response": {
					"status": 403,
					"statusText": "Forbidden",
					"httpVersion": "HTTP/1.1",
					"cookies": [],
					"headers": [
						{
							"name": "Vary",
							"value": "Origin"
						},
						{
							"name": "Vary",
							"value": "Access-Control-Request-Method"
						},
						{
							"name": "Vary",
							"value": "Access-Control-Request-Headers"
						},
						{
							"name": "X-Content-Type-Options",
							"value": "nosniff"
						},
						{
							"name": "X-XSS-Protection",
							"value": "0"
						},
						{
							"name": "Cache-Control",
							"value": "no-cache, no-store, max-age=0, must-revalidate"
						},
						{
							"name": "Pragma",
							"value": "no-cache"
						},
						{
							"name": "Expires",
							"value": "0"
						},
						{
							"name": "X-Frame-Options",
							"value": "DENY"
						},
						{
							"name": "Content-Length",
							"value": "0"
						},
						{
							"name": "Date",
							"value": "Wed, 27 Dec 2023 13:45:23 GMT"
						}
					],
					"content": {
						"size": 0,
						"mimeType": "",
						"text": ""
					},
					"redirectURL": "",
					"headersSize": -1,
					"bodySize": -1
				},
				"cache": {},
				"timings": {
					"blocked": -1,
					"dns": -1,
					"connect": -1,
					"send": 0,
					"wait": 16.991,
					"receive": 0,
					"ssl": -1
				},
				"comment": "Update User id OPERATOR"
			},
			{
				"startedDateTime": "2023-12-27T15:05:15.181Z",
				"time": 0,
				"request": {
					"method": "PUT",
					"url": "http://localhost:8080/users/5",
					"httpVersion": "HTTP/1.1",
					"cookies": [],
					"headers": [
						{
							"name": "Content-Type",
							"value": "application/json"
						},
						{
							"name": "User-Agent",
							"value": "insomnia/2023.5.8"
						},
						{
							"name": "Authorization",
							"value": "Bearer "
						}
					],
					"queryString": [],
					"postData": {
						"mimeType": "application/json",
						"text": "{\n\t\"firstName\": \"José Roberto Farias\",\n\t\"lastName\": \"Júnior\",\n\t\"email\" : \"roberto.farias.oliveira2@gmail.com\",\n\t\"password\" : \"123\"\n}",
						"params": []
					},
					"headersSize": -1,
					"bodySize": -1,
					"settingEncodeUrl": true
				},
				"response": {
					"status": 0,
					"statusText": "",
					"httpVersion": "HTTP/1.1",
					"cookies": [],
					"headers": [],
					"content": {
						"size": 0,
						"mimeType": ""
					},
					"redirectURL": "",
					"headersSize": -1,
					"bodySize": -1
				},
				"cache": {},
				"timings": {
					"blocked": -1,
					"dns": -1,
					"connect": -1,
					"send": 0,
					"wait": 0,
					"receive": 0,
					"ssl": -1
				},
				"comment": "Update User id ADMIN"
			},
			{
				"startedDateTime": "2023-12-27T15:05:15.181Z",
				"time": 0,
				"request": {
					"method": "GET",
					"url": "http://localhost:8080/users/1",
					"httpVersion": "HTTP/1.1",
					"cookies": [],
					"headers": [
						{
							"name": "User-Agent",
							"value": "insomnia/2023.5.8"
						},
						{
							"name": "Authorization",
							"value": "Bearer undefined"
						}
					],
					"queryString": [],
					"postData": {
						"mimeType": "",
						"text": "",
						"params": []
					},
					"headersSize": -1,
					"bodySize": -1,
					"settingEncodeUrl": true
				},
				"response": {
					"status": 0,
					"statusText": "",
					"httpVersion": "HTTP/1.1",
					"cookies": [],
					"headers": [],
					"content": {
						"size": 0,
						"mimeType": ""
					},
					"redirectURL": "",
					"headersSize": -1,
					"bodySize": -1
				},
				"cache": {},
				"timings": {
					"blocked": -1,
					"dns": -1,
					"connect": -1,
					"send": 0,
					"wait": 0,
					"receive": 0,
					"ssl": -1
				},
				"comment": "Get User id OPERATOR"
			},
			{
				"startedDateTime": "2023-12-27T15:05:15.181Z",
				"time": 14.148000000000001,
				"request": {
					"method": "GET",
					"url": "http://localhost:8080/users/5",
					"httpVersion": "HTTP/1.1",
					"cookies": [],
					"headers": [
						{
							"name": "User-Agent",
							"value": "insomnia/2023.5.8"
						},
						{
							"name": "Authorization",
							"value": "Bearer "
						}
					],
					"queryString": [],
					"postData": {
						"mimeType": "",
						"text": "",
						"params": []
					},
					"headersSize": -1,
					"bodySize": -1,
					"settingEncodeUrl": true
				},
				"response": {
					"status": 200,
					"statusText": "OK",
					"httpVersion": "HTTP/1.1",
					"cookies": [],
					"headers": [
						{
							"name": "transfer-encoding",
							"value": "chunked"
						},
						{
							"name": "Vary",
							"value": "Origin"
						},
						{
							"name": "Vary",
							"value": "Access-Control-Request-Method"
						},
						{
							"name": "Vary",
							"value": "Access-Control-Request-Headers"
						},
						{
							"name": "X-Content-Type-Options",
							"value": "nosniff"
						},
						{
							"name": "X-XSS-Protection",
							"value": "0"
						},
						{
							"name": "Cache-Control",
							"value": "no-cache, no-store, max-age=0, must-revalidate"
						},
						{
							"name": "Pragma",
							"value": "no-cache"
						},
						{
							"name": "Expires",
							"value": "0"
						},
						{
							"name": "X-Frame-Options",
							"value": "DENY"
						},
						{
							"name": "Content-Type",
							"value": "application/json"
						},
						{
							"name": "Date",
							"value": "Wed, 27 Dec 2023 13:46:26 GMT"
						}
					],
					"content": {
						"size": 208,
						"mimeType": "application/json",
						"text": "{\"id\":5,\"firstName\":\"José Roberto Farias\",\"lastName\":\"Júnior\",\"email\":\"roberto.farias.oliveira2@gmail.com\",\"password\":\"$2a$10$fNSQApvikkpQXuZ2NkT4W.v89BNVlOUgR0UGBFKZLrydfVDevuSxC\",\"userRole\":[],\"roles\":[]}"
					},
					"redirectURL": "",
					"headersSize": -1,
					"bodySize": -1
				},
				"cache": {},
				"timings": {
					"blocked": -1,
					"dns": -1,
					"connect": -1,
					"send": 0,
					"wait": 14.148000000000001,
					"receive": 0,
					"ssl": -1
				},
				"comment": "Get User id ADMIN"
			},
			{
				"startedDateTime": "2023-12-27T15:05:15.181Z",
				"time": 11.321,
				"request": {
					"method": "GET",
					"url": "http://localhost:8080/products/?page=1&linesPerPage=5&direction=DESC&orderBy=name",
					"httpVersion": "HTTP/1.1",
					"cookies": [],
					"headers": [
						{
							"name": "User-Agent",
							"value": "insomnia/2023.5.8"
						},
						{
							"name": "Authorization",
							"value": "Bearer "
						}
					],
					"queryString": [],
					"postData": {
						"mimeType": "",
						"text": "",
						"params": []
					},
					"headersSize": -1,
					"bodySize": -1,
					"settingEncodeUrl": true
				},
				"response": {
					"status": 403,
					"statusText": "Forbidden",
					"httpVersion": "HTTP/1.1",
					"cookies": [],
					"headers": [
						{
							"name": "Vary",
							"value": "Origin"
						},
						{
							"name": "Vary",
							"value": "Access-Control-Request-Method"
						},
						{
							"name": "Vary",
							"value": "Access-Control-Request-Headers"
						},
						{
							"name": "X-Content-Type-Options",
							"value": "nosniff"
						},
						{
							"name": "X-XSS-Protection",
							"value": "0"
						},
						{
							"name": "Cache-Control",
							"value": "no-cache, no-store, max-age=0, must-revalidate"
						},
						{
							"name": "Pragma",
							"value": "no-cache"
						},
						{
							"name": "Expires",
							"value": "0"
						},
						{
							"name": "X-Frame-Options",
							"value": "DENY"
						},
						{
							"name": "Content-Length",
							"value": "0"
						},
						{
							"name": "Date",
							"value": "Wed, 27 Dec 2023 14:14:26 GMT"
						}
					],
					"content": {
						"size": 0,
						"mimeType": "",
						"text": ""
					},
					"redirectURL": "",
					"headersSize": -1,
					"bodySize": -1
				},
				"cache": {},
				"timings": {
					"blocked": -1,
					"dns": -1,
					"connect": -1,
					"send": 0,
					"wait": 11.321,
					"receive": 0,
					"ssl": -1
				},
				"comment": "Get Products filter"
			},
			{
				"startedDateTime": "2023-12-27T15:05:15.181Z",
				"time": 92.766,
				"request": {
					"method": "GET",
					"url": "http://localhost:8080/products/1",
					"httpVersion": "HTTP/1.1",
					"cookies": [],
					"headers": [
						{
							"name": "User-Agent",
							"value": "insomnia/2023.5.8"
						},
						{
							"name": "Authorization",
							"value": "Bearer "
						}
					],
					"queryString": [],
					"postData": {
						"mimeType": "",
						"text": "",
						"params": []
					},
					"headersSize": -1,
					"bodySize": -1,
					"settingEncodeUrl": true
				},
				"response": {
					"status": 200,
					"statusText": "OK",
					"httpVersion": "HTTP/1.1",
					"cookies": [],
					"headers": [
						{
							"name": "transfer-encoding",
							"value": "chunked"
						},
						{
							"name": "Vary",
							"value": "Origin"
						},
						{
							"name": "Vary",
							"value": "Access-Control-Request-Method"
						},
						{
							"name": "Vary",
							"value": "Access-Control-Request-Headers"
						},
						{
							"name": "X-Content-Type-Options",
							"value": "nosniff"
						},
						{
							"name": "X-XSS-Protection",
							"value": "0"
						},
						{
							"name": "Cache-Control",
							"value": "no-cache, no-store, max-age=0, must-revalidate"
						},
						{
							"name": "Pragma",
							"value": "no-cache"
						},
						{
							"name": "Expires",
							"value": "0"
						},
						{
							"name": "X-Frame-Options",
							"value": "DENY"
						},
						{
							"name": "Content-Type",
							"value": "application/json"
						},
						{
							"name": "Date",
							"value": "Wed, 27 Dec 2023 14:37:57 GMT"
						}
					],
					"content": {
						"size": 171,
						"mimeType": "application/json",
						"text": "{\"id\":1,\"name\":\"Macarrão\",\"price\":2.60,\"description\":\"Macarrão integral\",\"category\":[],\"date\":\"2023-12-27T11:31:24.570139\",\"imgUrl\":\"https://github.com/robertojunior28\"}"
					},
					"redirectURL": "",
					"headersSize": -1,
					"bodySize": -1
				},
				"cache": {},
				"timings": {
					"blocked": -1,
					"dns": -1,
					"connect": -1,
					"send": 0,
					"wait": 92.766,
					"receive": 0,
					"ssl": -1
				},
				"comment": "Get Products id"
			},
			{
				"startedDateTime": "2023-12-27T15:05:15.181Z",
				"time": 694.333,
				"request": {
					"method": "POST",
					"url": "http://localhost:8080/products",
					"httpVersion": "HTTP/1.1",
					"cookies": [],
					"headers": [
						{
							"name": "Content-Type",
							"value": "application/json"
						},
						{
							"name": "User-Agent",
							"value": "insomnia/2023.5.8"
						},
						{
							"name": "Authorization",
							"value": "Bearer "
						}
					],
					"queryString": [],
					"postData": {
						"mimeType": "application/json",
						"text": "{\n  \"name\": \"Sabão\",\n  \"price\": 9.59,\n  \"description\": \"Sabão em barra.\",\n  \"category\": [\n    {\n      \"id\": 1\n    }\n  ],\n\t\"date\": \"2023-12-27T15:30:00\",\n  \"imgUrl\": \"https://example.com/sample-product-image.jpg\"\n}\n",
						"params": []
					},
					"headersSize": -1,
					"bodySize": -1,
					"settingEncodeUrl": true
				},
				"response": {
					"status": 201,
					"statusText": "Created",
					"httpVersion": "HTTP/1.1",
					"cookies": [],
					"headers": [
						{
							"name": "transfer-encoding",
							"value": "chunked"
						},
						{
							"name": "Vary",
							"value": "Origin"
						},
						{
							"name": "Vary",
							"value": "Access-Control-Request-Method"
						},
						{
							"name": "Vary",
							"value": "Access-Control-Request-Headers"
						},
						{
							"name": "X-Content-Type-Options",
							"value": "nosniff"
						},
						{
							"name": "X-XSS-Protection",
							"value": "0"
						},
						{
							"name": "Cache-Control",
							"value": "no-cache, no-store, max-age=0, must-revalidate"
						},
						{
							"name": "Pragma",
							"value": "no-cache"
						},
						{
							"name": "Expires",
							"value": "0"
						},
						{
							"name": "X-Frame-Options",
							"value": "DENY"
						},
						{
							"name": "Content-Type",
							"value": "application/json"
						},
						{
							"name": "Date",
							"value": "Wed, 27 Dec 2023 14:51:41 GMT"
						}
					],
					"content": {
						"size": 202,
						"mimeType": "application/json",
						"text": "{\"id\":16,\"name\":\"Sabão\",\"price\":9.59,\"description\":\"Sabão em barra.\",\"category\":[{\"id\":1,\"name\":\"Limpeza\"}],\"date\":\"2023-12-27T11:51:41.892234\",\"imgUrl\":\"https://example.com/sample-product-image.jpg\"}"
					},
					"redirectURL": "",
					"headersSize": -1,
					"bodySize": -1
				},
				"cache": {},
				"timings": {
					"blocked": -1,
					"dns": -1,
					"connect": -1,
					"send": 0,
					"wait": 694.333,
					"receive": 0,
					"ssl": -1
				},
				"comment": "Create Product"
			},
			{
				"startedDateTime": "2023-12-27T15:05:15.181Z",
				"time": 34.07,
				"request": {
					"method": "PUT",
					"url": "http://localhost:8080/products/16",
					"httpVersion": "HTTP/1.1",
					"cookies": [],
					"headers": [
						{
							"name": "Content-Type",
							"value": "application/json"
						},
						{
							"name": "User-Agent",
							"value": "insomnia/2023.5.8"
						},
						{
							"name": "Authorization",
							"value": "Bearer "
						}
					],
					"queryString": [],
					"postData": {
						"mimeType": "application/json",
						"text": "{\n  \"name\": \"Sabão\",\n  \"price\": 10.59,\n  \"description\": \"Sabão em barra.\",\n  \"category\": [\n    {\n      \"id\": 1\n    }\n  ],\n\t\"date\": \"2023-12-27T15:30:00\",\n  \"imgUrl\": \"https://example.com/sample-product-image.jpg\"\n}\n",
						"params": []
					},
					"headersSize": -1,
					"bodySize": -1,
					"settingEncodeUrl": true
				},
				"response": {
					"status": 200,
					"statusText": "OK",
					"httpVersion": "HTTP/1.1",
					"cookies": [],
					"headers": [
						{
							"name": "transfer-encoding",
							"value": "chunked"
						},
						{
							"name": "Vary",
							"value": "Origin"
						},
						{
							"name": "Vary",
							"value": "Access-Control-Request-Method"
						},
						{
							"name": "Vary",
							"value": "Access-Control-Request-Headers"
						},
						{
							"name": "X-Content-Type-Options",
							"value": "nosniff"
						},
						{
							"name": "X-XSS-Protection",
							"value": "0"
						},
						{
							"name": "Cache-Control",
							"value": "no-cache, no-store, max-age=0, must-revalidate"
						},
						{
							"name": "Pragma",
							"value": "no-cache"
						},
						{
							"name": "Expires",
							"value": "0"
						},
						{
							"name": "X-Frame-Options",
							"value": "DENY"
						},
						{
							"name": "Content-Type",
							"value": "application/json"
						},
						{
							"name": "Date",
							"value": "Wed, 27 Dec 2023 14:52:31 GMT"
						}
					],
					"content": {
						"size": 206,
						"mimeType": "application/json",
						"text": "{\"id\":16,\"name\":\"Sabão\",\"price\":10.59,\"description\":\"Sabão em barra.\",\"category\":[{\"id\":1,\"name\":\"Limpeza\"}],\"date\":\"2023-12-27T11:52:31.792888200\",\"imgUrl\":\"https://example.com/sample-product-image.jpg\"}"
					},
					"redirectURL": "",
					"headersSize": -1,
					"bodySize": -1
				},
				"cache": {},
				"timings": {
					"blocked": -1,
					"dns": -1,
					"connect": -1,
					"send": 0,
					"wait": 34.07,
					"receive": 0,
					"ssl": -1
				},
				"comment": "Update Product"
			},
			{
				"startedDateTime": "2023-12-27T15:05:15.181Z",
				"time": 27.671,
				"request": {
					"method": "DELETE",
					"url": "http://localhost:8080/products/16",
					"httpVersion": "HTTP/1.1",
					"cookies": [],
					"headers": [
						{
							"name": "User-Agent",
							"value": "insomnia/2023.5.8"
						},
						{
							"name": "Authorization",
							"value": "Bearer "
						}
					],
					"queryString": [],
					"postData": {
						"mimeType": "",
						"text": "",
						"params": []
					},
					"headersSize": -1,
					"bodySize": -1,
					"settingEncodeUrl": true
				},
				"response": {
					"status": 200,
					"statusText": "OK",
					"httpVersion": "HTTP/1.1",
					"cookies": [],
					"headers": [
						{
							"name": "Vary",
							"value": "Origin"
						},
						{
							"name": "Vary",
							"value": "Access-Control-Request-Method"
						},
						{
							"name": "Vary",
							"value": "Access-Control-Request-Headers"
						},
						{
							"name": "X-Content-Type-Options",
							"value": "nosniff"
						},
						{
							"name": "X-XSS-Protection",
							"value": "0"
						},
						{
							"name": "Cache-Control",
							"value": "no-cache, no-store, max-age=0, must-revalidate"
						},
						{
							"name": "Pragma",
							"value": "no-cache"
						},
						{
							"name": "Expires",
							"value": "0"
						},
						{
							"name": "X-Frame-Options",
							"value": "DENY"
						},
						{
							"name": "Content-Type",
							"value": "text/plain;charset=UTF-8"
						},
						{
							"name": "Content-Length",
							"value": "36"
						},
						{
							"name": "Date",
							"value": "Wed, 27 Dec 2023 14:53:21 GMT"
						}
					],
					"content": {
						"size": 36,
						"mimeType": "text/plain;charset=UTF-8",
						"text": "Product entity deleted successfully."
					},
					"redirectURL": "",
					"headersSize": -1,
					"bodySize": -1
				},
				"cache": {},
				"timings": {
					"blocked": -1,
					"dns": -1,
					"connect": -1,
					"send": 0,
					"wait": 27.671,
					"receive": 0,
					"ssl": -1
				},
				"comment": "Delete Product"
			}
		]
	}
}

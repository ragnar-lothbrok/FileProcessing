pubmatic@L564:~/pubmatic/HomeWork/FileProcessing$ mongo
MongoDB shell version: 2.6.7
connecting to: test
> 
> use users;
switched to db users
> db.links.insert({
... name : {
... first : "Johny",
... last : "English"
... },
... age : 45,
... email : 'johnyenglish@gmail.com',
... password : 'IWlove345'
... });
WriteResult({ "nInserted" : 1 })
> 
> db.links.insert({
... name : {
... first : "Aryan",
... last : "Malhotra"
... },
... age : 25,
... email : 'ryanmal@gmail.com',
... password : 'BTS213'
... });
WriteResult({ "nInserted" : 1 })
> 
> 
> 
> 
> db.links.find();
{ "_id" : ObjectId("552560be281b35c268129650"), "name" : { "first" : "Johny", "last" : "English" }, "age" : 45, "email" : "johnyenglish@gmail.com", "password" : "IWlove345" }
{ "_id" : ObjectId("552560bf281b35c268129651"), "name" : { "first" : "Aryan", "last" : "Malhotra" }, "age" : 25, "email" : "ryanmal@gmail.com", "password" : "BTS213" }
> db.links.insert({ name : { first : "Rocky", last : "Rancho" }, age : 50, email : 'rajarocky@gmail.com', password : 'abcde' });
WriteResult({ "nInserted" : 1 })
> 
> 
> db.links.find();
{ "_id" : ObjectId("552560be281b35c268129650"), "name" : { "first" : "Johny", "last" : "English" }, "age" : 45, "email" : "johnyenglish@gmail.com", "password" : "IWlove345" }
{ "_id" : ObjectId("552560bf281b35c268129651"), "name" : { "first" : "Aryan", "last" : "Malhotra" }, "age" : 25, "email" : "ryanmal@gmail.com", "password" : "BTS213" }
{ "_id" : ObjectId("5525621c281b35c268129652"), "name" : { "first" : "Rocky", "last" : "Rancho" }, "age" : 50, "email" : "rajarocky@gmail.com", "password" : "abcde" }
> db.links.find().forEach(printjson);
{
	"_id" : ObjectId("552560be281b35c268129650"),
	"name" : {
		"first" : "Johny",
		"last" : "English"
	},
	"age" : 45,
	"email" : "johnyenglish@gmail.com",
	"password" : "IWlove345"
}
{
	"_id" : ObjectId("552560bf281b35c268129651"),
	"name" : {
		"first" : "Aryan",
		"last" : "Malhotra"
	},
	"age" : 25,
	"email" : "ryanmal@gmail.com",
	"password" : "BTS213"
}
{
	"_id" : ObjectId("5525621c281b35c268129652"),
	"name" : {
		"first" : "Rocky",
		"last" : "Rancho"
	},
	"age" : 50,
	"email" : "rajarocky@gmail.com",
	"password" : "abcde"
}
> db.links.find().forEach(printjson);
{
	"_id" : ObjectId("552560be281b35c268129650"),
	"name" : {
		"first" : "Johny",
		"last" : "English"
	},
	"age" : 45,
	"email" : "johnyenglish@gmail.com",
	"password" : "IWlove345"
}
{
	"_id" : ObjectId("552560bf281b35c268129651"),
	"name" : {
		"first" : "Aryan",
		"last" : "Malhotra"
	},
	"age" : 25,
	"email" : "ryanmal@gmail.com",
	"password" : "BTS213"
}
{
	"_id" : ObjectId("5525621c281b35c268129652"),
	"name" : {
		"first" : "Rocky",
		"last" : "Rancho"
	},
	"age" : 50,
	"email" : "rajarocky@gmail.com",
	"password" : "abcde"
}
> 
> 
> 
> 
> 







































> show dbs;
PubMatic  0.078GB
admin     (empty)
local     0.078GB
test      (empty)
users     0.078GB
> use users;
switched to db users
> db.links.insert({ name : { first : "Jacky", last : "Emerson" }, age : 32, email : 'jacky123@gmail.com', password : 'iloveyou' });
WriteResult({ "nInserted" : 1 })
> db.links.find();
{ "_id" : ObjectId("552560be281b35c268129650"), "name" : { "first" : "Johny", "last" : "English" }, "age" : 45, "email" : "johnyenglish@gmail.com", "password" : "IWlove345" }
{ "_id" : ObjectId("552560bf281b35c268129651"), "name" : { "first" : "Aryan", "last" : "Malhotra" }, "age" : 25, "email" : "ryanmal@gmail.com", "password" : "BTS213" }
{ "_id" : ObjectId("5525621c281b35c268129652"), "name" : { "first" : "Rocky", "last" : "Rancho" }, "age" : 50, "email" : "rajarocky@gmail.com", "password" : "abcde" }
{ "_id" : ObjectId("55256285281b35c268129653"), "name" : { "first" : "Jacky", "last" : "Emerson" }, "age" : 32, "email" : "jacky123@gmail.com", "password" : "iloveyou" }
> db.links.find().forEach(printjson);
{
	"_id" : ObjectId("552560be281b35c268129650"),
	"name" : {
		"first" : "Johny",
		"last" : "English"
	},
	"age" : 45,
	"email" : "johnyenglish@gmail.com",
	"password" : "IWlove345"
}
{
	"_id" : ObjectId("552560bf281b35c268129651"),
	"name" : {
		"first" : "Aryan",
		"last" : "Malhotra"
	},
	"age" : 25,
	"email" : "ryanmal@gmail.com",
	"password" : "BTS213"
}
{
	"_id" : ObjectId("5525621c281b35c268129652"),
	"name" : {
		"first" : "Rocky",
		"last" : "Rancho"
	},
	"age" : 50,
	"email" : "rajarocky@gmail.com",
	"password" : "abcde"
}
{
	"_id" : ObjectId("55256285281b35c268129653"),
	"name" : {
		"first" : "Jacky",
		"last" : "Emerson"
	},
	"age" : 32,
	"email" : "jacky123@gmail.com",
	"password" : "iloveyou"
}
> db.links.findOne();
{
	"_id" : ObjectId("552560be281b35c268129650"),
	"name" : {
		"first" : "Johny",
		"last" : "English"
	},
	"age" : 45,
	"email" : "johnyenglish@gmail.com",
	"password" : "IWlove345"
}
> db.links.findOne({email:'johnyenglish@gmail.com'})._id;
ObjectId("552560be281b35c268129650")
> db.links.findOne({email:'johnyenglish@gmail.com'});
{
	"_id" : ObjectId("552560be281b35c268129650"),
	"name" : {
		"first" : "Johny",
		"last" : "English"
	},
	"age" : 45,
	"email" : "johnyenglish@gmail.com",
	"password" : "IWlove345"
}
> db.links.find({"age" : 45});
{ "_id" : ObjectId("552560be281b35c268129650"), "name" : { "first" : "Johny", "last" : "English" }, "age" : 45, "email" : "johnyenglish@gmail.com", "password" : "IWlove345" }
> db.links.find({"age" : 45},{email:0});
{ "_id" : ObjectId("552560be281b35c268129650"), "name" : { "first" : "Johny", "last" : "English" }, "age" : 45, "password" : "IWlove345" }
> db.links.find({"age" : 45},{email:1});
{ "_id" : ObjectId("552560be281b35c268129650"), "email" : "johnyenglish@gmail.com" }
> db.links.find({"age" : 45},{email:1,_id:0});
{ "email" : "johnyenglish@gmail.com" }
> 
> db.links.find({ "name.first" : 'Johny'});
{ "_id" : ObjectId("552560be281b35c268129650"), "name" : { "first" : "Johny", "last" : "English" }, "age" : 45, "email" : "johnyenglish@gmail.com", "password" : "IWlove345" }
> 
> db.links.find({ "name.first" : 'Johny'},{'name.last':1}).forEach(printjson);
{
	"_id" : ObjectId("552560be281b35c268129650"),
	"name" : {
		"last" : "English"
	}
}
> var firstRecord = db.links.findOne({'name.first':'Jacky'});
> firstRecord
{
	"_id" : ObjectId("55256285281b35c268129653"),
	"name" : {
		"first" : "Jacky",
		"last" : "Emerson"
	},
	"age" : 32,
	"email" : "jacky123@gmail.com",
	"password" : "iloveyou"
}
> db.links.findOne({'_id':firstRecord._id});
{
	"_id" : ObjectId("55256285281b35c268129653"),
	"name" : {
		"first" : "Jacky",
		"last" : "Emerson"
	},
	"age" : 32,
	"email" : "jacky123@gmail.com",
	"password" : "iloveyou"
}
> db.links.find({age:{ $gt : 20}});
{ "_id" : ObjectId("552560be281b35c268129650"), "name" : { "first" : "Johny", "last" : "English" }, "age" : 45, "email" : "johnyenglish@gmail.com", "password" : "IWlove345" }
{ "_id" : ObjectId("552560bf281b35c268129651"), "name" : { "first" : "Aryan", "last" : "Malhotra" }, "age" : 25, "email" : "ryanmal@gmail.com", "password" : "BTS213" }
{ "_id" : ObjectId("5525621c281b35c268129652"), "name" : { "first" : "Rocky", "last" : "Rancho" }, "age" : 50, "email" : "rajarocky@gmail.com", "password" : "abcde" }
{ "_id" : ObjectId("55256285281b35c268129653"), "name" : { "first" : "Jacky", "last" : "Emerson" }, "age" : 32, "email" : "jacky123@gmail.com", "password" : "iloveyou" }
> db.links.find({age:{ $gt : 20}},{'name.first' : 1,'name.last':1});
{ "_id" : ObjectId("552560be281b35c268129650"), "name" : { "first" : "Johny", "last" : "English" } }
{ "_id" : ObjectId("552560bf281b35c268129651"), "name" : { "first" : "Aryan", "last" : "Malhotra" } }
{ "_id" : ObjectId("5525621c281b35c268129652"), "name" : { "first" : "Rocky", "last" : "Rancho" } }
{ "_id" : ObjectId("55256285281b35c268129653"), "name" : { "first" : "Jacky", "last" : "Emerson" } }
> db.links.find({age:{ $gt : 20}},{'name.first' : 1,'name.last':1,age:1});
{ "_id" : ObjectId("552560be281b35c268129650"), "name" : { "first" : "Johny", "last" : "English" }, "age" : 45 }
{ "_id" : ObjectId("552560bf281b35c268129651"), "name" : { "first" : "Aryan", "last" : "Malhotra" }, "age" : 25 }
{ "_id" : ObjectId("5525621c281b35c268129652"), "name" : { "first" : "Rocky", "last" : "Rancho" }, "age" : 50 }
{ "_id" : ObjectId("55256285281b35c268129653"), "name" : { "first" : "Jacky", "last" : "Emerson" }, "age" : 32 }
> db.links.find({age:{ $gt : 32}},{'name.first' : 1,'name.last':1,age:1});
{ "_id" : ObjectId("552560be281b35c268129650"), "name" : { "first" : "Johny", "last" : "English" }, "age" : 45 }
{ "_id" : ObjectId("5525621c281b35c268129652"), "name" : { "first" : "Rocky", "last" : "Rancho" }, "age" : 50 }
> db.links.find({age:{ $gte : 32}},{'name.first' : 1,'name.last':1,age:1});
{ "_id" : ObjectId("552560be281b35c268129650"), "name" : { "first" : "Johny", "last" : "English" }, "age" : 45 }
{ "_id" : ObjectId("5525621c281b35c268129652"), "name" : { "first" : "Rocky", "last" : "Rancho" }, "age" : 50 }
{ "_id" : ObjectId("55256285281b35c268129653"), "name" : { "first" : "Jacky", "last" : "Emerson" }, "age" : 32 }
> db.links.find({age:{ $lte : 50}},{'name.first' : 1,'name.last':1,age:1});
{ "_id" : ObjectId("552560be281b35c268129650"), "name" : { "first" : "Johny", "last" : "English" }, "age" : 45 }
{ "_id" : ObjectId("552560bf281b35c268129651"), "name" : { "first" : "Aryan", "last" : "Malhotra" }, "age" : 25 }
{ "_id" : ObjectId("5525621c281b35c268129652"), "name" : { "first" : "Rocky", "last" : "Rancho" }, "age" : 50 }
{ "_id" : ObjectId("55256285281b35c268129653"), "name" : { "first" : "Jacky", "last" : "Emerson" }, "age" : 32 }
> db.links.find({age:{ $lt : 50}},{'name.first' : 1,'name.last':1,age:1});
{ "_id" : ObjectId("552560be281b35c268129650"), "name" : { "first" : "Johny", "last" : "English" }, "age" : 45 }
{ "_id" : ObjectId("552560bf281b35c268129651"), "name" : { "first" : "Aryan", "last" : "Malhotra" }, "age" : 25 }
{ "_id" : ObjectId("55256285281b35c268129653"), "name" : { "first" : "Jacky", "last" : "Emerson" }, "age" : 32 }
> db.links.find({age:{ $lt : 50,$gt:32}},{'name.first' : 1,'name.last':1,age:1,_id:0});
{ "name" : { "first" : "Johny", "last" : "English" }, "age" : 45 }
> db.links.find({age:{ $lte : 50,$gte:32}},{'name.first' : 1,'name.last':1,age:1,_id:0});
{ "name" : { "first" : "Johny", "last" : "English" }, "age" : 45 }
{ "name" : { "first" : "Rocky", "last" : "Rancho" }, "age" : 50 }
{ "name" : { "first" : "Jacky", "last" : "Emerson" }, "age" : 32 }
> db.links.find({'name.first':{ $in:['Jacky','Johny']}},{'name.first' : 1,'name.last':1,age:1,_id:0});
{ "name" : { "first" : "Johny", "last" : "English" }, "age" : 45 }
{ "name" : { "first" : "Jacky", "last" : "Emerson" }, "age" : 32 }
> db.links.find({'name.first':{ $nin:['Jacky','Johny']}},{'name.first' : 1,'name.last':1,age:1,_id:0});
{ "name" : { "first" : "Aryan", "last" : "Malhotra" }, "age" : 25 }
{ "name" : { "first" : "Rocky", "last" : "Rancho" }, "age" : 50 }
> 
> db.links.find({'name.first':{ $all:['Jacky']}},{'name.first' : 1,'name.last':1,age:1,_id:0});
{ "name" : { "first" : "Jacky", "last" : "Emerson" }, "age" : 32 }
> 
> db.links.find({'name.first':{ $ne:'Jacky'}},{'name.first' : 1,'name.last':1,age:1,_id:0});
{ "name" : { "first" : "Johny", "last" : "English" }, "age" : 45 }
{ "name" : { "first" : "Aryan", "last" : "Malhotra" }, "age" : 25 }
{ "name" : { "first" : "Rocky", "last" : "Rancho" }, "age" : 50 }
> db.links.find({$or:[{'name.first':'Jacky'},{'name.last':'Malhotra'}]},{'name.first' : 1,'name.last':1,age:1,_id:0});
{ "name" : { "first" : "Aryan", "last" : "Malhotra" }, "age" : 25 }
{ "name" : { "first" : "Jacky", "last" : "Emerson" }, "age" : 32 }
> db.links.find({$nor:[{'name.first':'Jacky'},{'name.last':'Malhotra'}]},{'name.first' : 1,'name.last':1,age:1,_id:0});
{ "name" : { "first" : "Johny", "last" : "English" }, "age" : 45 }
{ "name" : { "first" : "Rocky", "last" : "Rancho" }, "age" : 50 }
> db.links.find({$and:[{'name.first':'Jacky'},{'name.last':'Malhotra'}]},{'name.first' : 1,'name.last':1,age:1,_id:0});
> db.links.find({$and:[{'name.first':'Jacky'},{'name.last':'Emerson'}]},{'name.first' : 1,'name.last':1,age:1,_id:0});
{ "name" : { "first" : "Jacky", "last" : "Emerson" }, "age" : 32 }
> 
> db.links.find({'name.first' :{$exists:true}},{'name.first' : 1,'name.last':1,age:1,_id:0});
{ "name" : { "first" : "Johny", "last" : "English" }, "age" : 45 }
{ "name" : { "first" : "Aryan", "last" : "Malhotra" }, "age" : 25 }
{ "name" : { "first" : "Rocky", "last" : "Rancho" }, "age" : 50 }
{ "name" : { "first" : "Jacky", "last" : "Emerson" }, "age" : 32 }
> db.links.insert({ "name" : { "last" : "Emerson" }, "age" : 32 });
WriteResult({ "nInserted" : 1 })
> 
> db.links.find({'name.first' :{$exists:true}},{'name.first' : 1,'name.last':1,age:1,_id:0});
{ "name" : { "first" : "Johny", "last" : "English" }, "age" : 45 }
{ "name" : { "first" : "Aryan", "last" : "Malhotra" }, "age" : 25 }
{ "name" : { "first" : "Rocky", "last" : "Rancho" }, "age" : 50 }
{ "name" : { "first" : "Jacky", "last" : "Emerson" }, "age" : 32 }
> 
> db.links.find({age:{$mod:[5,0]}},{'name.first' : 1,'name.last':1,age:1,_id:0});
{ "name" : { "first" : "Johny", "last" : "English" }, "age" : 45 }
{ "name" : { "first" : "Aryan", "last" : "Malhotra" }, "age" : 25 }
{ "name" : { "first" : "Rocky", "last" : "Rancho" }, "age" : 50 }
> db.links.find({age:{$mod:[8,0]}},{'name.first' : 1,'name.last':1,age:1,_id:0});
{ "name" : { "first" : "Jacky", "last" : "Emerson" }, "age" : 32 }
{ "name" : { "last" : "Emerson" }, "age" : 32 }
> db.links.find({age:{$not : {$mod:[8,0]}}},{'name.first' : 1,'name.last':1,age:1,_id:0});
{ "name" : { "first" : "Johny", "last" : "English" }, "age" : 45 }
{ "name" : { "first" : "Aryan", "last" : "Malhotra" }, "age" : 25 }
{ "name" : { "first" : "Rocky", "last" : "Rancho" }, "age" : 50 }
> 
> db.links.find({$where :'this.name.first === "Jacky"'},{'name.first' : 1,'name.last':1,age:1,_id:0});
{ "name" : { "first" : "Jacky", "last" : "Emerson" }, "age" : 32 }
> db.links.find({$where :'this.name.first === "Jacky"',age:32},{'name.first' : 1,'name.last':1,age:1,_id:0});
{ "name" : { "first" : "Jacky", "last" : "Emerson" }, "age" : 32 }
> 
> db.fb.remove({});
WriteResult({ "nRemoved" : 8 })
> db.links.find();
{ "_id" : ObjectId("5528c98e80bbbf77c278afad"), "id" : "X998_Y998", "from" : { "name" : "Peyton Manning", "id" : "X18" }, "message" : "Where's my contract?", "actions" : [ { "name" : "Comment", "link" : "http://www.facebook.com/X998/posts/Y998" }, { "name" : "Like", "link" : "http://www.facebook.com/X998/posts/Y998" } ], "type" : "status", "created_time" : "2010-08-02T21:27:44+0000", "updated_time" : "2010-08-02T21:27:44+0000" }
{ "_id" : ObjectId("5528c9a180bbbf77c278afae"), "id" : "X999_Y999", "from" : { "name" : "Tom Brady", "id" : "X12" }, "message" : "Looking forward to 2010!", "actions" : [ { "name" : "Comment", "link" : "http://www.facebook.com/X999/posts/Y999" }, { "name" : "Like", "link" : "http://www.facebook.com/X999/posts/Y999" } ], "type" : "status", "created_time" : "2010-08-02T21:27:44+0000", "updated_time" : "2010-08-02T21:27:44+0000" }
> db.links.distinct('id');
[ "X998_Y998", "X999_Y999" ]
> db.links.distinct('from.name');
[ "Peyton Manning", "Tom Brady" ]
> db.links.count();
7
> db.links.find({"favoriteFruit": "apple"}).count();
2
> db.links.find().forEach(printjson);
{
	"_id" : ObjectId("5528c98e80bbbf77c278afad"),
	"id" : "X998_Y998",
	"from" : {
		"name" : "Peyton Manning",
		"id" : "X18"
	},
	"message" : "Where's my contract?",
	"actions" : [
		{
			"name" : "Comment",
			"link" : "http://www.facebook.com/X998/posts/Y998"
		},
		{
			"name" : "Like",
			"link" : "http://www.facebook.com/X998/posts/Y998"
		}
	],
	"type" : "status",
	"created_time" : "2010-08-02T21:27:44+0000",
	"updated_time" : "2010-08-02T21:27:44+0000"
}
{
	"_id" : ObjectId("5528c9a180bbbf77c278afae"),
	"id" : "X999_Y999",
	"from" : {
		"name" : "Tom Brady",
		"id" : "X12"
	},
	"message" : "Looking forward to 2010!",
	"actions" : [
		{
			"name" : "Comment",
			"link" : "http://www.facebook.com/X999/posts/Y999"
		},
		{
			"name" : "Like",
			"link" : "http://www.facebook.com/X999/posts/Y999"
		}
	],
	"type" : "status",
	"created_time" : "2010-08-02T21:27:44+0000",
	"updated_time" : "2010-08-02T21:27:44+0000"
}
{
	"_id" : "5528cacaec4210b4cad426f3",
	"index" : 0,
	"guid" : "4d878d21-21a6-4cfd-a82c-32343e3d975a",
	"isActive" : true,
	"balance" : "$3,220.83",
	"picture" : "http://placehold.it/32x32",
	"age" : 38,
	"eyeColor" : "brown",
	"name" : "Mosley Rivas",
	"gender" : "male",
	"company" : "FREAKIN",
	"email" : "mosleyrivas@freakin.com",
	"phone" : "+1 (987) 500-3559",
	"address" : "564 Vanderveer Street, Sheatown, Northern Mariana Islands, 9357",
	"about" : "Excepteur anim excepteur sit Lorem adipisicing labore. Laboris occaecat culpa consectetur est id sint adipisicing culpa. Eu nulla exercitation et voluptate dolor elit sint dolore tempor reprehenderit. Irure in nostrud et ad sint.\r\n",
	"registered" : "2014-03-14T00:38:50 -06:-30",
	"latitude" : 70.974021,
	"longitude" : 57.229433,
	"tags" : [
		"ea",
		"occaecat",
		"culpa",
		"occaecat",
		"cupidatat",
		"pariatur",
		"ea"
	],
	"friends" : [
		{
			"id" : 0,
			"name" : "Browning Boyle"
		},
		{
			"id" : 1,
			"name" : "Melendez Farmer"
		},
		{
			"id" : 2,
			"name" : "Caitlin Collins"
		}
	],
	"greeting" : "Hello, Mosley Rivas! You have 10 unread messages.",
	"favoriteFruit" : "apple"
}
{
	"_id" : "5528cacafb82897f434b5edc",
	"index" : 1,
	"guid" : "411a86d2-657a-486b-9093-a1737c2edfc1",
	"isActive" : true,
	"balance" : "$2,884.50",
	"picture" : "http://placehold.it/32x32",
	"age" : 27,
	"eyeColor" : "green",
	"name" : "Casey Morse",
	"gender" : "female",
	"company" : "DATACATOR",
	"email" : "caseymorse@datacator.com",
	"phone" : "+1 (882) 422-3800",
	"address" : "699 Beard Street, Edinburg, Maryland, 2668",
	"about" : "Aute proident deserunt cillum quis quis minim exercitation. Sunt eiusmod voluptate aute sint excepteur laborum in proident. Ad qui pariatur fugiat tempor aute exercitation commodo ea. Sint qui consequat consectetur non in commodo. Tempor laboris sunt id consectetur voluptate ullamco laboris consectetur ipsum exercitation deserunt Lorem Lorem eiusmod.\r\n",
	"registered" : "2014-05-10T08:20:11 -06:-30",
	"latitude" : 38.591795,
	"longitude" : 125.382541,
	"tags" : [
		"aliquip",
		"id",
		"Lorem",
		"qui",
		"cillum",
		"esse",
		"tempor"
	],
	"friends" : [
		{
			"id" : 0,
			"name" : "Courtney Reyes"
		},
		{
			"id" : 1,
			"name" : "Lynne Hebert"
		},
		{
			"id" : 2,
			"name" : "Ella Nguyen"
		}
	],
	"greeting" : "Hello, Casey Morse! You have 1 unread messages.",
	"favoriteFruit" : "banana"
}
{
	"_id" : "5528caca7b598094121f38d7",
	"index" : 2,
	"guid" : "b639629d-1876-4df9-8548-131092d3b1d2",
	"isActive" : true,
	"balance" : "$3,367.54",
	"picture" : "http://placehold.it/32x32",
	"age" : 29,
	"eyeColor" : "blue",
	"name" : "Lily Goodwin",
	"gender" : "female",
	"company" : "KOZGENE",
	"email" : "lilygoodwin@kozgene.com",
	"phone" : "+1 (986) 527-2858",
	"address" : "189 Verona Street, Crisman, New Jersey, 3585",
	"about" : "Sit laboris cupidatat Lorem irure do est. Qui labore cillum culpa eu velit ullamco cupidatat fugiat nulla cillum. Fugiat velit proident velit cillum do mollit. Ex ipsum sint sit ad anim laboris aliquip irure velit dolore qui. Consequat fugiat id occaecat deserunt aliqua laboris.\r\n",
	"registered" : "2015-02-17T05:51:15 -06:-30",
	"latitude" : -37.316556,
	"longitude" : -145.07174,
	"tags" : [
		"anim",
		"adipisicing",
		"mollit",
		"ipsum",
		"magna",
		"laboris",
		"aliquip"
	],
	"friends" : [
		{
			"id" : 0,
			"name" : "Dana Pace"
		},
		{
			"id" : 1,
			"name" : "Beryl Pate"
		},
		{
			"id" : 2,
			"name" : "Hancock Lewis"
		}
	],
	"greeting" : "Hello, Lily Goodwin! You have 1 unread messages.",
	"favoriteFruit" : "banana"
}
{
	"_id" : "5528cacacf8aaa376cc2a37f",
	"index" : 3,
	"guid" : "960905ef-6cb8-4d7a-ae9f-f54f57f3d1b0",
	"isActive" : false,
	"balance" : "$1,340.92",
	"picture" : "http://placehold.it/32x32",
	"age" : 35,
	"eyeColor" : "blue",
	"name" : "Alexandria Meadows",
	"gender" : "female",
	"company" : "GINKLE",
	"email" : "alexandriameadows@ginkle.com",
	"phone" : "+1 (923) 494-3688",
	"address" : "686 Garden Place, Toftrees, New Mexico, 4526",
	"about" : "Tempor ullamco consectetur aliqua pariatur culpa veniam adipisicing ut commodo eiusmod excepteur esse dolor. Ut duis id consequat mollit duis. Ea sint veniam dolor non voluptate enim culpa adipisicing ex exercitation culpa eu do sint. Dolore do ut ut ipsum commodo adipisicing Lorem sunt excepteur proident.\r\n",
	"registered" : "2014-03-15T20:39:52 -06:-30",
	"latitude" : 16.609461,
	"longitude" : -154.077558,
	"tags" : [
		"ullamco",
		"nisi",
		"duis",
		"consequat",
		"occaecat",
		"esse",
		"eu"
	],
	"friends" : [
		{
			"id" : 0,
			"name" : "Eleanor Blake"
		},
		{
			"id" : 1,
			"name" : "Fry Miles"
		},
		{
			"id" : 2,
			"name" : "Emily Howard"
		}
	],
	"greeting" : "Hello, Alexandria Meadows! You have 6 unread messages.",
	"favoriteFruit" : "apple"
}
{
	"_id" : "5528cacaaf3922615c53ada8",
	"index" : 4,
	"guid" : "017fdf9d-5bc6-4277-8397-61c8d16b2285",
	"isActive" : true,
	"balance" : "$1,364.74",
	"picture" : "http://placehold.it/32x32",
	"age" : 31,
	"eyeColor" : "blue",
	"name" : "Cantrell Kline",
	"gender" : "male",
	"company" : "SYNKGEN",
	"email" : "cantrellkline@synkgen.com",
	"phone" : "+1 (837) 406-2311",
	"address" : "784 Berry Street, Caroleen, Delaware, 2880",
	"about" : "Amet cupidatat magna ex officia. Sunt laborum sit dolore deserunt et amet et nisi minim fugiat qui velit ex. Qui qui aute fugiat anim proident non.\r\n",
	"registered" : "2015-02-09T04:20:39 -06:-30",
	"latitude" : 4.526198,
	"longitude" : -173.481803,
	"tags" : [
		"laborum",
		"eiusmod",
		"cillum",
		"consequat",
		"nostrud",
		"sunt",
		"est"
	],
	"friends" : [
		{
			"id" : 0,
			"name" : "Claudette Koch"
		},
		{
			"id" : 1,
			"name" : "Reese Carrillo"
		},
		{
			"id" : 2,
			"name" : "Lancaster Crosby"
		}
	],
	"greeting" : "Hello, Cantrell Kline! You have 7 unread messages.",
	"favoriteFruit" : "strawberry"
}

> db.links.find({},{favoriteFruit: 1});
{ "_id" : ObjectId("5528c98e80bbbf77c278afad") }
{ "_id" : ObjectId("5528c9a180bbbf77c278afae") }
{ "_id" : "5528cacaec4210b4cad426f3", "favoriteFruit" : "apple" }
{ "_id" : "5528cacafb82897f434b5edc", "favoriteFruit" : "banana" }
{ "_id" : "5528caca7b598094121f38d7", "favoriteFruit" : "banana" }
{ "_id" : "5528cacacf8aaa376cc2a37f", "favoriteFruit" : "apple" }
{ "_id" : "5528cacaaf3922615c53ada8", "favoriteFruit" : "strawberry" }
> db.links.find({},{favoriteFruit: 1}).sort({favoriteFruit:-1});
{ "_id" : "5528cacaaf3922615c53ada8", "favoriteFruit" : "strawberry" }
{ "_id" : "5528cacafb82897f434b5edc", "favoriteFruit" : "banana" }
{ "_id" : "5528caca7b598094121f38d7", "favoriteFruit" : "banana" }
{ "_id" : "5528cacaec4210b4cad426f3", "favoriteFruit" : "apple" }
{ "_id" : "5528cacacf8aaa376cc2a37f", "favoriteFruit" : "apple" }
{ "_id" : ObjectId("5528c9a180bbbf77c278afae") }
{ "_id" : ObjectId("5528c98e80bbbf77c278afad") }
> db.links.find({},{favoriteFruit: 1}).sort({favoriteFruit:1});
{ "_id" : ObjectId("5528c9a180bbbf77c278afae") }
{ "_id" : ObjectId("5528c98e80bbbf77c278afad") }
{ "_id" : "5528cacaec4210b4cad426f3", "favoriteFruit" : "apple" }
{ "_id" : "5528cacacf8aaa376cc2a37f", "favoriteFruit" : "apple" }
{ "_id" : "5528cacafb82897f434b5edc", "favoriteFruit" : "banana" }
{ "_id" : "5528caca7b598094121f38d7", "favoriteFruit" : "banana" }
{ "_id" : "5528cacaaf3922615c53ada8", "favoriteFruit" : "strawberry" }
> db.links.find({},{favoriteFruit: 1}).sort({favoriteFruit:1,_id:1});
{ "_id" : ObjectId("5528c98e80bbbf77c278afad") }
{ "_id" : ObjectId("5528c9a180bbbf77c278afae") }
{ "_id" : "5528cacacf8aaa376cc2a37f", "favoriteFruit" : "apple" }
{ "_id" : "5528cacaec4210b4cad426f3", "favoriteFruit" : "apple" }
{ "_id" : "5528caca7b598094121f38d7", "favoriteFruit" : "banana" }
{ "_id" : "5528cacafb82897f434b5edc", "favoriteFruit" : "banana" }
{ "_id" : "5528cacaaf3922615c53ada8", "favoriteFruit" : "strawberry" }

> db.links.find({},{favoriteFruit: 1}).sort({favoriteFruit:1,_id:-1});
{ "_id" : ObjectId("5528c9a180bbbf77c278afae") }
{ "_id" : ObjectId("5528c98e80bbbf77c278afad") }
{ "_id" : "5528cacaec4210b4cad426f3", "favoriteFruit" : "apple" }
{ "_id" : "5528cacacf8aaa376cc2a37f", "favoriteFruit" : "apple" }
{ "_id" : "5528cacafb82897f434b5edc", "favoriteFruit" : "banana" }
{ "_id" : "5528caca7b598094121f38d7", "favoriteFruit" : "banana" }
{ "_id" : "5528cacaaf3922615c53ada8", "favoriteFruit" : "strawberry" }
> db.links.find({},{favoriteFruit: 1}).skip(0*3).limit(5);
{ "_id" : ObjectId("5528c98e80bbbf77c278afad") }
{ "_id" : ObjectId("5528c9a180bbbf77c278afae") }
{ "_id" : "5528cacaec4210b4cad426f3", "favoriteFruit" : "apple" }
{ "_id" : "5528cacafb82897f434b5edc", "favoriteFruit" : "banana" }
{ "_id" : "5528caca7b598094121f38d7", "favoriteFruit" : "banana" }
> db.links.find({},{favoriteFruit: 1}).skip(1*3).limit(5);
{ "_id" : "5528cacafb82897f434b5edc", "favoriteFruit" : "banana" }
{ "_id" : "5528caca7b598094121f38d7", "favoriteFruit" : "banana" }
{ "_id" : "5528cacacf8aaa376cc2a37f", "favoriteFruit" : "apple" }
{ "_id" : "5528cacaaf3922615c53ada8", "favoriteFruit" : "strawberry" }
> db.links.update({_id:'5528cacafb82897f434b5edc'},{favoriteFruit:'guava'});
WriteResult({ "nMatched" : 1, "nUpserted" : 0, "nModified" : 1 })
> db.links.find({_id:'5528cacafb82897f434b5edc'});
{ "_id" : "5528cacafb82897f434b5edc", "favoriteFruit" : "guava" }
> db.links.update({_id:'5528cacafb82897f434b5edc1'},{favoriteFruit:'guava'});
WriteResult({ "nMatched" : 0, "nUpserted" : 0, "nModified" : 0 })
> db.links.find({_id:'5528cacafb82897f434b5edc1'});
> db.links.update({_id:'5528cacafb82897f434b5edc1'},{favoriteFruit:'guava'},true);
WriteResult({
	"nMatched" : 0,
	"nUpserted" : 1,
	"nModified" : 0,
	"_id" : "5528cacafb82897f434b5edc1"
})
> db.links.find({_id:'5528cacafb82897f434b5edc1'});
{ "_id" : "5528cacafb82897f434b5edc1", "favoriteFruit" : "guava" }
> db.links.find({_id:'5528cacafb82897f434b5edc1'});
{ "_id" : "5528cacafb82897f434b5edc1", "favoriteFruit" : "guava" }
> db.links.update({_id:'5528cacafb82897f434b5edc1'},{$set:{category:'fruits'}});
WriteResult({ "nMatched" : 1, "nUpserted" : 0, "nModified" : 1 })
> db.links.find({_id:'5528cacafb82897f434b5edc1'});
{ "_id" : "5528cacafb82897f434b5edc1", "favoriteFruit" : "guava", "category" : "fruits" }
> db.links.update({_id:'5528cacafb82897f434b5edc1'},{$set:{category:'good fruit'}});
WriteResult({ "nMatched" : 1, "nUpserted" : 0, "nModified" : 1 })
> db.links.find({_id:'5528cacafb82897f434b5edc1'});
{ "_id" : "5528cacafb82897f434b5edc1", "favoriteFruit" : "guava", "category" : "good fruit" }
> db.links.update({_id:'5528cacafb82897f434b5edc1'},{$unset:{category:'good fruit'}});
WriteResult({ "nMatched" : 1, "nUpserted" : 0, "nModified" : 1 })
> db.links.find({_id:'5528cacafb82897f434b5edc1'});
{ "_id" : "5528cacafb82897f434b5edc1", "favoriteFruit" : "guava" }
> 

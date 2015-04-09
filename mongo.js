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





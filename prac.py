# import pyttsx3
# engine = pyttsx3.init()
# engine.say("hello")
# engine.runAndWait()
# a=int(input("Enter the number"))
# b=int(input("Enter the number"))
# print(a%b)
# aa=input("hfi")
# print(type(aa))
# name = "Akshat"
# print(len(name))
# print(name.endswith("at"))
# name = input("Enter the name")
# print(f"Good Afternoon {name}")
# s=set()
# s.add(18)
# s.add("18")
# print(s)
# print(type(s))
# age = int(input("Enter the age"))
# if(age>18):
#     print("Adult")
# elif(age<18):
#     print("Child")
# for i in range(1,10):
#     print(f"hello {i}")
# i= int(input("Enter the number"))
# res=1
# while(i>0):
#     res*=i
#     i-=1
# print(res)
# x = int(input("Enter the no for pattern"))
# for i in range(0,x):
#     print(" "*(x-i),end="")
#     print("*"*(2*i-1),end="")
#     print("")
# def fun1(a,b,c):
#     avg = (a+b+c)/3
#     print(avg)
# fun1(10,20,30)
# def rec(n):
#     if(n==0):
#         return 1
#     return n*rec(n-1)
# n=int(input("no for fact"))
# print(rec(n))
# class programmer:
#     name=""
#     salary=12000
#     language="java"
#     def __init__(self,name,salary,language):
#         self.name = name 
#         self.salry = salary
#         self.language = language 

# a = programmer("Akshat",12385487478,"c++")
# a.name="akshat"
# print(a.language)
# class train:
#     def book(self,to,fro):
#         print(f"Train is booked {fro} from {to} ")
#     def fare():
#         pass
#     def status():
#         pass
# a = train()
# a.book("Delhi","Prayagraj")
import random 
n = random.randint(1,100)
a = -1
cnt = 0 ;
while(a!=n):
    cnt+=1
    a=int(input("Enter the number for your guess"))
    if(a<n):
        print("less increase it")
    else:
        print("decrease it please!!")

print(f"you guessed it correctly in {cnt} attempts")
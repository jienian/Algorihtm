package com.hashtab;

import java.util.Scanner;

public class HashTabDemo {
    public static void main(String[] args) {
        //创建哈希表
        HashTab hashTab = new HashTab(7);
        String key = "";
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("add：添加雇员");
            System.out.println("find：查找雇员");
            System.out.println("list：显示雇员");
            System.out.println("exit：退出系统");

            key = scanner.next();
            switch (key){
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();

                    //创建雇员
                    Emp emp = new Emp(id,name);
                    hashTab.add(emp);
                    break;
                case "find":
                    System.out.println("请输入要查找的id");
                    id = scanner.nextInt();
                    hashTab.findEmpById(id);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "exit":
                    scanner.close();
                    break;
                default:break;
            }
        }
    }
}

//创建哈希表
class HashTab{
    private EmpLinkedList[] empLinkedListArray;
    private int size;

    //构造器
    public HashTab(int size){
        this.size = size;
        //初始化empLinkedListArray
        empLinkedListArray = new EmpLinkedList[size];

        //留个坑？这是不要分别初始化每个链表
        for (int i = 0; i < size; i++){
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    //添加雇员
    public void add(Emp emp){
        //根据员工的id，得到员工
        int empLindckListNo = hashFun(emp.id);

        empLinkedListArray[empLindckListNo].add(emp);
    }

    //遍历所有的链表
    public void list(){
        for (int i = 0; i < size; i++){
            empLinkedListArray[i].list(i);
        }
    }

    //根据输入的id查找雇员
    public void findEmpById(int id){
        int empLinkedListNo = hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNo].findEmpById(id);
        if (emp != null) {
            System.out.printf("在第 %d 条链表中找到 雇员 id = %d \n", (empLinkedListNo + 1), id);
        }else {
            System.out.println("在哈希表中，没有找到该雇员 ");
        }
    }

    //编写散列函数，使用一个简单的取模法
    public int hashFun(int id){
        return id % size;
    }
}

//表示一个雇员
class Emp{
    public int id;
    public String name;
    public Emp next; // next 默认为 null

    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}




//创建EmpLinkedList，表示链表
class EmpLinkedList {
    //头指针，执行第一个Emp
    private Emp head; //默认为 null

    //添加雇员
    //说明：
    //1.假定，当添加雇员时，id是自增长的，即id的分配总是从小到大的
    // 因此，我们将该雇员直接加到本链表的最后即可
    public void add(Emp emp) {
        //如果添加的是第一个雇员
        if (head == null) {
            head = emp;
            return;
        }
        //如果不是第一个雇员，则使用一个辅助的指针，帮助定位到最后
        Emp curEmp = head;
        while (true) {
            if (curEmp.next == null) {  //说明到链表最后
                break;
            }
            curEmp = curEmp.next;  //后移
        }

        //退出时，直接将emp加入链表
        curEmp.next = emp;
    }

    //遍历信息
    public void list(int no) {
        if (head == null) {  //链表为空
            System.out.println("第 " + (no+1) + " 条链表为空");
            return;
        }
        System.out.print("第 " + (no+1) + " 条链表的信息为");
        Emp curEmp = head;
        while (true) {
            System.out.printf(" =>  id = %d name = %s \n", curEmp.id, curEmp.name);

            if (curEmp.next == null) {
                break;
            }
        }
    }

    //根据id查找雇员
    public Emp findEmpById(int id){
        if (head == null){
            System.out.println("链表为空");
            return null;
        }
        //辅助指针
        Emp curEmp = head;
        while (true){
            if (curEmp.id == id){
                break;
            }

            if (curEmp.next == null){
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }
}

package juc.volatil; /**
 * volatile是java虚拟机提供的轻量级的同步机制，
 *      1.保证可见性
 *      2.不保证原子性
 *      3.禁止指令重排
 *
 *
 * 当没有数据依赖性时多线程下会发生指令重排：
 *      源代码--编译器优化的重排--指令并行的重排--内存系统的重排--最终执行的命令
 * 多线程环境中，线程交替执行，由于编译器优化重排的存在，各个线程使用的变量能否保持一致性无法确定，结果无法预测。
 *
 * volatile为什么可以禁止指令重排？
 *      先了解一个概念，内存屏障（Memory Barrier）又称为内存栅栏，是一个CPU指令，作用有2个：
 *          1.保证特定操作的执行顺序。
 *          2.保证某些变量的内存可见性（就是利用该特性实现volatile的内存可见性）。
 *      由于编译器和处理器都能执行指令重排，如果在指令间插入一条Memory Barrier，则会告诉编译器和CPU，无论什么指令都
 *      不允许和这条Memory Barrier重排，也就是说
 *
 *
 * 工作内存、主内存、无法访问其他工作内存空间。
 *
 *
 *
 */
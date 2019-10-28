package com.guide.java.asm;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.lang.reflect.Method;

/***************************************************************************
 * @className: HelloWorld
 * @date     : 2019/10/28 14:38
 * @author   : 张琰培 (zhangyanpei@vvise.com)
 * @module   : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc     : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ***********************************************************************/
public class HelloWorldByAsm {
    public static void main(String[] args) throws Exception {
        byte[] bytes = generate();
        MyClassLoader cl = new MyClassLoader();
        Class<?> clazz = cl.defineClass("com.guide.java.asm.HelloWorld", bytes);
        Method main = clazz.getMethod("main", String[].class);
        main.invoke(null, new Object[]{new String[]{}});

    }
    private static byte[] generate() {
        ClassWriter cw = new ClassWriter(0);
        cw.visit(Opcodes.V1_8, org.objectweb.asm.Opcodes.ACC_PUBLIC, "com/guide/java/asm/HelloWorld", null,
                "java/lang/Object", null);
        MethodVisitor mv = cw.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V",
                null, null);
        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitLdcInsn("HelloWorld");
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(2, 1);
        mv.visitEnd();
        return cw.toByteArray();
    }
}
class MyClassLoader extends ClassLoader {
    public Class<?> defineClass(String name, byte[] b) {
        return super.defineClass(name, b, 0, b.length);
    }
}

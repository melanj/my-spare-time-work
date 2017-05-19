	.file	"hellocl.c"
	.globl	rot13_cl
	.section	.rodata
	.align 32
	.type	rot13_cl, @object
	.size	rot13_cl, 483
rot13_cl:
	.ascii	"\t\t\t\t__kernel void rot13\t\t\t\t\t    (   __global    con"
	.ascii	"st   char*    in\t\t\t    ,   __global            char*    o"
	.ascii	"ut\t\t    )\t\t\t\t\t\t\t{\t\t\t\t\t\t\t\tprintf(\"%s\n\", i"
	.ascii	"n);\t\t\t\t    const uint index = get_global_id(0);\t\t\t\t\t"
	.ascii	"\t\t\t\t    char c=in[index];\t"
	.string	"\t\t\t\t    if (c<'A' || c>'z' || (c>'Z' && c<'a')) {\t\t        out[index] = in[index];\t\t\t\t    } else {\t\t\t\t\t\t        if (c>'m' || (c>'M' && c<'a')) {\t\t\t    out[index] = in[index]-13;\t\t\t\t} else {\t\t\t\t\t\t    out[index] = in[index]+13;\t\t\t\t}\t\t\t\t\t\t    }\t\t\t\t\t\t\t}\t\t\t\t\t\t\t"
	.text
	.globl	rot13
	.type	rot13, @function
rot13:
.LFB496:
	.cfi_startproc
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register 6
	movq	%rdi, -24(%rbp)
	movl	$0, -4(%rbp)
	movl	-4(%rbp), %eax
	movslq	%eax, %rdx
	movq	-24(%rbp), %rax
	addq	%rdx, %rax
	movzbl	(%rax), %eax
	movb	%al, -5(%rbp)
	jmp	.L2
.L8:
	cmpb	$64, -5(%rbp)
	jle	.L3
	cmpb	$122, -5(%rbp)
	jg	.L3
	cmpb	$90, -5(%rbp)
	jle	.L4
	cmpb	$96, -5(%rbp)
	jg	.L4
.L3:
	movl	-4(%rbp), %eax
	movslq	%eax, %rdx
	movq	-24(%rbp), %rax
	addq	%rax, %rdx
	movl	-4(%rbp), %eax
	movslq	%eax, %rcx
	movq	-24(%rbp), %rax
	addq	%rcx, %rax
	movzbl	(%rax), %eax
	movb	%al, (%rdx)
	jmp	.L5
.L4:
	cmpb	$109, -5(%rbp)
	jg	.L6
	cmpb	$77, -5(%rbp)
	jle	.L7
	cmpb	$96, -5(%rbp)
	jg	.L7
.L6:
	movl	-4(%rbp), %eax
	movslq	%eax, %rdx
	movq	-24(%rbp), %rax
	addq	%rax, %rdx
	movl	-4(%rbp), %eax
	movslq	%eax, %rcx
	movq	-24(%rbp), %rax
	addq	%rcx, %rax
	movzbl	(%rax), %eax
	subl	$13, %eax
	movb	%al, (%rdx)
	jmp	.L5
.L7:
	movl	-4(%rbp), %eax
	movslq	%eax, %rdx
	movq	-24(%rbp), %rax
	addq	%rax, %rdx
	movl	-4(%rbp), %eax
	movslq	%eax, %rcx
	movq	-24(%rbp), %rax
	addq	%rcx, %rax
	movzbl	(%rax), %eax
	addl	$13, %eax
	movb	%al, (%rdx)
.L5:
	addl	$1, -4(%rbp)
	movl	-4(%rbp), %eax
	movslq	%eax, %rdx
	movq	-24(%rbp), %rax
	addq	%rdx, %rax
	movzbl	(%rax), %eax
	movb	%al, -5(%rbp)
.L2:
	cmpb	$0, -5(%rbp)
	jne	.L8
	popq	%rbp
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE496:
	.size	rot13, .-rot13
	.section	.rodata
.LC0:
	.string	""
.LC1:
	.string	"rot13"
	.text
	.globl	main
	.type	main, @function
main:
.LFB497:
	.cfi_startproc
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register 6
	pushq	%rbx
	subq	$232, %rsp
	.cfi_offset 3, -24
	movq	%fs:40, %rax
	movq	%rax, -24(%rbp)
	xorl	%eax, %eax
	movabsq	$6278066737626506568, %rax
	movq	%rax, -64(%rbp)
	movl	$1684828783, -56(%rbp)
	movw	$33, -52(%rbp)
	leaq	-64(%rbp), %rax
	movq	%rax, %rdi
	call	strlen
	movq	%rax, -176(%rbp)
	leaq	-200(%rbp), %rdx
	leaq	-168(%rbp), %rax
	movq	%rax, %rsi
	movl	$1, %edi
	call	clGetPlatformIDs
	movl	%eax, -204(%rbp)
	movq	-168(%rbp), %rax
	leaq	-196(%rbp), %rcx
	leaq	-160(%rbp), %rdx
	movq	%rcx, %r8
	movq	%rdx, %rcx
	movl	$1, %edx
	movl	$4294967295, %esi
	movq	%rax, %rdi
	call	clGetDeviceIDs
	movl	%eax, -204(%rbp)
	movq	$4228, -96(%rbp)
	movq	-168(%rbp), %rax
	movq	%rax, -88(%rbp)
	movq	$0, -80(%rbp)
	leaq	-204(%rbp), %rcx
	leaq	-160(%rbp), %rdx
	leaq	-96(%rbp), %rax
	movq	%rcx, %r9
	movl	$0, %r8d
	movl	$0, %ecx
	movl	$1, %esi
	movq	%rax, %rdi
	call	clCreateContext
	movq	%rax, -136(%rbp)
	movq	-160(%rbp), %rsi
	leaq	-204(%rbp), %rdx
	movq	-136(%rbp), %rax
	movq	%rdx, %rcx
	movl	$0, %edx
	movq	%rax, %rdi
	call	clCreateCommandQueue
	movq	%rax, -128(%rbp)
	leaq	-64(%rbp), %rax
	movq	%rax, %rdi
	call	rot13
	leaq	-64(%rbp), %rax
	movq	%rax, %rdi
	call	puts
	movq	$rot13_cl, -120(%rbp)
	movq	$482, -184(%rbp)
	movq	-120(%rbp), %rax
	movq	%rax, -192(%rbp)
	leaq	-204(%rbp), %rsi
	leaq	-184(%rbp), %rcx
	leaq	-192(%rbp), %rdx
	movq	-136(%rbp), %rax
	movq	%rsi, %r8
	movl	$1, %esi
	movq	%rax, %rdi
	call	clCreateProgramWithSource
	movq	%rax, -112(%rbp)
	movq	-112(%rbp), %rax
	movl	$0, %r9d
	movl	$0, %r8d
	movl	$.LC0, %ecx
	movl	$0, %edx
	movl	$0, %esi
	movq	%rax, %rdi
	call	clBuildProgram
	movl	%eax, -204(%rbp)
	movq	-176(%rbp), %rdx
	leaq	-204(%rbp), %rcx
	movq	-136(%rbp), %rax
	movq	%rcx, %r8
	movl	$0, %ecx
	movl	$4, %esi
	movq	%rax, %rdi
	call	clCreateBuffer
	movq	%rax, -152(%rbp)
	movq	-176(%rbp), %rdx
	leaq	-204(%rbp), %rcx
	movq	-136(%rbp), %rax
	movq	%rcx, %r8
	movl	$0, %ecx
	movl	$2, %esi
	movq	%rax, %rdi
	call	clCreateBuffer
	movq	%rax, -144(%rbp)
	leaq	-204(%rbp), %rdx
	movq	-112(%rbp), %rax
	movl	$.LC1, %esi
	movq	%rax, %rdi
	call	clCreateKernel
	movq	%rax, -104(%rbp)
	leaq	-152(%rbp), %rdx
	movq	-104(%rbp), %rax
	movq	%rdx, %rcx
	movl	$8, %edx
	movl	$0, %esi
	movq	%rax, %rdi
	call	clSetKernelArg
	leaq	-144(%rbp), %rdx
	movq	-104(%rbp), %rax
	movq	%rdx, %rcx
	movl	$8, %edx
	movl	$1, %esi
	movq	%rax, %rdi
	call	clSetKernelArg
	movb	$63, -48(%rbp)
	movq	-176(%rbp), %rax
	movb	$0, -48(%rbp,%rax)
	movq	-176(%rbp), %rdx
	movq	-152(%rbp), %rsi
	leaq	-64(%rbp), %rcx
	movq	-128(%rbp), %rax
	movq	$0, 16(%rsp)
	movq	$0, 8(%rsp)
	movl	$0, (%rsp)
	movq	%rcx, %r9
	movq	%rdx, %r8
	movl	$0, %ecx
	movl	$0, %edx
	movq	%rax, %rdi
	call	clEnqueueWriteBuffer
	movl	%eax, -204(%rbp)
	leaq	-176(%rbp), %rcx
	leaq	-176(%rbp), %rdx
	movq	-104(%rbp), %rsi
	movq	-128(%rbp), %rax
	movq	$0, 16(%rsp)
	movq	$0, 8(%rsp)
	movl	$0, (%rsp)
	movq	%rcx, %r9
	movq	%rdx, %r8
	movl	$0, %ecx
	movl	$1, %edx
	movq	%rax, %rdi
	call	clEnqueueNDRangeKernel
	movl	%eax, -204(%rbp)
	movq	-176(%rbp), %rdx
	movq	-144(%rbp), %rsi
	leaq	-48(%rbp), %rcx
	movq	-128(%rbp), %rax
	movq	$0, 16(%rsp)
	movq	$0, 8(%rsp)
	movl	$0, (%rsp)
	movq	%rcx, %r9
	movq	%rdx, %r8
	movl	$0, %ecx
	movl	$0, %edx
	movq	%rax, %rdi
	call	clEnqueueReadBuffer
	movl	%eax, -204(%rbp)
	movq	-128(%rbp), %rax
	movq	%rax, %rdi
	call	clFinish
	movl	%eax, -204(%rbp)
	leaq	-48(%rbp), %rax
	movq	%rax, %rdi
	call	puts
	movq	-24(%rbp), %rbx
	xorq	%fs:40, %rbx
	je	.L10
	call	__stack_chk_fail
.L10:
	addq	$232, %rsp
	popq	%rbx
	popq	%rbp
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE497:
	.size	main, .-main
	.ident	"GCC: (Ubuntu 4.8.2-19ubuntu1) 4.8.2"
	.section	.note.GNU-stack,"",@progbits

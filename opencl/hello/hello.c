#include <stdio.h>
#include <string.h>

#include <CL/cl.h>

const char source[] = "							\
__kernel void example( __global char* buf, __global char* buf2 ){	\
       int x = get_global_id(0);					\
       buf2[x] = buf[x];						\
}";


int main() {
        char buf[]="Hello, World!";
        char build_c[4096];
        size_t srcsize, worksize=strlen(buf);

        cl_platform_id platform;
        cl_device_id device;
        cl_uint platforms, devices;
    
        /* Fetch the Platforms, we only want one. */
        clGetPlatformIDs(1, &platform, &platforms);

        /* Fetch the Devices for this platform */
        clGetDeviceIDs(platform, CL_DEVICE_TYPE_ALL, 1, &device, &devices);

        /* Create a memory context for the device we want to use  */
        cl_context_properties properties[]={CL_CONTEXT_PLATFORM, (cl_context_properties)platform,0};
        cl_context context=clCreateContext(properties, 1, &device, NULL, NULL, NULL);

        /* Create a command queue to communicate with the device */
        cl_command_queue cq = clCreateCommandQueue(context, device, 0, NULL);

	const char *src=source;
	srcsize=strlen(source);
    
        const char *srcptr[]={src};
        /* Submit the source code of the kernel to OpenCL, and create a program object with it */
        cl_program prog=clCreateProgramWithSource(context, 1, srcptr, &srcsize, NULL);

        /* Compile the kernel code (after this we could extract the compiled version) */
        clBuildProgram(prog, 0, NULL, "", NULL, NULL);

        /* Create memory buffers in the Context where the desired Device is. These will be the pointer 
        parameters on the kernel. */
        cl_mem mem1, mem2;
        mem1=clCreateBuffer(context, CL_MEM_READ_ONLY, worksize, NULL, NULL);
        mem2=clCreateBuffer(context, CL_MEM_WRITE_ONLY, worksize, NULL, NULL);

        /* Create a kernel object with the compiled program */
        cl_kernel k_example=clCreateKernel(prog, "example", NULL);

        /* Set the kernel parameters */
        clSetKernelArg(k_example, 0, sizeof(mem1), &mem1);
	clSetKernelArg(k_example, 1, sizeof(mem2), &mem2);

        /* Create a char array in where to store the results of the Kernel */
        char buf2[sizeof buf];
        buf2[0]='?';
        buf2[worksize]=0;
    
        /* Send input data to OpenCL */
        clEnqueueWriteBuffer(cq, mem1, CL_FALSE, 0, worksize, buf, 0, NULL, NULL);

        /* Tell the Device, through the command queue, to execute que Kernel */
        clEnqueueNDRangeKernel(cq, k_example, 1, NULL, &worksize, &worksize, 0, NULL, NULL);

        /* Read the result back into buf2 */
        clEnqueueReadBuffer(cq, mem2, CL_FALSE, 0, worksize, buf2, 0, NULL, NULL);

        /* Await completion of all the above */
        clFinish(cq);

        /* Finally, output the result */
        puts(buf2);
}

n=0:20;
m=-5:15;
z = zeros(21);
z(6) = 1;
 
subplot(2, 1, 1)
stem(n, z)
subplot(2, 1, 2)
stem(m, z)
 
t=abs(10-n);
figure(2)
stem(n,t)
 
n1=-15:25;
x1=sin(pi/17*n1);
n2=0:50;
x2=cos(pi/sqrt(23)*n2);
figure(3)
plot(n1,x1,'g',n2,x2,'r')
 
figure(4)
subplot(2,1,1)
plot(n1,x1)
subplot(2,1,2)
plot(n2,x2)
 
figure(5)
stem(n1,x1)
hold on
stem(n2,x2)
hold off
 
figure(6)
subplot(2,1,1)
stem(n1,x1)
subplot(2,1,2)
stem(n2,x2)


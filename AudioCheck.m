clear all
clc
[x1, Fs1] = audioread('a1.mp3');
[x2, Fs2] = audioread('a2.mp3');
%for i=387696:1:422256
%    x2(i)=0;
%end;
y1=length(x1);
y2=length(x2);
x11(y1)=0;
x22(y2)=0;
for i=1:1:y1
    x11(i)=x1(i);
end;
for i=1:1:y2
    x22(i)=x2(i);
end;
xx = [x11, x22];
yy = sqrtm(inv(cov(xx')))*(xx-repmat(mean(xx,2),1,size(xx,2))); 
[W,s,v] = svd((repmat(sum(yy.*yy,1),size(yy,1),1).*yy)*yy');

%a = W*xx; %W is unmixing matrix
a1=(W*x11);
a2=(W*x22);
%d(length(a))=0;
%for i=1:1:length(a)
%    if a(i)>max(a)/5
%        d(i)=a(i);
%    end;
%end;
%d=sgolayfilt(d,3,7);
%b=(W*x11);

subplot(2,2,1); plot(x11); title('mixed audio - mic 1');
subplot(2,2,2); plot(x22); title('mixed audio - mic 2');
subplot(2,2,3); plot(a1(1,:), 'g'); title('unmixed wave 1');
subplot(2,2,4); plot(a2(1,:),'r'); title('unmixed wave 2');
%b=log(1+0.6*(a(1,:)/max(a(1,:))))/log(1+0.6) - a(1,:);
%limit=a;

%d= sign(limit).*((1+255).^abs(limit)-1).*(1/255);
%c=((1+0.65).^(a/max(a))-1)/0.65;
%subplot(2,2,4);plot(d(1,:),'g');
player=audioplayer(a1(1,:),Fs1);
play(player);
audiowrite('unmixed1.wav', a1(1,:), Fs1);
player=audioplayer(a2(1,:),Fs1);
play(player);
audiowrite('unmixed2.wav', a2(1,:), Fs1);
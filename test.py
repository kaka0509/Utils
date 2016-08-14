def newfoo(arg1,arg2,*nkw,**kw):
    print 'arg1 is:',arg1 , 'arg2 is:',arg2 for eachNKW in nkw:
        print 'additional non-keyword arg:',eachNKW
    for eachkw in kw.keys():
        print "additional keyword arg {0}:{1}".format(eachKW,kw[eachKW])

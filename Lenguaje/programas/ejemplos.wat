(module
(type $_sig_i32ri32 (func (param i32) (result i32)))
(type $_sig_i32 (func (param i32)))
(type $_sig_ri32 (func (result i32)))
(type $_sig_void (func ))
(import "runtime" "exceptionHandler" (func $exception (type $_sig_i32)))
(import "runtime" "print" (func $print (type $_sig_i32)))
(import "runtime" "read" (func $read (type $_sig_ri32)))
(memory 2000)
(global $SP (mut i32) (i32.const 0)) ;; start of stack
(global $MP (mut i32) (i32.const 0)) ;; mark pointer
(global $NP (mut i32) (i32.const 131071996)) ;; heap 2000*64*1024-4
(start $main)
(func $main  (type $_sig_void)
(local $localsStart i32)
   (local $temp i32)
   i32.const 200  ;; let this be the stack size needed (params+locals+2)*4
   call $reserveStack  ;; returns old MP (dynamic link)
   set_local $temp
   get_global $MP
   get_local $temp
   i32.store
   get_global $MP
   get_global $SP
   i32.store offset=4
   get_global $MP
   i32.const 8
   i32.add
   set_local $localsStart
	get_local $localsStart
   i32.const 0
	i32.add
nulli32.store
	get_local $localsStart
   i32.const 4
	i32.add
   i32.const 3
   i32.const 0

i32.store
	get_local $localsStart
   i32.const 8
	i32.add
nulli32.store
	get_local $localsStart
   i32.const 12
	i32.add
   i32.const 3
null
i32.store
	get_local $localsStart
   i32.const 16
	i32.add
   i32.const 3
   i32.const 3
   i32.const 0


i32.store
	get_local $localsStart
   i32.const 20
	i32.add
nulli32.store
	get_local $localsStart
   i32.const 24
	i32.add
null
   i32.const 2
i32.add
	get_local $localsStart
   i32.const 20
	i32.add
	i32.load


i32.add
i32.store
	get_local $localsStart
   i32.const 28
	i32.add
	get_local $localsStart
   i32.const 24
	i32.add
	i32.load


i32.store
nullnullnullnull	get_local $localsStart
   i32.const 40
	i32.add
   i32.const 10
i32.store
nullnullnull	get_local $localsStart
   i32.const 44
	i32.add
nulli32.store
	get_local $localsStart
   i32.const 48
	i32.add
nulli32.store
null	get_local $localsStart
   i32.const 52
	i32.add
   i32.const 0
i32.store
null	get_local $localsStart
   i32.const 56
	i32.add
nulli32.store
nullnullnull
   call $freeStack
 )(func $reserveStack (param $size i32)
   (result i32)
   get_global $MP
   get_global $SP
   set_global $MP
   get_global $SP
   get_local $size
   i32.add
   set_global $SP
   get_global $SP
   get_global $NP
   i32.gt_u
   if
   i32.const 3
   call $exception
   end
)
(func $freeStack (type $_sig_void)
   get_global $MP
   i32.load
   i32.load offset=4
   set_global $SP
   get_global $MP
   i32.load
   set_global $MP   
))

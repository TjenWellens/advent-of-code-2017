(load "unit-test.lisp")

(load "code.lisp")

(defparameter +steps+ (list
                       (mk-offset 0   '(0 3 0 1 -3))
                       (mk-offset 0   '(1 3 0 1 -3))
                       (mk-offset 1   '(2 3 0 1 -3))
                       (mk-offset 4   '(2 4 0 1 -3))
                       (mk-offset 1   '(2 4 0 1 -2))
                       (mk-offset nil '(2 5 0 1 -2))
                       ))

(defun get-offs (index)
  (destructuring-bind
   (i offs) (nth index +steps+)
   (mk-offset i offs)))

(deftest test-next-offset ()
  (check
   (equal (apply #'next-offset (get-offs 0)) (get-offs 1))
   (equal (apply #'next-offset (get-offs 1)) (get-offs 2))
   (equal (apply #'next-offset (get-offs 2)) (get-offs 3))
   (equal (apply #'next-offset (get-offs 3)) (get-offs 4))
   (equal (apply #'next-offset (get-offs 4)) (get-offs 5))))

(deftest test-count-steps ()
  (check
   (eq 5 (count-steps 0 '(0 3 0 1 -3)))
   (eq 10 (count-steps 0 '(0 3 0 1 -3) #'next-value-part-2))))

(deftest test-suite ()
  (combine-results
   (test-next-offset)
   (test-count-steps)))

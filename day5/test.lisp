(load "unit-test.lisp")

(load "code.lisp")

(defparameter +steps+ '(
                       (0   (0 3 0 1 -3))
                       (0   (1 3 0 1 -3))
                       (1   (2 3 0 1 -3))
                       (4   (2 4 0 1 -3))
                       (1   (2 4 0 1 -2))
                       (nil (2 5 0 1 -2))
                       ))

(defun get-offs (index)
  (destructuring-bind
   (ind offs) (nth index +steps+)
   (mk-step ind (copy-list offs))))

(deftest test-next-step ()
  (check
   (equal (apply #'next-step (get-offs 0)) (get-offs 1))
   (equal (apply #'next-step (get-offs 1)) (get-offs 2))
   (equal (apply #'next-step (get-offs 2)) (get-offs 3))
   (equal (apply #'next-step (get-offs 3)) (get-offs 4))
   (equal (apply #'next-step (get-offs 4)) (get-offs 5))))

(deftest test-count-steps ()
  (check
   (eq 5 (count-steps 0 '(0 3 0 1 -3)))
   (eq 10 (count-steps 0 '(0 3 0 1 -3) #'next-value-part-2))))

(deftest test-suite ()
  (combine-results
   (test-next-step)
   (test-count-steps)))
